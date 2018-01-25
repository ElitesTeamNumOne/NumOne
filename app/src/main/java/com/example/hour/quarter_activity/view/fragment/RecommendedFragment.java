package com.example.hour.quarter_activity.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.view.adapter.RecommendedAdapter;

/**
 * Created by 小社会 on 2018/1/23,0023.
 */

public class RecommendedFragment extends Fragment{
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private RecommendedAdapter recommendedAdapter;
    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private  View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recommended_layout, container, false);
        initViews();
        return view;
    }
    private void initViews() {

        //适配器将ViewPager与Fragment绑定在一起
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
        recommendedAdapter = new RecommendedAdapter(getActivity().getSupportFragmentManager());
        mViewPager.setAdapter(recommendedAdapter);

        //将TabLayout与ViewPager绑定在一起
        mTabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);

        //指定Tab的位置
        one = mTabLayout.getTabAt(0);
        two = mTabLayout.getTabAt(1);
    }

}
