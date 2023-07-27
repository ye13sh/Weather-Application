package com.weather.commonDto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class jsonconfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        
        objectMapper.registerModule(new SimpleModule().addDeserializer(WeatherDto.class, new JsonDeserial()));

        return objectMapper;
    }
}

