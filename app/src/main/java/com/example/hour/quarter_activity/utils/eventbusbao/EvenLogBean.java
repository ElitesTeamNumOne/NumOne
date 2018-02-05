package com.example.hour.quarter_activity.utils.eventbusbao;

import com.example.hour.quarter_activity.model.sidebean.LogBean;

/**
 * Created by wangguojian on 2018/2/4.
 */

public class EvenLogBean {
    LogBean bean;

    public EvenLogBean(LogBean bean) {
        this.bean = bean;
    }

    public EvenLogBean() {
    }

    public LogBean getBean() {
        return bean;
    }

    public void setBean(LogBean bean) {
        this.bean = bean;
    }
}
