package com.zhaohong;

import com.alibaba.fastjson.JSON;
import com.zhaohong.inter.WeatherInter;
import com.zhaohong.weather_po.WeatherDetail;
import com.zhaohong.weather_po.WeatherResp;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


public class WeatherImpl implements WeatherInter {

    public WeatherDetail getTodayWeather(String cityId) {
        WeatherDetail weatherDetail = getForeCastWeather(cityId, 0);
        return weatherDetail;
    }

    public WeatherDetail getForeCastWeather(String cityId, Integer afterDays) {
        WeatherResp weatherResp = getWeatherFromSojson(cityId);
        WeatherDetail weatherDetail = weatherResp.getData().getForecast().get(afterDays);
        return weatherDetail;
    }

    public WeatherResp getWeatherFromSojson(String cityId) {
        String urlStr = "http://t.weather.sojson.com/api/weather/city/";
        HttpGet httpGet = new HttpGet(urlStr + cityId);
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        WeatherResp weatherResp = null;
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            String entity = EntityUtils.toString(httpResponse.getEntity());
            System.out.println("entity = " + entity);
            weatherResp = JSON.parseObject(entity, WeatherResp.class);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return weatherResp;
    }
//
//    public static void main(String[] args) {
//        String host = "http://freecityid.market.alicloudapi.com";
//        String path = "/whapi/json/alicityweather/briefforecast3days";
//        String method = "POST";
//        String appcode = "你自己的AppCode";
//        Map<String, String> headers = new HashMap<String, String>();
//        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
//        headers.put("Authorization", "APPCODE " + appcode);
//        //根据API的要求，定义相对应的Content-Type
//        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
//        Map<String, String> querys = new HashMap<String, String>();
//        Map<String, String> bodys = new HashMap<String, String>();
//        bodys.put("cityId", "2");
//        bodys.put("token", "677282c2f1b3d718152c4e25ed434bc4");
//
//        try {
//            HttpResponse response = MyHttpUtils.doPost(host, path, headers, querys, bodys);
//            System.out.println(response.toString());
//            //获取response的body
//            //System.out.println(EntityUtils.toString(response.getEntity()));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
