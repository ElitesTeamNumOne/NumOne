package com.example.hour.quarter_activity.utils;

import com.example.hour.quarter_activity.model.bean.AdvertisingHot;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by wangguojian on 2018/1/25.
 */

public interface PortApi {
    @GET("quarter/getAd")
    Observable<AdvertisingHot> getDataOne();
}
