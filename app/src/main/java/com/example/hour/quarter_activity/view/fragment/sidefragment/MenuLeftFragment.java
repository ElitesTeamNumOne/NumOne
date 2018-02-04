package com.example.hour.quarter_activity.view.fragment.sidefragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.view.activity.sideactivity.Collection_Activity;
import com.example.hour.quarter_activity.view.activity.sideactivity.Follow_Activity;
import com.example.hour.quarter_activity.view.activity.sideactivity.Login_Activity;
import com.example.hour.quarter_activity.view.activity.sideactivity.Notice_Activity;
import com.example.hour.quarter_activity.view.activity.sideactivity.Search_Activity;
import com.example.hour.quarter_activity.view.activity.sideactivity.Setup_Activity;
import com.example.hour.quarter_activity.view.activity.sideactivity.Works_Activity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 辛佳奇 on 2018/1/27.
 */

public class MenuLeftFragment extends Fragment {
    @BindView(R.id.cce_gz)
    RelativeLayout cceGz;
    @BindView(R.id.cce_sc)
    RelativeLayout cceSc;
    @BindView(R.id.mTogBtn)
    ToggleButton mTogBtn;
    @BindView(R.id.cce_zp)
    LinearLayout cceZp;
    @BindView(R.id.cce_sz)
    LinearLayout cceSz;
    Unbinder unbinder;
    @BindView(R.id.cce_ttp)
    RelativeLayout cceTtp;
    @BindView(R.id.cce_hy)
    RelativeLayout cceHy;
    @BindView(R.id.cce_tz)
    RelativeLayout cceTz;
    @BindView(R.id.cce_szcy)
    TextView cceSzcy;
    @BindView(R.id.ce_czt)
    ImageView ceCzt;
    Unbinder unbinder1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menuleft_layout, container, false);
        unbinder1 = ButterKnife.bind(this, view);
        //侧滑点击事件
        initSide();
        //注册
        EventBus.getDefault().register(this);
        return view;
    }

    @Subscribe(sticky = true)
    public void event(EventBean eventBean) {
        //接受传过来的文字
        cceSzcy.setText(eventBean.getTitle());
    }

    private void initSide() {
        //登录
        cceTtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Login_Activity.class);
                startActivity(intent);
            }
        });
        //我的关注
        cceGz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Follow_Activity.class);
                startActivity(intent);
            }
        });
        //我的收藏
        cceSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Collection_Activity.class);
                startActivity(intent);
            }
        });
        //搜索好友
        cceHy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Search_Activity.class);
                startActivity(intent);
            }
        });
        //消息通知
        cceTz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Notice_Activity.class);
                startActivity(intent);
            }
        });
        //日夜间模式
        mTogBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (isChecked) {
                    //选中
                    Toast.makeText(getActivity(), "开", Toast.LENGTH_SHORT).show();
                } else {
                    //未选中
                    Toast.makeText(getActivity(), "关", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //我的作品
        cceZp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Works_Activity.class);
                startActivity(intent);

            }
        });
        //设置
        cceSz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Setup_Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);//取消注册
    }

}
