package com.zhaohong.weather_po;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author zhaohong
 * @Date 2019/11/10 12:41
 */
@Getter
@Setter
public class WeatherResp {
    private String message;
    private Integer code;
    private Date time;
    private Date date;
    private CityInfo cityInfo;
    private WeatherData data;
}
