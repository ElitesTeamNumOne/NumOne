package com.example.hour.quarter_activity.view.activity.sideactivity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.view.activity.sideactivity.worksfragment.LocalFragment;
import com.example.hour.quarter_activity.view.activity.sideactivity.worksfragment.UploadFragment;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Works_Activity extends AppCompatActivity {

    @BindView(R.id.works_fh)
    ImageView worksFh;
    @BindView(R.id.works_tab)
    TabLayout worksTab;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    List<String> listStr; //用于存放添加Fragment的结合
    List<Fragment> listTv;//用于存放Fragment的集合
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_works);
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
        listStr.add("本地作品");
        listStr.add("已上传");
        listTv = new ArrayList<>();
        //第一个Fragment界面
        listTv.add(new LocalFragment());
        listTv.add(new UploadFragment());
        //拿到适配器
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        //ViewpAge的预加载解决方法
        viewPager.setOffscreenPageLimit(listTv.size());
        //TabLayout和ViewPage进行联动
        worksTab.setupWithViewPager(viewPager);
    }

    private void initJump() {
        worksFh.setOnClickListener(new View.OnClickListener() {
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
}
