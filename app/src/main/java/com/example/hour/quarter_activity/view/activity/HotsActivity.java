package com.example.hour.quarter_activity.view.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.model.bean.AdvertisingHot;
import com.example.hour.quarter_activity.model.bean.DataHot;
import com.example.hour.quarter_activity.model.bean.MessageEvent;
import com.example.hour.quarter_activity.presenter.Recommended.HotPresenter;
import com.example.hour.quarter_activity.view.IView.Recommended.IHotView;
import com.example.hour.quarter_activity.view.adapter.video.VideoAdapter;
import com.example.hour.quarter_activity.view.adapter.video.VideoDetailsAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;

public class HotsActivity extends AppCompatActivity   {
    JZVideoPlayerStandard dt_videoA;
    SimpleDraweeView sv_HA;
    TextView tv_video;
    String next;
    int parseInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hots);
        dt_videoA = findViewById(R.id.dt_videoA);
        tv_video  = findViewById(R.id.tv_video);
        sv_HA = findViewById(R.id.sv_HA);
        EventBus.getDefault().register(HotsActivity.this);
        next = getIntent().getStringExtra("next");
        parseInt = Integer.parseInt(next);
        Log.e( "onCreate: ",next );

    }
    @Subscribe(sticky = true)
    public void EventBus(List<DataHot.DataBean> dataHot)
    {
        dt_videoA.setUp(dataHot.get(parseInt).getVideoUrl(),JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL);
        //tv_video.setText(dataHot.get(parseInt).getWorkDesc());...
        sv_HA.setImageURI(dataHot.get(parseInt).getCover());

    }

}
