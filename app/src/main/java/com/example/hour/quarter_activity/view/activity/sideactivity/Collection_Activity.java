package com.example.hour.quarter_activity.view.activity.sideactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.model.bean.AdvertisingHot;
import com.example.hour.quarter_activity.model.bean.DataHot;
import com.example.hour.quarter_activity.presenter.Recommended.HotPresenter;
import com.example.hour.quarter_activity.view.IView.Recommended.IHotView;
import com.example.hour.quarter_activity.view.adapter.recommended.HotAdapterOne;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Collection_Activity extends AppCompatActivity implements IHotView{

    @BindView(R.id.coll_fh)
    ImageView collFh;
    @BindView(R.id.collection_rv)
    RecyclerView collectionRv;
    public HotPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        //找控件
        ButterKnife.bind(this);
        //隐藏头
        getSupportActionBar().hide();
        presenter = new HotPresenter(this);
        presenter.getDataTwo();
        //跳转实现
        initJump();
    }

    private void initJump() {
        collFh.setOnClickListener(new View.OnClickListener() {
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
        HotAdapterOne adapterOne = new HotAdapterOne(Collection_Activity.this,data);
        LinearLayoutManager lm  = new LinearLayoutManager(Collection_Activity.this);
        collectionRv.setLayoutManager(lm);
        collectionRv.setAdapter(adapterOne);
    }
}
