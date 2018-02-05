package com.example.hour.quarter_activity.view.activity.recommend;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.model.bean.AdvertisingHot;
import com.example.hour.quarter_activity.model.bean.DataHot;
import com.example.hour.quarter_activity.presenter.Recommended.HotPresenter;
import com.example.hour.quarter_activity.view.IView.Recommended.IHotView;
import com.example.hour.quarter_activity.view.adapter.recommended.HotAdapterOne;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HotDetailsActivity extends AppCompatActivity implements IHotView {
    private HotPresenter presenter;
    private RecyclerView mRecyclerView;
    private List<AdvertisingHot.DataBean> list_Aev;
    @BindView(R.id.relat)
    RelativeLayout relat;
    @BindView(R.id.fensi)
    TextView fensi;
    @BindView(R.id.buguan)
    Button buguan;
    @BindView(R.id.buttu)
    ImageView buttu;
    @BindView(R.id.textdian)
    TextView textdian;
    @BindView(R.id.recybu)
    RelativeLayout recybu;

    @BindView(R.id.simpbu)
    SimpleDraweeView simpbu;
    int iOne = 2;
    int iTwo = 3;
    int geti = 16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_details);
        ButterKnife.bind(this);
        simpbu.setImageURI("https://www.zhaoapi.cn/images/quarter/1517730511387(104).jpg");
        presenter = new HotPresenter(this);
        presenter.getDataTwo();
        init();
    }
    private void init(){
        mRecyclerView = findViewById(R.id.mHotRecyler);
    }
    @SuppressLint("ResourceAsColor")
    @OnClick({R.id.relat, R.id.fensi, R.id.buguan, R.id.buttu, R.id.textdian, R.id.recybu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.relat:
                break;
            case R.id.fensi:
                break;
            case R.id.buguan:
                if (iOne % 2 == 0) {
                    buguan.setBackgroundColor(R.color.more_color);
                    Toast.makeText(this, "关注成功", Toast.LENGTH_SHORT).show();
                } else {
                    buguan.setBackgroundResource(R.drawable.buttonstyle);
                    Toast.makeText(this, "取消关注", Toast.LENGTH_SHORT).show();
                }
                iOne++;
                break;
            case R.id.buttu:
                geti++;
                if (iTwo % 3 == 0) {
                    recybu.setBackgroundColor(R.color.orange);
                    textdian.setText(geti + "");
                } else if (iTwo % 3 == 1) {
                    recybu.setBackgroundColor(R.color.blue);
                    textdian.setText(geti + "");
                } else {
                    recybu.setBackgroundColor(R.color.red);
                    textdian.setText(geti + "");
                }
                iTwo++;
                break;
            case R.id.textdian:
                break;
            case R.id.recybu:
                geti++;
                if (iTwo % 3 == 0) {
                    recybu.setBackgroundColor(R.color.orange);
                    textdian.setText(geti + "");
                } else if (iTwo % 3 == 1) {
                    recybu.setBackgroundColor(R.color.blue);
                    textdian.setText(geti + "");
                } else {
                    recybu.setBackgroundColor(R.color.red);
                    textdian.setText(geti + "");
                }
                iTwo++;
                break;
            default:
                break;
        }
    }

    @Override
    public void onSucceed(AdvertisingHot hot) {

    }

    @Override
    public void onSucceedTwo(DataHot dataHot) {
        List<DataHot.DataBean> data = dataHot.getData();
        HotAdapterOne adapterOne = new HotAdapterOne(this,data);
        LinearLayoutManager lm  = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(lm);
        mRecyclerView.setAdapter(adapterOne);
    }
}
