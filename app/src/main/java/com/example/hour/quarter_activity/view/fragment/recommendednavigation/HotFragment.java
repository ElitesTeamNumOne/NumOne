package com.example.hour.quarter_activity.view.fragment.recommendednavigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.model.bean.AdvertisingHot;
import com.example.hour.quarter_activity.presenter.Recommended.HotPresenter;
import com.example.hour.quarter_activity.utils.ImageGlide;
import com.example.hour.quarter_activity.view.IView.Recommended.IHotView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangguojian on 2018/1/24.
 */

public class HotFragment extends Fragment implements IHotView{
    private  View view;
    private HotPresenter presenter;
    private Banner mBanner;
    private List<AdvertisingHot.DataBean> list_Aev;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.hot_layout, container, false);
        presenter = new HotPresenter(this);
        presenter.getDataOne();
        init();
        return view;
    }
    private void init(){
        mBanner = view.findViewById(R.id.mHotBanner);
    }
    @Override
    public void onSucceed(AdvertisingHot hot) {
        List<String> uri = new ArrayList<>();
        for (int i = 0; i < hot.getData().size(); i++) {
            uri.add(hot.getData().get(i).getIcon());
        }
        mBanner.setImageLoader(new ImageGlide())
                .setImages(uri)
                .start();
    }
}
