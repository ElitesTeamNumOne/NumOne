package com.example.hour.quarter_activity.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.view.fragment.JokesFragment;
import com.example.hour.quarter_activity.view.fragment.RecommendedFragment;
import com.example.hour.quarter_activity.view.fragment.VideoFragment;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home_Activity extends AppCompatActivity {
    @BindView(R.id.bottom_tab_bar)
    BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);
        ButterKnife.bind(this);

        bottomTabBar.init(getSupportFragmentManager())
                .addTabItem("推荐",R.mipmap.btn_tabbar_recommend_selected,R.mipmap.btn_tabbar_recommend_normal, RecommendedFragment.class)
                .addTabItem("段子",R.mipmap.btn_tabbar_satin_selected,R.mipmap.btn_tabbar_satin_normal, JokesFragment.class)
                .addTabItem("视频",R.mipmap.btn_tabbar_video_selected,R.mipmap.btn_tabbar_video_normal, VideoFragment.class);

    }
}
