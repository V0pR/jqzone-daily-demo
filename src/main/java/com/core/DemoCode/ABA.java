package com.core.DemoCode;

import java.beans.IntrospectionException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ABA {
    AtomicInteger atomicInteger = new AtomicInteger();
    public static void main(String[] args) {
        Integer a =1;

        Integer b =a;

        Integer c= a;

        a=a+1;
        a=a-1;

        System.err.println(a);
        System.out.println(b);
        System.out.println(c);

        Object o = new Object();

        SoftReference<Object> ob = new SoftReference<Object>(o);
        WeakReference<Object> objectWeakReference = new WeakReference<>(o);

    }
}
