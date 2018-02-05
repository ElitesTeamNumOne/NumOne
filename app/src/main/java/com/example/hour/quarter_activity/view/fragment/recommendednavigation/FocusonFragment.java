package com.example.hour.quarter_activity.view.fragment.recommendednavigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.model.bean.AdvertisingHot;
import com.example.hour.quarter_activity.model.bean.DataHot;
import com.example.hour.quarter_activity.presenter.Recommended.HotPresenter;
import com.example.hour.quarter_activity.view.IView.Recommended.IHotView;
import com.example.hour.quarter_activity.view.adapter.recommended.HotAdapterOne;
import com.youth.banner.Banner;

import java.util.List;

/**
 * Created by wangguojian on 2018/1/24.
 */

public class FocusonFragment extends Fragment implements IHotView {
    private  View view;
    private HotPresenter presenter;
    private Banner mBanners;
    private RecyclerView mRecyclerView;
    private List<AdvertisingHot.DataBean> list_Aev;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.focuson_layout, container, false);
        presenter = new HotPresenter(this);
        presenter.getDataOne();
        presenter.getDataTwo();
        init();
        return view;
    }
    private void init(){
        mBanners = view.findViewById(R.id.mHotBanner);
        mRecyclerView = view.findViewById(R.id.mHotRecyler);
    }


    @Override
    public void onSucceed(AdvertisingHot hot) {

    }

    @Override
    public void onSucceedTwo(DataHot dataHot) {
        List<DataHot.DataBean> data = dataHot.getData();
        HotAdapterOne adapterOne = new HotAdapterOne(getActivity(),data);
        LinearLayoutManager lm  = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(lm);
        mRecyclerView.setAdapter(adapterOne);
    }
}
