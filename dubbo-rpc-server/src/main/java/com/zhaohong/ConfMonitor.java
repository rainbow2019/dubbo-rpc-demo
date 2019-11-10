package com.zhaohong;

import java.util.HashMap;
import java.util.Map;

public class ConfMonitor {

    //根据接口名称获取实现类
    public static Map<String, Class> conf = new HashMap<String, Class>();

    static {
        conf.put("com.zhaohong.inter.WeatherInter", WeatherImpl.class);
    }
}
