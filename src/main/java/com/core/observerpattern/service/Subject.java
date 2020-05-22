package com.core.observerpattern.service;

/**
 * @author wjq
 * @version 1.0
 * @Title: Subject
 * @Package com.core.ObserverPattern.service
 * @Description:
 * @date 2020/5/21 16:48
 */
public interface Subject<T> {
    
    void registerObserver(T t);

    void removeObserver(T t);

    void notifyObserver();

}
