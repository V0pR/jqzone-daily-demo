package com.core.observerpatternJava.service.Impl;

import com.core.observerpatternJava.service.Dispaly;

import java.util.Observable;
import java.util.Observer;

/**
 * @author wjq
 * @version 1.0
 * @Title: CurrentConditonsDisplAY
 * @Package com.core.observerpattern.service.Impl
 * @Description:
 * @date 2020/5/22 10:49
 */
public class CurrentConditonDisplay implements Dispaly, Observer {
    private float a;
    private float b;
    private float c;
    private Observable observable;

    public CurrentConditonDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.err.println(this.getClass().getSimpleName());
        System.err.println(a);
        System.err.println(b);
        System.err.println(c);

    }


    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof WeatherData) {
            WeatherData weatherData = (WeatherData)observable;
            this.a =weatherData.getA();
            this.b =weatherData.getB();
            this.c =weatherData.getC();
            display();
        }
    }
}
