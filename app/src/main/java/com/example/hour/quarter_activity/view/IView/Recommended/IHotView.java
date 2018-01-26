package com.example.hour.quarter_activity.view.IView.Recommended;

import com.example.hour.quarter_activity.model.bean.AdvertisingHot;
import com.example.hour.quarter_activity.model.bean.DataHot;

/**
 * Created by wangguojian on 2018/1/25.
 */

public interface IHotView {

    void onSucceed(AdvertisingHot hot);
    void onSucceedTwo(DataHot dataHot);

}
