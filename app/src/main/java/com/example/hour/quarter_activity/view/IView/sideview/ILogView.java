package com.example.hour.quarter_activity.view.IView.sideview;

import com.example.hour.quarter_activity.model.sidebean.LogBean;
import com.example.hour.quarter_activity.model.sidebean.RegBean;

/**
 * Created by 信徒° on 2018/1/31.
 */

public interface ILogView {
    //登录成功
    void  onLogScuss(LogBean bean);
    //注册成功
    void  onRegScuss(RegBean bean);

}
