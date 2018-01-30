package com.example.hour.quarter_activity.model;


import com.example.hour.quarter_activity.model.bean.Jokes_Bean;
import com.example.hour.quarter_activity.utils.Api;
import com.example.hour.quarter_activity.utils.PortApi;
import com.example.hour.quarter_activity.utils.http.HttpInterceptor;
import com.example.hour.quarter_activity.utils.http.RetrofitUnitl;

import okhttp3.OkHttpClient;
import rx.Subscriber;

/**
 * Created by 王帅彪 on 2018/1/24.
 */

public class Jokes_Moudel {


    public void moudel_data(String page,final Jokes_IMoudel iMoudel){
        OkHttpClient ok = new OkHttpClient.Builder().addInterceptor(new HttpInterceptor()).build();
        RetrofitUnitl.getInstance(Api.path,ok)
                .setCreate(PortApi.class)
                .getdata(page)
                .subscribeOn(rx.schedulers.Schedulers.io())
                .observeOn(rx.android.schedulers.AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Jokes_Bean>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(Jokes_Bean bean) {
                        iMoudel.jokes_data(bean);

                    }
                });

    }
}
