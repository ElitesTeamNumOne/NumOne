package com.example.hour.quarter_activity.view.activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;
import com.example.hour.quarter_activity.R;
public class Welcome_Activity extends AppCompatActivity {
    //王国建
    TextView tv;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Handler handler = new Handler();
    // 设置跳转时长事件123
    int time = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);
        tv = (TextView) findViewById(R.id.tv);
        preferences = getSharedPreferences("cof", MODE_PRIVATE);
        editor = preferences.edit();
        boolean Login = preferences.getBoolean("isLogin", false);
        if(Login){
            Intent intent = new Intent(Welcome_Activity.this,Home_Activity.class);
            startActivity(intent);
            finish();
            return;
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv.setText(time+"");
                time -- ;
                if(time == 0){
                    Intent intent = new Intent(Welcome_Activity.this,Home_Activity.class);
                    startActivity(intent);
                    //    进行判断是否第一次
                    editor.putBoolean("isLogin", true);
                    editor.commit();
                    finish();
                    return;
                }
                handler.postDelayed(this, 1000);
            }
        }, 3000);
    }

}
