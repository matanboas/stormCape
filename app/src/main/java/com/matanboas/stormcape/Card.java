package com.matanboas.stormcape;

import org.json.JSONException;
import org.json.JSONObject;

public class Card {
    private int weatherIcon;
    private String temperature;
    private String location;

    public Card(int weatherImage, String temperature, String location) {
        this.weatherIcon = weatherImage;
        this.temperature = temperature;
        this.location = location;
    }

    public Card() {
        // set default values
        this.weatherIcon = R.mipmap.clear_sky;
        this.temperature = "0°C";
        this.location = "Unknown";
    }

    public void SetCard(WeatherData weatherData) {

        this.location = weatherData.getName();
        int temp = (int) weatherData.getMain().getTemp("metric");
        this.temperature = temp + "°C";
        String weatherIcon = weatherData.getWeather().get(0).getIcon();

        switch(weatherIcon) {
            case "01n":
                this.weatherIcon = R.mipmap.clear_sky_n;
                break;

            case "01d":
                this.weatherIcon = R.mipmap.clear_sky;
                break;

            case "02n":
                this.weatherIcon = R.mipmap.few_clouds_n;
                break;

            case "02d":
                this.weatherIcon = R.mipmap.few_clouds;
                break;

            case "03d":
                this.weatherIcon = R.mipmap.scattered_clouds_n;
                break;

            case "03n":
                this.weatherIcon = R.mipmap.scattered_clouds;
                break;


            case "04n":

            case "04d":
                this.weatherIcon = R.mipmap.broken_clouds;
                break;

            case "09n":

            case "09d":
                this.weatherIcon = R.mipmap.shower_rain;
                break;

            case "10n":
                this.weatherIcon = R.mipmap.rain_n;
                break;

            case "10d":
                this.weatherIcon = R.mipmap.rain;
                break;

            case "11n":

            case "11d":
                this.weatherIcon = R.mipmap.thunderstorm;
                break;

            case "13n":

            case "13d":
                this.weatherIcon = R.mipmap.snow;
                break;

            case "50n":

            case "50d":
                this.weatherIcon = R.mipmap.mist;
                break;

            default:
                this.weatherIcon = R.mipmap.clear_sky;
                break;

        }
    }

    public int getWeatherIcon() {
        return weatherIcon;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getLocation() {
        return location;
    }
}