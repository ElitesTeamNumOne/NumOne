package com.example.hour.quarter_activity.model;

import com.example.hour.quarter_activity.utils.RetrofitUnitl;
import com.example.hour.quarter_activity.view.Jokes.Api;
import com.example.hour.quarter_activity.view.Jokes.ApiServes;
import com.example.hour.quarter_activity.view.Jokes.HttpInterceptor;
import com.example.hour.quarter_activity.view.Jokes.Jokes_Bean;

import okhttp3.OkHttpClient;
import rx.Subscriber;

/**
 * Created by 王帅彪 on 2018/1/24.
 */

public class Jokes_Moudel {


    public void moudel_data(String page,final Jokes_IMoudel iMoudel){
        OkHttpClient ok = new OkHttpClient.Builder().addInterceptor(new HttpInterceptor()).build();
        RetrofitUnitl.getInstance(Api.path,ok)
                .setCreate(ApiServes.class)
                .getdata(page,"android","101")
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
