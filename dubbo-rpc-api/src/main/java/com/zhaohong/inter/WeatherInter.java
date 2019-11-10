package com.zhaohong.inter;

import com.zhaohong.weather_po.WeatherDetail;

public interface WeatherInter {
    public WeatherDetail getTodayWeather(String cityId);

    public WeatherDetail getForeCastWeather(String cityId,Integer afterDays);
}
