package com.example.hour.quarter_activity.presenter.Recommended;

import com.example.hour.quarter_activity.model.Recommended.HotModel;
import com.example.hour.quarter_activity.model.Recommended.IHotModel;
import com.example.hour.quarter_activity.model.Recommended.IHotModelTwo;
import com.example.hour.quarter_activity.model.bean.AdvertisingHot;
import com.example.hour.quarter_activity.model.bean.DataHot;
import com.example.hour.quarter_activity.view.IView.Recommended.IHotView;

/**
 * Created by wangguojian on 2018/1/25.
 */

public class HotPresenter {
    public IHotView view;
    public HotModel model;
    public HotPresenter(IHotView view) {
        this.view = view;
        this.model = new HotModel();
    }
    public void getDataOne(){
        model.getData(new IHotModel() {
            @Override
            public void onSucceed(AdvertisingHot hot) {
                if(view != null){
                    view.onSucceed(hot);
                }
            }
        });
    }
    public void getDataTwo(){
        model.getDataTwo(new IHotModelTwo() {
            @Override
            public void onSucceed(DataHot dataHot) {
                if(view!=null){
                    view.onSucceedTwo(dataHot);
                }
            }
        });
    }

}
