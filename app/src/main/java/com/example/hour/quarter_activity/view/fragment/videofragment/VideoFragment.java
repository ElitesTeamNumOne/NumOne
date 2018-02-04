package com.example.hour.quarter_activity.view.fragment.videofragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.view.adapter.Find_tab_Adapter;

import java.lang.reflect.Field;
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
    private DetailsFragment detailsFragment;//热门
    private NearbyFragment nearbyFragment;//附近
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.video_layout, container, false);
        initControls(view);

        return view;
    }

    private void initControls(View view) {

        tab = view.findViewById(R.id.tab);
        vp_ac = view.findViewById(R.id.vp_ac);

        detailsFragment = new DetailsFragment();
        nearbyFragment = new NearbyFragment();
        list_fragment = new ArrayList<>();
        list_fragment.add(detailsFragment);
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
    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        tab.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(tab, 100, 100);
            }
        });
    }

}


