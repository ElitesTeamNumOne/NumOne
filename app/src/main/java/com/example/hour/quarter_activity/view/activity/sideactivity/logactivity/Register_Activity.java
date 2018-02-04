package com.example.hour.quarter_activity.view.activity.sideactivity.logactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
import com.example.hour.quarter_activity.view.activity.Home_Activity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Register_Activity extends AppCompatActivity implements ILogView{

    @BindView(R.id.reg_fh)
    ImageView regFh;
    @BindView(R.id.reg_yy)
    TextView regYy;
    @BindView(R.id.reg_yk)
    TextView regYk;
    @BindView(R.id.reg_zh)
    EditText regZh;
    @BindView(R.id.reg_mm)
    EditText regMm;
    @BindView(R.id.recg_zc)
    Button recgZc;
    public LogPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //找控件
        ButterKnife.bind(this);
        //隐藏头
        getSupportActionBar().hide();
        presenter = new LogPresenter(this);
        //跳转实现
        initJump();
    }

    private void initJump() {
        //返回
        regFh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //注册点击
        recgZc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(regZh.getText().toString().trim().length()!=11){
                    Toast.makeText(Register_Activity.this,"用户名输入错误",Toast.LENGTH_LONG).show();
                }else if(regMm.getText().toString().trim().length()!=6){
                    Toast.makeText(Register_Activity.this,"密码输入错误",Toast.LENGTH_LONG).show();
                }else{
                    presenter.RegPer(regZh.getText().toString(),regMm.getText().toString());
                }
            }
        });
        //已有账号
        regYy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //游客登录
        regYk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register_Activity.this, Home_Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onLogScuss(LogBean bean) {

    }

    @Override
    public void onRegScuss(RegBean bean) {
        if (bean.getCode().equals("0")){
            Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(this,"注册失败",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRandScuss(SearchBean bean) {

    }
}
