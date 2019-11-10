package com.zhaohong.weather_po;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author zhaohong
 * @Date 2019/11/10 12:45
 */
@Setter
@Getter
public class WeatherData {
    private String shidu;
    private Double pm25;
    private Double pm10;
    private String quality;
    private String wendu;
    private String ganmao;
    private List<WeatherDetail> forecast;
    private WeatherDetail yesterday;
}
