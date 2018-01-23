package com.example.hour.quarter_activity.view.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.view.fragment.JokesFragment;
import com.example.hour.quarter_activity.view.fragment.RecommendedFragment;
import com.example.hour.quarter_activity.view.fragment.VideoFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home_Activity extends AppCompatActivity {

    @BindView(R.id.bottom_tab_bar)
    BottomTabBar bottomTabBar;
    @BindView(R.id.mSimp)
    SimpleDraweeView mSimp;
    @BindView(R.id.mSlassifyname)
    TextView mSlassifyname;
    @BindView(R.id.mWriteimage)
    ImageView mWriteimage;
    @BindView(R.id.draw)
    DrawerLayout draw;
    @BindView(R.id.mSide)
    LinearLayout mSide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);
        ButterKnife.bind(this);
        bottomTabBar.init(getSupportFragmentManager())
                .addTabItem("推荐", R.mipmap.btn_tabbar_recommend_selected, R.mipmap.btn_tabbar_recommend_normal, RecommendedFragment.class)
                .addTabItem("段子", R.mipmap.btn_tabbar_satin_selected, R.mipmap.btn_tabbar_satin_normal, JokesFragment.class)
                .addTabItem("视频", R.mipmap.btn_tabbar_video_selected, R.mipmap.btn_tabbar_video_normal, VideoFragment.class);

        mSimp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                draw.openDrawer(mSide);
            }
        });
    }

    //沉浸式
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
