package com.matanboas.stormcape;

import android.content.Context;
import android.util.Log;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class OpenWeather {

    // A private field to store the API key
    final static private String apiKey = "6625bda8b5a2606081338c8834b9e1f7";
    final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(1, TimeUnit.SECONDS)
            .connectTimeout(1, TimeUnit.SECONDS)
            .writeTimeout(1, TimeUnit.SECONDS)
            .build();


    // A method that takes a city name and returns the current weather data as a JSON string
    public void getCurrentWeather(String city, WeatherDataCallback callback) {
        // Create an instance of Retrofit with the base url and the converter factory
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of WeatherApiInterface using Retrofit
        WeatherApiInterface weatherApiInterface = retrofit.create(WeatherApiInterface.class);

        // Call the getWeatherByCity method on the interface and enqueue the request
        weatherApiInterface.getWeatherByCity(city, apiKey).enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                // Check if the response is successful and pass the body to the callback, otherwise pass null
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure(null);
                }
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                // Pass the error to the callback
                callback.onFailure(t);
            }
        });
    }


    // A method that takes a city name and returns the 5 day / 3 hour forecast data as a JSON string
    public String getForecastWeather(String city) throws IOException {
        // Construct the URL with the city name and the API key
        String url = "https://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=" + apiKey;

        // Open a connection to the URL
        URLConnection connection = new URL(url).openConnection();

        // Create a buffered reader to read the response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        // Append the response lines to a string builder
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }

        // Close the reader
        reader.close();

        // Return the JSON string
        return result.toString();
    }

    // A method that takes a latitude and longitude and returns the current weather data as a JSON string
    public String getCurrentWeather(double lat, double lon) throws IOException {
        // Construct the URL with the coordinates and the API key
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey;

        // Open a connection to the URL
        URLConnection connection = new URL(url).openConnection();

        // Create a buffered reader to read the response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        // Append the response lines to a string builder
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }

        // Close the reader
        reader.close();

        // Return the JSON string
        return result.toString();
    }

    // A method that takes a latitude and longitude and returns the 5 day / 3 hour forecast data as a JSON string
    public String getForecastWeather(double lat, double lon) throws IOException {
        // Construct the URL with the coordinates and the API key
        String url = "https://api.openweathermap.org/data/2.5/forecast?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey;

        // Open a connection to the URL
        URLConnection connection = new URL(url).openConnection();

        // Create a buffered reader to read the response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        // Append the response lines to a string builder
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }

        // Close the reader
        reader.close();

        // Return the JSON string
        return result.toString();
    }
}
