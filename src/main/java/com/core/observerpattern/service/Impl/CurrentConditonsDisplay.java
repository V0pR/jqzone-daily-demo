package com.core.observerpattern.service.Impl;

import com.core.observerpattern.service.Observer;
import com.core.observerpattern.service.Dispaly;
import com.core.observerpattern.service.Subject;

/**
 * @author wjq
 * @version 1.0
 * @Title: CurrentConditonsDisplAY
 * @Package com.core.observerpattern.service.Impl
 * @Description:
 * @date 2020/5/22 10:49
 */
public class CurrentConditonsDisplay implements Dispaly, Observer {
    private float a;
    private float b;
    private float c;
    private Subject weatherData;

    public CurrentConditonsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.err.println(a);
        System.err.println(b);
        System.err.println(c);

    }

    @Override
    public void update(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
        display();
    }
}
