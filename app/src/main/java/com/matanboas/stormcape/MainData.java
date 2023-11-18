package com.matanboas.stormcape;

// A class that represents the main object
public class MainData {
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private int pressure;
    private int humidity;
    // getters and setters omitted for brevity
    public double getTemp(String unit) {
        // the temperature is returned in Kelvin, so we need to convert it to Celsius or Fahrenheit
        if (unit.equals("metric")) {
            return this.temp - 273.15;
        } else if (unit.equals("imperial")) {
            return (this.temp - 273.15) * 9 / 5 + 32;
        } else {
            return this.temp;
        }
    }
}
