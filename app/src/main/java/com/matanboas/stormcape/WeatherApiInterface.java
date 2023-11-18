package com.matanboas.stormcape;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// An interface that defines the API endpoint for getting weather data by city name
public interface WeatherApiInterface {
    // A GET method that takes the city name and the API key as query parameters
    @GET("http://api.openweathermap.org/data/2.5/weather")
    Call<WeatherData> getWeatherByCity(@Query("q") String city, @Query("appid") String apiKey);
}
