package com.example.hour.quarter_activity.view.activity.uploadactivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.view.activity.sideactivity.Works_Activity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpbenActivity extends AppCompatActivity {

    DraweeController mDraweeController;
    @BindView(R.id.btn_fanhui)
    ImageView btnFanhui;
    @BindView(R.id.btn_ben)
    TextView btnBen;
    @BindView(R.id.fresco)
    SimpleDraweeView fresco;
    @BindView(R.id.btn_xia)
    Button btnXia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upben);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        mDraweeController = Fresco.newDraweeControllerBuilder()
//加载drawable里的一张gif图
                .setUri(Uri.parse("res://" + getPackageName() + "/" + R.mipmap.hhhhhhhhhhhhhhhh))//设置uri
                .setAutoPlayAnimations(true)
                .build();
        fresco.setController(mDraweeController);
    }


    @OnClick({R.id.btn_fanhui, R.id.btn_ben, R.id.fresco, R.id.btn_xia})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_fanhui:
                finish();
                break;
            case R.id.btn_ben:
                startActivity(new Intent(UpbenActivity.this,Works_Activity.class));
                break;
            case R.id.fresco:

                break;
            case R.id.btn_xia:
                startActivity(new Intent(UpbenActivity.this,FelessActivity.class));
                break;
        }
    }
}
