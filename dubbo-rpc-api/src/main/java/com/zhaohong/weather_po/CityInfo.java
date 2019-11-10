package com.zhaohong.weather_po;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author zhaohong
 * @Date 2019/11/10 12:43
 */
@Getter
@Setter
public class CityInfo {
    private String city;
    private String citykey;
    private String parent;
    private String updateTime;
}
