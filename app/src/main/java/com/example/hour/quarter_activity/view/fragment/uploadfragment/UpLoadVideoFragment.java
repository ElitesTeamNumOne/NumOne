package com.example.hour.quarter_activity.view.fragment.uploadfragment;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.presenter.uploadpresenter.UpLoadPresenter;
import com.example.hour.quarter_activity.view.IView.uploadview.UpLoadView;

/**
 * Created by HP on 2018/1/24.
 */

public class UpLoadVideoFragment extends BaseFragment<UpLoadPresenter> implements UpLoadView {

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void onSucceed(Object object) {

    }

    @Override
    public void onFail(String str) {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new UpLoadPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_upvideo;
    }

    @Override
    protected void initData() {
//        startActivity(new Intent(getActivity(),ceshi_Activity.class));

    }
}
