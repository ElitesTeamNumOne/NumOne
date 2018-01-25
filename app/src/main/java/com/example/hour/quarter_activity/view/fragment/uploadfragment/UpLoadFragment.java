package com.example.hour.quarter_activity.view.fragment.uploadfragment;

import android.view.View;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.model.UpLoadEvent;
import com.example.hour.quarter_activity.view.fragment.uploadfragment.BaseOrdinaryFragment;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by HP on 2018/1/24.
 */


public class UpLoadFragment extends BaseOrdinaryFragment {

    @BindView(R.id.circleimageview1)
    SimpleDraweeView mCircleimageview1;
    @BindView(R.id.circleimageview2)
    SimpleDraweeView mCircleimageview2;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_up;
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.circleimageview1, R.id.circleimageview2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.circleimageview1:
                sendEvent(new UpLoadEvent(1));
                break;
            case R.id.circleimageview2:
                sendEvent(new UpLoadEvent(2));
                break;
        }
    }


}