package com.example.hour.quarter_activity.view.Jokes;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 王帅彪 on 2018/1/24.
 */

public interface ApiServes {
    ////https://www.zhaoapi.cn/user/login?mobile=18401586879&password=123456



    //段子列表
    //https://www.zhaoapi.cn/quarter/getJokes?page=10&source=android&appVersion=101
    @GET("quarter/getJokes")
    Observable<Jokes_Bean> getdata(@Query("page") String page, @Query("source") String source
            , @Query("appVersion") String appVersion);

    //点赞
    //https://www.zhaoapi.cn/quarter/jokePraise?uid=11864&jid=1312&token=2A27DEA57FF5BAADE1A75CC224108424&source=android&appVersion=1
    @GET("quarter/jokePraise")
    Observable<Jokes_Bean> dianzan(@Query("page") String page, @Query("source") String source
            , @Query("appVersion") String appVersion);
}
