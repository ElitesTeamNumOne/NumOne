package com.example.hour.quarter_activity.view.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.view.fragment.JokesFragment;
import com.example.hour.quarter_activity.view.fragment.recommendednavigation.RecommendedFragment;
import com.example.hour.quarter_activity.view.fragment.videofragment.VideoFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;
import com.nineoldandroids.view.ViewHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home_Activity extends FragmentActivity {
    @BindView(R.id.bottom_tab_bar)
    BottomTabBar bottomTabBar;
    @BindView(R.id.mSimp)
    SimpleDraweeView mSimp;
    @BindView(R.id.mSlassifyname)
    TextView mSlassifyname;
    @BindView(R.id.mWriteimage)
    ImageView mWriteimage;
    @BindView(R.id.id_drawerLayout)
    DrawerLayout idDrawerLayout;
    private String names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        //底部按钮
        bottomTabBar.init(getSupportFragmentManager())
                .addTabItem("推荐", R.mipmap.btn_tabbar_recommend_selected, R.mipmap.btn_tabbar_recommend_normal, RecommendedFragment.class)
                .addTabItem("段子", R.mipmap.btn_tabbar_satin_selected, R.mipmap.btn_tabbar_satin_normal, JokesFragment.class)
                .addTabItem("视频", R.mipmap.btn_tabbar_video_selected, R.mipmap.btn_tabbar_video_normal, VideoFragment.class);
        bottomTabBar.setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
            @Override
            public void onTabChange(int position, String name) {
                names = name;
                mSlassifyname.setText(name);
            }
        });
        mSlassifyname.setText("推荐");
        //调用侧拉的两个方法
        initEvents();
        initView();
        //辛佳奇
        mSimp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idDrawerLayout.openDrawer(Gravity.LEFT);
                idDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED,
                        Gravity.LEFT);
            }
        });
        mWriteimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Activity.this,UpLoadActivity.class));
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
    //侧栏栏
    private void initEvents()
    {
        idDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener()
        {
            @Override
            public void onDrawerStateChanged(int newState)
            {
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset)
            {
                View mContent = idDrawerLayout.getChildAt(0);
                View mMenu = drawerView;
                float scale = 1 - slideOffset;
                float rightScale = 0.8f + scale * 0.2f;

                if (drawerView.getTag().equals("LEFT")){

                    float leftScale = 1 - 0.3f * scale;

                    ViewHelper.setScaleX(mMenu, leftScale);
                    ViewHelper.setScaleY(mMenu, leftScale);
                    ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * (1 - scale));
                    ViewHelper.setTranslationX(mContent,
                            mMenu.getMeasuredWidth() * (1 - scale));
                    ViewHelper.setPivotX(mContent, 0);
                    ViewHelper.setPivotY(mContent,
                            mContent.getMeasuredHeight() / 2);
                    mContent.invalidate();
                    ViewHelper.setScaleX(mContent, rightScale);
                    ViewHelper.setScaleY(mContent, rightScale);
                } else
                {
                    ViewHelper.setTranslationX(mContent,
                            -mMenu.getMeasuredWidth() * slideOffset);
                    ViewHelper.setPivotX(mContent, mContent.getMeasuredWidth());
                    ViewHelper.setPivotY(mContent,
                            mContent.getMeasuredHeight() / 2);
                    mContent.invalidate();
                    ViewHelper.setScaleX(mContent, rightScale);
                    ViewHelper.setScaleY(mContent, rightScale);
                }

            }

            @Override
            public void onDrawerOpened(View drawerView){

            }

            @Override
            public void onDrawerClosed(View drawerView)
            {
                idDrawerLayout.setDrawerLockMode(
                        DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.RIGHT);
            }
        });
    }
    //侧拉栏
    private void initView()
    {
        idDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerLayout);
        idDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED,
                Gravity.LEFT);
    }
}
