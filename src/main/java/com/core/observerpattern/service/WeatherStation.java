package com.core.observerpattern.service;

import com.core.observerpattern.service.Impl.CurrentConditonsDisplay;
import com.core.observerpattern.service.Impl.WeatherData;

/**
 * @author wjq
 * @version 1.0
 * @Title: WeatherStation
 * @Package com.core.observerpattern.service
 * @Description:
 * @date 2020/5/22 11:16
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditonsDisplay currentConditonsDisplay = new CurrentConditonsDisplay(weatherData);
        weatherData.setWeatherData(5.5f,5.4f,5.3f);
    }
}
