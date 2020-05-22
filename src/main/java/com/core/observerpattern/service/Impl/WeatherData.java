package com.core.observerpattern.service.Impl;

import com.core.observerpattern.service.Observer;
import com.core.observerpattern.service.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wjq
 * @version 1.0
 * @Title: WeatherData
 * @Package com.core.ObserverPattern.service
 * @Description:
 * @date 2020/5/21 16:52
 */
public class WeatherData implements Subject<Observer> {

    /**
     * 用于存放注册观察者
     */
    private List<Observer> observerList;

    /**
     * 天气数据参数
     *
     * @param
     */
    private float a;
    private float b;
    private float c;

    public WeatherData() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.update(a, b, c);
        }

    }

    public void setWeatherData(float a, float b, float c) {
        this.a =a;
        this.b= b;
        this.c = c;
        notifyObserver();
    }
}
