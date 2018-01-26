package com.example.hour.quarter_activity.utils;

import com.example.hour.quarter_activity.model.bean.AdvertisingHot;
import com.example.hour.quarter_activity.model.bean.DataHot;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by wangguojian on 2018/1/25.
 */

public interface PortApi {
    @GET("quarter/getAd")
    Observable<AdvertisingHot> getDataOne();
    //https://www.zhaoapi.cn/quarter/getVideos?uid=11864&type=1&page=1&source=android&appVersion=1
    @GET("quarter/getVideos")
    Observable<DataHot>getDataTwo(@Query("type") String type,@Query("page") String page);

}
