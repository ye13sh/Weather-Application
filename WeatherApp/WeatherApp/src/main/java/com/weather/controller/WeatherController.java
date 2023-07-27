package com.weather.controller;

import com.weather.commonDto.WeatherDto;
import com.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather/{city}")
    public WeatherDto getWeather(@PathVariable String city) throws IOException {
        return weatherService.getWeatherData(city);
    }
}
