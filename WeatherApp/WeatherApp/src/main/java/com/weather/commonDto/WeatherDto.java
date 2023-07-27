package com.weather.commonDto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Map;

@JsonDeserialize(using = JsonDeserial.class)
public class WeatherDto {
    private String name;
    private WeatherMain main;

    public WeatherDto(String name, WeatherMain main) {
        this.name = name;
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeatherMain getMain() {
        return main;
    }

    public void setMain(WeatherMain main) {
        this.main = main;
    }

    //Custom setter to map the parameters
//    public void setMain(Map<String, Object> main) {
//        double temp = (double) main.get("temp");
//        int humidity = (int) main.get("humidity");
//        this.main = new WeatherMain(temp,humidity);
//    }
    @JsonCreator
    public static WeatherDto createWeatherDto(Map<String, Object> map) {
        String name = (String) map.get("name");
        Map<String, Object> mainMap = (Map<String, Object>) map.get("main");
        double temp = (double) mainMap.get("temp");
        int humidity = (int) mainMap.get("humidity");
        WeatherMain main = new WeatherMain(temp, humidity);
        return new WeatherDto(name, main);
    }
}
