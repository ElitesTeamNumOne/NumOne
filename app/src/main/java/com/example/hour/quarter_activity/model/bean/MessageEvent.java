package com.example.hour.quarter_activity.model.bean;

import java.util.List;

/**
 * Created by BoBrother on 2018/2/4.
 */

public class MessageEvent {
    private List<DataHot> dataHot;

    public MessageEvent(List<DataHot> dataHot) {
        this.dataHot = dataHot;
    }

    public List<DataHot> getDataHot() {
        return dataHot;
    }

    public void setDataHot(List<DataHot> dataHot) {
        this.dataHot = dataHot;
    }

}
