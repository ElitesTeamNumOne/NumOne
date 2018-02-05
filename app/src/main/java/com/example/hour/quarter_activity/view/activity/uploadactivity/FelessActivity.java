package com.example.hour.quarter_activity.view.activity.uploadactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hour.quarter_activity.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class FelessActivity extends AppCompatActivity {

    @BindView(R.id.btn_fanfan)
    ImageView btnFanfan;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.feng)
    TextView feng;
    @BindView(R.id.suo)
    ImageView suo;
    @BindView(R.id.btn_ffbu)
    Button btnFfbu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feless);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
    }
    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，微信、QQ和QQ空间等平台使用
        oks.setTitle(this.getString(R.string.share));
        // titleUrl QQ和QQ空间跳转链接
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url在微信、微博，Facebook等平台中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网使用
        oks.setComment("我是测试评论文本");
        // 启动分享GUI
        oks.show(this);
    }

    @OnClick({R.id.btn_fanfan, R.id.imageView2, R.id.imageView, R.id.feng, R.id.suo, R.id.btn_ffbu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_fanfan:
                finish();
                break;
            case R.id.imageView2:
                break;
            case R.id.imageView:
                break;
            case R.id.feng:
                Toast.makeText(FelessActivity.this,"设为封面成功！！",Toast.LENGTH_SHORT).show();
                break;
            case R.id.suo:
                showShare();
                break;
            case R.id.btn_ffbu:
                startActivity(new Intent(FelessActivity.this,ReleaseActivity.class));
                break;
        }
    }
}
