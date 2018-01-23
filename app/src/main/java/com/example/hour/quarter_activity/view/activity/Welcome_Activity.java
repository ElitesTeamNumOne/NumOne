package com.example.hour.quarter_activity.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.hour.quarter_activity.R;

public class Welcome_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_);
        startActivity(new Intent(Welcome_Activity.this,Home_Activity.class));
        Toast.makeText(this, "跳转成功", Toast.LENGTH_SHORT).show();
        }
}
