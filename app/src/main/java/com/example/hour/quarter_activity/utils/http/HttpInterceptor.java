package com.example.hour.quarter_activity.utils.http;

import android.os.Build;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wangguojian on 2018/1/25.
 */
public class HttpInterceptor implements Interceptor {
    private static final String UA = "User-Agent";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .addHeader(UA, makeUA())
                .build();
        if (request.method().equals("GET")) {
            HttpUrl httpUrl = request.url()
                    .newBuilder()
                    .addQueryParameter("source","android")
                    .addQueryParameter("appVersion", "1")
                    .build();
            request = request.newBuilder().url(httpUrl).build();
        }
        return chain.proceed(request);
    }

    private String makeUA() {
        return Build.BRAND + "/" + Build.MODEL + "/" + Build.VERSION.RELEASE;
    }
}
