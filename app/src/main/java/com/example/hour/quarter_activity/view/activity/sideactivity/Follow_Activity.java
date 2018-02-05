package com.example.hour.quarter_activity.view.activity.sideactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.model.bean.AdvertisingHot;
import com.example.hour.quarter_activity.model.bean.DataHot;
import com.example.hour.quarter_activity.presenter.Recommended.HotPresenter;
import com.example.hour.quarter_activity.view.IView.Recommended.IHotView;
import com.example.hour.quarter_activity.view.adapter.recommended.HotAdapterOne;
import com.example.hour.quarter_activity.view.adapter.sideadapter.FollowAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Follow_Activity extends AppCompatActivity implements IHotView {

    @BindView(R.id.follow_fh)
    ImageView followFh;
    @BindView(R.id.follow_rv)
    RecyclerView followRv;
    @BindView(R.id.follow_rm)
    TextView followRm;
    public HotPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);
        ButterKnife.bind(this);
        //隐藏头
        getSupportActionBar().hide();
        presenter = new HotPresenter(this);
        presenter.getDataTwo();
        //跳转实现
        initJump();
    }

    private void initJump() {
        followFh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onSucceed(AdvertisingHot hot) {

    }

    @Override
    public void onSucceedTwo(DataHot dataHot) {
        List<DataHot.DataBean> data = dataHot.getData();
        FollowAdapter adapterOne = new FollowAdapter(Follow_Activity.this, data);
        LinearLayoutManager lm = new LinearLayoutManager(Follow_Activity.this);
        followRv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        followRv.setLayoutManager(lm);
        followRv.setAdapter(adapterOne);
    }
}
