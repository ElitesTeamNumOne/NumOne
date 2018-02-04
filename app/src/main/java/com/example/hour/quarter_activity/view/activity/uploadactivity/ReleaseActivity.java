package com.example.hour.quarter_activity.view.activity.uploadactivity;

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
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by HP on 2018/2/3.
 */

public class ReleaseActivity extends AppCompatActivity {


    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.tv_fan)
    TextView tvFan;
    @BindView(R.id.image_qq)
    ImageView imageQq;
    @BindView(R.id.tv_qq)
    TextView tvQq;
    @BindView(R.id.image_kong)
    ImageView imageKong;
    @BindView(R.id.tv_kong)
    TextView tvKong;
    @BindView(R.id.image_peng)
    ImageView imagePeng;
    @BindView(R.id.tv_peng)
    TextView tvPeng;
    @BindView(R.id.image_wei)
    ImageView imageWei;
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


    @OnClick({R.id.fan, R.id.tv_fan, R.id.image_qq, R.id.tv_qq, R.id.image_kong, R.id.tv_kong, R.id.image_peng, R.id.tv_peng, R.id.image_wei, R.id.tv_wei, R.id.tv_qianqu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fan:
                finish();
                break;
            case R.id.tv_fan:
                finish();
                break;
            case R.id.image_qq:
                showShare();
                break;
            case R.id.tv_qq:
                showShare();
                break;
            case R.id.image_kong:
                showShare();
                break;
            case R.id.tv_kong:
                showShare();
                break;
            case R.id.image_peng:
                showShare();
                break;
            case R.id.tv_peng:
                showShare();
                break;
            case R.id.image_wei:
                showShare();
                break;
            case R.id.tv_wei:
                showShare();
                break;
            case R.id.tv_qianqu:
                showShare();
                break;
        }
    }
}
