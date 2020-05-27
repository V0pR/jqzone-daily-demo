package com.core.observerpatternJava.service.Impl;


import java.util.Observable;

/**
 * @author wjq
 * @version 1.0
 * @Title: WeatherData
 * @Package com.core.ObserverPattern.service
 * @Description:
 * @date 2020/5/21 16:52
 */
public class WeatherData extends Observable {


    /**
     * 天气数据参数
     *
     * @param
     */
    private float a;
    private float b;
    private float c;

    public void measurementSChanged() {
        setChanged();
        notifyObservers();
    }


    public void setWeatherData(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
        measurementSChanged();
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public float getC() {
        return c;
    }
}
