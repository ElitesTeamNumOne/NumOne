package com.example.hour.quarter_activity.utils;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by wangguojian on 2018/1/23.
 */

public class MyApp extends Application{
    private static MyApp instance;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
    public static synchronized MyApp getInstance() {
        return instance;
    }
}
