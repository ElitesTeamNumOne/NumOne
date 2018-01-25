package com.example.hour.quarter_activity.model.Recommended;

import com.example.hour.quarter_activity.model.bean.AdvertisingHot;
import com.example.hour.quarter_activity.utils.Api;
import com.example.hour.quarter_activity.utils.PortApi;
import com.example.hour.quarter_activity.utils.http.HttpInterceptor;
import com.example.hour.quarter_activity.utils.http.RetrofitUnitl;

import okhttp3.OkHttpClient;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wangguojian on 2018/1/25.
 */

public class HotModel {

    public void getData(final IHotModel iHotModel){
        OkHttpClient ok = new OkHttpClient.Builder().addInterceptor(new HttpInterceptor()).build();
        RetrofitUnitl.getInstance(Api.HEAD,ok)
                .setCreate(PortApi.class)
                .getDataOne()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AdvertisingHot>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(AdvertisingHot hot) {
                        iHotModel.onSucceed(hot);
                    }
                });
    }

}
