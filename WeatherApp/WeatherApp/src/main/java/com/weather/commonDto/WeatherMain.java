package com.weather.commonDto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherMain {
    private Double temp;

    private Integer humidity;
    @JsonCreator
    public WeatherMain(@JsonProperty("temp") Double temp,@JsonProperty("humidity") Integer humidity) {
        this.temp = temp;
        this.humidity = humidity;
    }


    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }
}
