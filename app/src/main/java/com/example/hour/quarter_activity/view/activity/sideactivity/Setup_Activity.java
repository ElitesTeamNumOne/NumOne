package com.example.hour.quarter_activity.view.activity.sideactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.view.activity.Home_Activity;

public class Setup_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        //隐藏头
        getSupportActionBar().hide();
        //找控件
        Button setup_tc = findViewById(R.id.setup_tc);
        //退出应用
        setup_tc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setup_Activity.this, Home_Activity.class);
                startActivity(intent);
            }
        });
    }
}
