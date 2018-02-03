package com.example.hour.quarter_activity.view.activity.uploadactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hour.quarter_activity.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by HP on 2018/2/3.
 */

public class ReleaseActivity extends AppCompatActivity {
    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.tv_fan)
    TextView tvFan;
    @BindView(R.id.tv_qq)
    TextView tvQq;
    @BindView(R.id.tv_kong)
    TextView tvKong;
    @BindView(R.id.tv_peng)
    TextView tvPeng;
    @BindView(R.id.tv_wei)
    TextView tvWei;
    @BindView(R.id.tv_qianqu)
    Button tvQianqu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release);
        getSupportActionBar().hide();
        ButterKnife.bind(this);

    }

    @OnClick({R.id.fan, R.id.tv_fan, R.id.tv_qq, R.id.tv_kong, R.id.tv_peng, R.id.tv_wei, R.id.tv_qianqu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fan:
                finish();
                break;
            case R.id.tv_fan:
                finish();
                break;
            case R.id.tv_qq:
                break;
            case R.id.tv_kong:
                break;
            case R.id.tv_peng:
                break;
            case R.id.tv_wei:
                break;
            case R.id.tv_qianqu:
//                startActivity(new Intent(ReleaseActivity.this,));
                break;
        }
    }
}
