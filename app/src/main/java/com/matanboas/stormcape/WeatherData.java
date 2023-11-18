package com.matanboas.stormcape;

import java.util.List;

// A class that represents the root object
public class WeatherData {
    private Coord coord;
    private List<Weather> weather;
    private String base;
    private MainData main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;

    public WeatherData() {
    }

    public String getName() {
        return this.name;
    }

    public MainData getMain() {
        return this.main;
    }

    public List<Weather> getWeather() {
        return this.weather;
    }
}