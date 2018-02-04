package com.example.hour.quarter_activity.view.fragment.uploadfragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.presenter.uploadpresenter.UpLoadPresenter;
import com.example.hour.quarter_activity.view.IView.uploadview.UpLoadView;
import com.example.hour.quarter_activity.view.activity.uploadactivity.UpbenActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by HP on 2018/1/24.
 */

public class UpLoadVideoFragment extends BaseFragment<UpLoadPresenter> implements UpLoadView {

    @BindView(R.id.sim)
    SimpleDraweeView sim;
    @BindView(R.id.but_pai)
    ImageView pai;
    @BindView(R.id.btn_fan)
    ImageView fan;
    @BindView(R.id. btn_zhao)
    ImageView zhao;
    DraweeController mDraweeController;

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
        mDraweeController = Fresco.newDraweeControllerBuilder()
//加载drawable里的一张gif图
                .setUri(Uri.parse("res://"+getActivity().getPackageName()+"/"+R.mipmap.mao))//设置uri
                .setAutoPlayAnimations(true)
                .build();
        sim.setController(mDraweeController);
        sss();


    }
    public void sss(){
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        pai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), UpbenActivity.class));
            }
        });
        zhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invokecamera();
            }
        });
    }

    public void invokecamera() {
        //启动照像机组件
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.addCategory("android.intent.category.DEFAULT");
        startActivityForResult(intent, 100);
    }




}
