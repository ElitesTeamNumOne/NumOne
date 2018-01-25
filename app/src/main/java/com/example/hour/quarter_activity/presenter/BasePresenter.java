package com.example.hour.quarter_activity.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.example.hour.quarter_activity.utils.MyApplication;
import com.example.hour.quarter_activity.view.IView.BaseView;

import java.util.Map;

/**
 * Created by HP on 2018/1/24.
 */
public class BasePresenter<T extends BaseView> {

    protected T mView;

    public T getView() {
        return mView;
    }

    public void attachView(T t) {
        this.mView = t;
    }

    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }

    public Context context(){
        if (mView!=null){
            return mView.context();
        }
        return MyApplication.getInstance();
    }

    public void isEmpty(Map<String ,String> map){
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (TextUtils.isEmpty(entry.getValue())){
                mView.onFail(entry.getKey()+"为空");
                return;
            }
        }
    }

}
