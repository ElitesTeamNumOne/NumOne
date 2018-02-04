package com.example.hour.quarter_activity.model.sidemodel;

import android.util.Log;

import com.example.hour.quarter_activity.model.sidebean.LogBean;
import com.example.hour.quarter_activity.model.sidebean.RegBean;
import com.example.hour.quarter_activity.model.sidebean.SearchBean;
import com.example.hour.quarter_activity.utils.Api;
import com.example.hour.quarter_activity.utils.PortApi;
import com.example.hour.quarter_activity.utils.http.RetrofitUnitl;

import okhttp3.OkHttpClient;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 信徒° on 2018/1/31.
 */

public class ILogmodel {
    LoginModel model;

    public void setModel(LoginModel model) {
        this.model = model;
    }

    //定义一个登录方法
    public void LogModel(final String name, final String pass) {
        //OkHttp里面可以添加拦截器
        OkHttpClient ok = new OkHttpClient.Builder()
                .build();
        //请求数据
        RetrofitUnitl.getInstance(Api.HEAD, ok)
                .setCreate(PortApi.class)
                .getLogin(name, pass)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<LogBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(LogBean bean) {
                        model.login(bean);
                    }
                });
    }
        //定义一个注册方法
    public void RegModel(final String name, final String pass){
        //OkHttp里面可以添加拦截器
        OkHttpClient ok = new OkHttpClient.Builder()
                .build();
        //请求数据
        RetrofitUnitl.getInstance(Api.HEAD,ok)
                .setCreate(PortApi.class)
                .getReg(name,pass)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<RegBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(RegBean bean) {
                        model.reg(bean);
                    }
                });

    }
    //定义一个方法
    public void RandModel(final String keywords){
        //OkHttp里面可以添加拦截器
        OkHttpClient ok = new OkHttpClient.Builder()
                .build();
        //请求数据
        RetrofitUnitl.getInstance(Api.HEAD,ok)
                .setCreate(PortApi.class)
                .getSearch(keywords,"1")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<SearchBean>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(SearchBean bean) {
                        model.search(bean);
                    }
                });
    }
    //定义一个接口类
    public interface LoginModel {
        void  login(LogBean bean);
        void reg(RegBean bean);
        void search(SearchBean bean);
    }
}
