package com.example.hour.quarter_activity.view.activity.sideactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.model.sidebean.LogBean;
import com.example.hour.quarter_activity.model.sidebean.RegBean;
import com.example.hour.quarter_activity.model.sidebean.SearchBean;
import com.example.hour.quarter_activity.presenter.sidepresenter.LogPresenter;
import com.example.hour.quarter_activity.view.IView.sideview.ILogView;
import com.example.hour.quarter_activity.view.adapter.sideadapter.SearchAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Search_Activity extends AppCompatActivity implements ILogView {

    @BindView(R.id.search_fh)
    ImageView searchFh;
    @BindView(R.id.search_sc)
    EditText searchSc;
    RecyclerView searchRv;
    public LogPresenter presenter;
    @BindView(R.id.search_ss)
    TextView searchSs;
    public SearchAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //找控件
        ButterKnife.bind(this);
        searchRv = findViewById(R.id.seachrv);
        //隐藏头
        getSupportActionBar().hide();
        //拿到P层
        presenter = new LogPresenter(this);
        //搜索
        searchSs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.RandPer(searchSc.getText().toString().trim());
                Toast.makeText(Search_Activity.this,"搜索成功",Toast.LENGTH_SHORT).show();
            }
        });
        //跳转实现
        initJump();
    }

    private void initJump() {
        searchFh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onLogScuss(LogBean bean) {

    }

    @Override
    public void onRegScuss(RegBean bean) {

    }

    @Override
    public void onRandScuss(SearchBean bean) {
        //线性格式
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        searchRv.setLayoutManager(manager);
        //适配器
        SearchAdapter adapter = new SearchAdapter(this,bean);
        searchRv.setAdapter(adapter);
    }
}
