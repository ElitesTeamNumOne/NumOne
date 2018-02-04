package com.example.hour.quarter_activity.view.activity.sideactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.view.activity.Home_Activity;
import com.example.hour.quarter_activity.view.activity.sideactivity.logactivity.Log_Activity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Login_Activity extends AppCompatActivity {

    @BindView(R.id.login_fh)
    ImageView loginFh;
    @BindView(R.id.login_tou)
    SimpleDraweeView loginTou;
    @BindView(R.id.login_wx)
    ImageView loginWx;
    @BindView(R.id.login_qq)
    ImageView loginQq;
    @BindView(R.id.login_qt)
    TextView loginQt;
    private static final String TAG = "Login_Activity";
    private static final String APP_ID = "1105602574";//官方获取的APPID
    private Tencent mTencent;
    private BaseUiListener mIUiListener;
    private UserInfo mUserInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //找控件
        ButterKnife.bind(this);
        //隐藏头.
        getSupportActionBar().hide();
        //传入参数APPID和全局Context上下文
        mTencent = Tencent.createInstance(APP_ID,Login_Activity.this.getApplicationContext());
        //登录实现
        loginQt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Activity.this,Log_Activity.class);
                startActivity(intent);
            }
        });
        //返回
        loginFh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //qq登录
        loginQq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIUiListener = new BaseUiListener();
                //all表示获取所有权限
                mTencent.login(Login_Activity.this,"all", mIUiListener);
            }
        });
    }
    /**
     * 自定义监听器实现IUiListener接口后，需要实现的3个方法
     * onComplete完成 onError错误 onCancel取消
     */
    private class BaseUiListener implements IUiListener{

        @Override
        public void onComplete(Object response) {
            Toast.makeText(Login_Activity.this, "授权成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Login_Activity.this, Home_Activity.class);
            startActivity(intent);
            JSONObject obj = (JSONObject) response;
            try {
                String openID = obj.getString("openid");
                String accessToken = obj.getString("access_token");
                String expires = obj.getString("expires_in");
                mTencent.setOpenId(openID);
                mTencent.setAccessToken(accessToken,expires);

                QQToken qqToken = mTencent.getQQToken();
                mUserInfo = new UserInfo(getApplicationContext(),qqToken);
                mUserInfo.getUserInfo(new IUiListener() {

                    @Override
                    public void onComplete(Object response) {
                        Log.e(TAG,"登录成功"+response.toString());
                    }

                    @Override
                    public void onError(UiError uiError) {
                        Log.e(TAG,"登录失败"+uiError.toString());
                    }
                    @Override
                    public void onCancel() {
                        Log.e(TAG,"登录取消");

                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(UiError uiError) {
            Toast.makeText(Login_Activity.this, "授权失败", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel() {
            Toast.makeText(Login_Activity.this, "授权取消", Toast.LENGTH_SHORT).show();

        }

    }

    /**
     * 在调用Login的Activity或者Fragment中重写onActivityResult方法
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Constants.REQUEST_LOGIN){
            Tencent.onActivityResultData(requestCode,resultCode,data,mIUiListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
