package com.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.commonDto.WeatherDto;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherService {
    private final String apiKey = "ce7e5adae5d5c2c73fb46bc5ea039bfa";
    private final String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";

    private final OkHttpClient httpClient = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public WeatherDto getWeatherData(String city) throws IOException {
        String url = String.format(apiUrl, city, apiKey);
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = httpClient.newCall(request).execute();
        String responseBody = response.body().string();
        return objectMapper.readValue(responseBody, WeatherDto.class);
    }
}
