package com.example.hour.quarter_activity.view.fragment.videofragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.view.adapter.Find_tab_Adapter;
import com.example.hour.quarter_activity.view.fragment.videofragment.HotFragment;
import com.example.hour.quarter_activity.view.fragment.videofragment.NearbyFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangguojian on 2018/1/23.
 */

public class VideoFragment extends Fragment {
    private   TabLayout tab;
    private ViewPager vp_ac;
    private Find_tab_Adapter find_tab_adapter;//适配器
    private List<String> listName;  //tab名称列表
    private List<Fragment> list_fragment;   //定义要装fragment的列表
    private HotFragment hotFragment;//热门
    private NearbyFragment nearbyFragment;//附近
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.video_layout,null);

        initControls(view);

        return view;
    }

    private void initControls(View view) {

        tab = view.findViewById(R.id.tab);
        vp_ac = view.findViewById(R.id.vp_ac);

        hotFragment = new HotFragment();
        nearbyFragment = new NearbyFragment();
        list_fragment = new ArrayList<>();
        list_fragment.add(hotFragment);
        list_fragment.add(nearbyFragment);

        listName  = new ArrayList<>();
        listName.add("热门");
        listName.add("附近");

        //设置TabLayout的模式
        tab.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        tab.addTab(tab.newTab().setText(listName.get(0)));
        tab.addTab(tab.newTab().setText(listName.get(1)));

        find_tab_adapter = new Find_tab_Adapter(getActivity().getSupportFragmentManager(),list_fragment,listName);

        //viewpager加载adapter
        vp_ac.setAdapter(find_tab_adapter);
        //tab_FindFragment_title.setViewPager(vp_FindFragment_pager);
        //TabLayout加载viewpager
        tab.setupWithViewPager(vp_ac);



    }
    }


