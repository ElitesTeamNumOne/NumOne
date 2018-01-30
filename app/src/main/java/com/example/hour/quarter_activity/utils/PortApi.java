package com.example.hour.quarter_activity.utils;

import com.example.hour.quarter_activity.model.bean.AdvertisingHot;
import com.example.hour.quarter_activity.model.bean.DataHot;
import com.example.hour.quarter_activity.model.bean.Jokes_Bean;

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


    //段子列表
    //https://www.zhaoapi.cn/quarter/getJokes?page=10&source=android&appVersion=101
    @GET("quarter/getJokes")
    Observable<Jokes_Bean> getdata(@Query("page") String page);

    //段子点赞
    //https://www.zhaoapi.cn/quarter/jokePraise?uid=11864&jid=1312&token=2A27DEA57FF5BAADE1A75CC224108424&source=android&appVersion=1
    @GET("quarter/jokePraise")
    Observable<Jokes_Bean> dianzan(@Query("page") String page, @Query("source") String source
            , @Query("appVersion") String appVersion);
}
