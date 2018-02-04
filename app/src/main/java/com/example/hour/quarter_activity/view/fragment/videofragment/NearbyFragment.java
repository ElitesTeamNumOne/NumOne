package com.example.hour.quarter_activity.view.fragment.videofragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.example.hour.quarter_activity.view.adapter.video.VideoAdapter;
import com.example.hour.quarter_activity.view.adapter.video.VideoDetailsAdapter;

import java.util.List;

/**
 * Created by 小社会 on 2018/1/24,0024.
 */

public class NearbyFragment extends Fragment implements IHotView {
    private RecyclerView recyclerview;
    HotPresenter presenter;
    VideoDetailsAdapter adapterVda;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =View.inflate(getActivity(), R.layout.nearby_fragment,null);
        recyclerview = view.findViewById(R.id.rv_Nf);
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
        adapterVda = new VideoDetailsAdapter(getActivity(),data);
        recyclerview.setAdapter(adapterVda);
        //设置item之间的间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
        recyclerview.addItemDecoration(decoration);
    }
}
