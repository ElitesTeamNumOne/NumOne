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
import com.example.hour.quarter_activity.presenter.sidepresenter.LogPresenter;
import com.example.hour.quarter_activity.utils.eventbusbao.EvenLogBean;
import com.example.hour.quarter_activity.view.IView.sideview.ILogView;
import com.example.hour.quarter_activity.view.activity.Home_Activity;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Log_Activity extends AppCompatActivity implements ILogView {

    @BindView(R.id.log_fh)
    ImageView logFh;
    @BindView(R.id.log_zc)
    TextView logZc;
    @BindView(R.id.log_wjmm)
    TextView logWjmm;
    @BindView(R.id.log_yk)
    TextView logYk;
    public LogPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        //找控件
        ButterKnife.bind(this);
        final EditText log_zh = findViewById(R.id.log_zh);
        final EditText log_mm = findViewById(R.id.log_mm);
        Button log_dl = findViewById(R.id.log_dl);
        //隐藏头
        getSupportActionBar().hide();
        presenter = new LogPresenter(this);
        //跳转到登录后主界面
        log_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(log_zh.getText().toString().trim().length()!=11){
                    Toast.makeText(Log_Activity.this,"用户名输入错误",Toast.LENGTH_LONG).show();
                }else if(log_mm.getText().toString().trim().length()!=6){
                    Toast.makeText(Log_Activity.this,"密码输入错误",Toast.LENGTH_LONG).show();
                }else{
                    presenter.LogPer(log_zh.getText().toString(),log_mm.getText().toString());
                }
            }
        });
        //跳转实现
        initJump();
    }

    private void initJump() {
        //返回
        logFh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //注册
        logZc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Log_Activity.this, Register_Activity.class);
                startActivity(intent);
            }
        });
        //忘记密码
        logWjmm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //游客登录
        logYk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Log_Activity.this, Home_Activity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onLogScuss(LogBean bean) {
        EventBus.getDefault().postSticky(new EvenLogBean(bean));
        if (bean.getCode().equals("0")){
            Intent intent = new Intent(Log_Activity.this,Home_Activity.class);
            intent.putExtra("mz",bean.getData().getUsername());
            startActivity(intent);
        }else{
            Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRegScuss(RegBean bean) {

    }
}
