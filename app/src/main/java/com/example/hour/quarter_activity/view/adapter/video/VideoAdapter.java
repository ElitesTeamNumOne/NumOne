package com.example.hour.quarter_activity.view.adapter.video;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.model.bean.DataHot;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by BoBrother on 2018/1/27.
 */

public class VideoAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<DataHot.DataBean> list_data;

    public VideoAdapter(Context context, List<DataHot.DataBean> list) {
        this.context = context;
        this.list_data = list;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.vdio_hotlayout, null);
        MyHolderOne holderOne = new MyHolderOne(view);
        return holderOne;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        VideoAdapter.MyHolderOne holderOne = (VideoAdapter.MyHolderOne) holder;


        holderOne.videoplayer.setUp(list_data.get(position).getVideoUrl()
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "今日推荐");
        Picasso.with(context)
                .load(list_data.get(position).getCover())
                .into(holderOne.videoplayer.thumbImageView);
      holderOne.videoplayer.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override
    public int getItemCount() {
        if (list_data != null) {
            return list_data.size();
        }
        return 0;
    }

    public class MyHolderOne extends RecyclerView.ViewHolder {
        @BindView(R.id.videoplayer)
        JZVideoPlayerStandard videoplayer;

        public MyHolderOne(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
