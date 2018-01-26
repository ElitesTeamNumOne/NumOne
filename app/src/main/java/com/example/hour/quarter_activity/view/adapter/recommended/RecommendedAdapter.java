package com.example.hour.quarter_activity.view.adapter.recommended;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.hour.quarter_activity.view.fragment.recommendednavigation.FocusonFragment;
import com.example.hour.quarter_activity.view.fragment.recommendednavigation.HotFragment;

/**
 * Created by wangguojian on 2018/1/24.
 */

public class RecommendedAdapter extends FragmentPagerAdapter {

    private String[] mTitles = new String[]{"热门", "关注"};

    public RecommendedAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new FocusonFragment();
        }
        return new HotFragment();
}

    @Override
    public int getCount() {
        return mTitles.length;
    }

    //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
