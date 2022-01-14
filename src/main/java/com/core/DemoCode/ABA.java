package com.core.DemoCode;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.http.util.TextUtils;

import java.beans.IntrospectionException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ABA {
    AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        //Integer a =1;
        //
        //Integer b =a;
        //
        //Integer c= a;
        //
        //a=a+1;……
        //a=a-1;
        //System.err.println(a);
        //System.out.println(b);
        //System.out.println(c);
        //
        //Object o = new Object();
        //
        //SoftReference<Object> ob = new SoftReference<Object>(o);
        //WeakReference<Object> objectWeakReference = new WeakReference<>(o);
        Long time = 1635497634000L;
        //System.err.println(DateFormatUtils.format(new Date(1635497634000L / 1000), "yyyy-MM-dd HH:mm:ss"));
        //System.err.println( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(1635497634000L/ 1000)));
        Optional.ofNullable(time).ifPresent(r -> System.err.println(DateFormatUtils.format(new Date(time), "yyyy-MM-dd HH:mm:ss")));
    }

}
