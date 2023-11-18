package com.matanboas.stormcape;

// A custom interface that has two methods: onSuccess and onFailure
public interface WeatherDataCallback {
    // A method that takes a WeatherData object as a parameter and returns nothing
    void onSuccess(WeatherData data);

    // A method that takes a Throwable object as a parameter and returns nothing
    void onFailure(Throwable error);
}
