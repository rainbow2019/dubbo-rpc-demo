package com.zhaohong.weather_po;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author zhaohong
 * @Date 2019/11/10 12:49
 */
@Setter
@Getter
public class WeatherDetail {
    private String date;
    private String high;
    private String low;
    private String ymd;
    private String week;
    private String sunrise;
    private String sunset;
    private Double aqi;
    private String fx;
    private String fl;
    private String type;
    private String notice;
}
