package com.example.hour.quarter_activity.presenter.sidepresenter;

import com.example.hour.quarter_activity.model.sidebean.LogBean;
import com.example.hour.quarter_activity.model.sidebean.RegBean;
import com.example.hour.quarter_activity.model.sidebean.SearchBean;
import com.example.hour.quarter_activity.model.sidemodel.ILogmodel;
import com.example.hour.quarter_activity.view.IView.sideview.ILogView;

/**
 * Created by 信徒° on 2018/1/31.
 */

public class LogPresenter implements ILogmodel.LoginModel{
    ILogView view;
    ILogmodel model;

    public LogPresenter(ILogView view) {
        this.view = view;
        model = new ILogmodel();
        model.setModel(this);
    }

    @Override
    public void login(LogBean bean) {
        view.onLogScuss(bean);
    }

    @Override
    public void reg(RegBean bean) {
        view.onRegScuss(bean);
    }

    @Override
    public void search(SearchBean bean) {
        view.onRandScuss(bean);
    }


    //定义登录的方法
    public void LogPer(String name, String pass){
        model.LogModel(name,pass);
    }
    //定义注册的方法
    public void RegPer(String name,String pass){
        model.RegModel(name,pass);
    }
    //定义搜索的方法
    public void RandPer(String keywords){
        model.RandModel(keywords);
    }
}
