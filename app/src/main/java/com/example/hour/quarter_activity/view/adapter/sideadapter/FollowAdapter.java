package com.example.hour.quarter_activity.view.adapter.sideadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.model.bean.DataHot;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by 信徒° on 2018/2/5.
 */

public class FollowAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<DataHot.DataBean> list_data;
    private int num = 2;

    public FollowAdapter(Context context, List<DataHot.DataBean> list) {
        this.context = context;
        this.list_data = list;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.follw_layout, null);
        MyHolderOne holderOne = new MyHolderOne(view);
        return holderOne;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final MyHolderOne holderOne = (MyHolderOne) holder;
        holderOne.hotName.setText(list_data.get(position).getUser().getNickname());
        holderOne.hotTime.setText(list_data.get(position).getCreateTime());
        holderOne.hotSimp.setImageURI(list_data.get(position).getUser().getIcon());
    }

    @Override
    public int getItemCount() {
        if (list_data != null) {
            return list_data.size();
        }
        return 0;
    }

    public class MyHolderOne extends RecyclerView.ViewHolder {
        @BindView(R.id.hot_simp)
        SimpleDraweeView hotSimp;
        @BindView(R.id.hot_name)
        TextView hotName;
        @BindView(R.id.hot_time)
        TextView hotTime;

        public MyHolderOne(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
