package com.example.hour.quarter_activity.view.adapter.recommended;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.model.bean.DataHot;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by wangguojian on 2018/1/25.
 */

public class HotAdapterOne extends RecyclerView.Adapter {
    private Context context;
    private List<DataHot.DataBean> list_data;

    public HotAdapterOne(Context context, List<DataHot.DataBean> list) {
        this.context = context;
        this.list_data = list;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.datahot_layout, null);
        MyHolderOne holderOne = new MyHolderOne(view);
        return holderOne;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolderOne holderOne = (MyHolderOne) holder;
        holderOne.hotName.setText(list_data.get(position).getUser().getNickname());
        holderOne.hotTime.setText(list_data.get(position).getCreateTime());
        holderOne.hotSpeak.setText(list_data.get(position).getWorkDesc());
        holderOne.hotSimp.setImageURI(list_data.get(position).getUser().getIcon());

        holderOne.videoplayer.setUp(list_data.get(position).getVideoUrl()
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "今日推荐");
        Picasso.with(context)
                .load(list_data.get(position).getCover())
                .into(holderOne.videoplayer.thumbImageView);
        holderOne.videoplayer.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
//        TranslateAnimation animation = new TranslateAnimation()
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
        @BindView(R.id.hot_speak)
        TextView hotSpeak;
        @BindView(R.id.amTwo_image)
        ImageView amTwoImage;
        @BindView(R.id.amThree_image)
        ImageView amThreeImage;
        @BindView(R.id.amFour_image)
        ImageView amFourImage;
        @BindView(R.id.amFive_image)
        ImageView amFiveImage;
        @BindView(R.id.videoplayer)
        JZVideoPlayerStandard videoplayer;

        public MyHolderOne(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
