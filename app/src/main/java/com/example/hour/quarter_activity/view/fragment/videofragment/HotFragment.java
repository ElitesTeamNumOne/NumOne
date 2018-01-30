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
import com.example.hour.quarter_activity.model.bean.DataHot;
import com.example.hour.quarter_activity.presenter.Recommended.HotPresenter;
import com.example.hour.quarter_activity.view.IView.Recommended.IHotView;
import com.example.hour.quarter_activity.view.IView.VoidView.SpacesItemDecoration;
import com.example.hour.quarter_activity.view.adapter.recommended.HotAdapterOne;
import com.example.hour.quarter_activity.view.adapter.video.VideoAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 小社会 on 2018/1/24,0024.
 */

public class HotFragment extends Fragment implements IHotView {
    private List<DataHot.DataBean> list=new ArrayList<>();
    private RecyclerView recyclerview;
    HotPresenter presenter;
    VideoAdapter adapterOne;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.hot_fragment, null);
        recyclerview = view.findViewById(R.id.hot_rv);
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
        //设置布局管理器
        final StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(manager);
        adapterOne = new VideoAdapter(getActivity(),data);
        recyclerview.setAdapter(adapterOne);
        //设置item之间的间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
        recyclerview.addItemDecoration(decoration);

    }
}
