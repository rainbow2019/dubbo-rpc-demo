package com.zhaohong;


import com.alibaba.fastjson.JSON;
import com.zhaohong.inter.WeatherInter;
import com.zhaohong.weather_po.WeatherDetail;

public class RpcClient {

    public static void main(String[] args) {
        RpcProxyClient rpcProxyClient = new RpcProxyClient();
        //动态代理
        WeatherInter weatherInter = rpcProxyClient.clientProxy(WeatherInter.class, "127.0.0.1", 8888);
        String cityId = "101030100";
        WeatherDetail todayWeather = weatherInter.getTodayWeather(cityId);
        System.out.println("todayWeather = " + JSON.toJSONString(todayWeather));
    }


}
