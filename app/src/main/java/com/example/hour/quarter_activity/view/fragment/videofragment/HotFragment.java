package com.example.hour.quarter_activity.view.fragment.videofragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.model.bean.AdvertisingHot;
import com.example.hour.quarter_activity.model.bean.Bean;
import com.example.hour.quarter_activity.model.bean.DataHot;
import com.example.hour.quarter_activity.presenter.Recommended.HotPresenter;
import com.example.hour.quarter_activity.view.IView.Recommended.IHotView;
import com.example.hour.quarter_activity.view.IView.Recommended.IHotViewTwo;
import com.example.hour.quarter_activity.view.adapter.void_Hotadapter.RecyclerviewAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 小社会 on 2018/1/24,0024.
 */

public class HotFragment extends Fragment implements IHotView {
    private List<DataHot.DataBean> list=new ArrayList<>();
    private RecyclerView recyclerview;
    private RecyclerviewAdapter adapter;
    HotPresenter presenter;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.hot_fragment, null);
        presenter = new HotPresenter(this);
        presenter.getDataTwo();


        return view;
    }


    @Override
    public void onSucceed(AdvertisingHot hot) {

    }

    @Override
    public void onSucceedTwo(DataHot dataHot) {
        List<DataHot.DataBean> data = dataHot.getData();
        recyclerview = view.findViewById(R.id.hot_recyclerView);
        //设置布局管理器
        final StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(manager);
        //设置适配器
        adapter = new RecyclerviewAdapter(getActivity(),data);
        recyclerview.setAdapter(adapter);
    }
}
