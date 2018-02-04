package com.example.hour.quarter_activity.view.activity.sideactivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.view.activity.sideactivity.noticefragment.NeawFragment;
import com.example.hour.quarter_activity.view.activity.sideactivity.noticefragment.NewxFragment;
import com.example.hour.quarter_activity.view.adapter.recommended.RecommendedAdapter;
import com.example.hour.quarter_activity.view.fragment.recommendednavigation.FocusonFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Notice_Activity extends AppCompatActivity {

    @BindView(R.id.notice_fh)
    ImageView noticeFh;
    @BindView(R.id.notice_tab)
    TabLayout noticeTab;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    List<String> listStr; //用于存放添加Fragment的结合
    List<Fragment> listTv;//用于存放Fragment的集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        ButterKnife.bind(this);
        //隐藏头
        getSupportActionBar().hide();
        //跳转实现
        initJump();
        initViews();
    }

    private void initViews() {
        //TabLayout的横向布局  添加数据
        listStr = new ArrayList();
        listStr.add("消息");
        listStr.add("私信");
        listTv = new ArrayList<>();
        //第一个Fragment界面
        listTv.add(new NeawFragment());
        listTv.add(new NewxFragment());
        //拿到适配器
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        //ViewpAge的预加载解决方法
        viewPager.setOffscreenPageLimit(listTv.size());
        //TabLayout和ViewPage进行联动
        noticeTab.setupWithViewPager(viewPager);

    }

    private void initJump() {
        noticeFh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //ViewPage的适配器
    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return listTv.get(position);
        }

        @Override
        public int getCount() {
            return listTv.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return listStr.get(position);
        }
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
        noticeTab.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(noticeTab, 100, 100);
            }
        });
    }

}
