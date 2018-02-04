package com.example.hour.quarter_activity.view.activity.sideactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.example.hour.quarter_activity.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Collection_Activity extends AppCompatActivity{

    @BindView(R.id.coll_fh)
    ImageView collFh;
    @BindView(R.id.collection_rv)
    RecyclerView collectionRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        //找控件
        ButterKnife.bind(this);
        //隐藏头
        getSupportActionBar().hide();
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

}
