package com.example.hour.quarter_activity.utils;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.mob.MobSDK;

/**
 * Created by wangguojian on 2018/1/23.
 */

public class MyApplication extends Application{
    private static MyApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
       MobSDK.init(this);

    }
    public static synchronized MyApplication getInstance() {
        return instance;
    }


}
