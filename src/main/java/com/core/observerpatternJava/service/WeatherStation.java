package com.core.observerpatternJava.service;

import com.core.observerpatternJava.service.Impl.CurrentConditonDisplay;
import com.core.observerpatternJava.service.Impl.CurrentConditonDisplay2;
import com.core.observerpatternJava.service.Impl.WeatherData;

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
        CurrentConditonDisplay conditonDisplay = new CurrentConditonDisplay(weatherData);
        CurrentConditonDisplay2 currentConditonDisplay2 = new CurrentConditonDisplay2(weatherData);
        weatherData.setWeatherData(5.5f,5.4f,5.3f);

    }
}
