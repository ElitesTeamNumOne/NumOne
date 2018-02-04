package com.example.hour.quarter_activity.view.adapter.video;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.model.bean.DataHot;
import com.example.hour.quarter_activity.model.bean.MessageEvent;
import com.example.hour.quarter_activity.view.activity.HotsActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by BoBrother on 2018/1/27.
 */

public class VideoAdapter extends RecyclerView.Adapter  {
    private Context context;
    private List<DataHot.DataBean> list_data;

    public VideoAdapter(Context context, List<DataHot.DataBean> list) {
        this.context = context;
        this.list_data = list;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.vdio_hotlayout, null);
        return new MyHolderOne(view);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        VideoAdapter.MyHolderOne holderOne = (VideoAdapter.MyHolderOne) holder;
        //加载子布局控件
        ViewGroup.LayoutParams params = ((MyHolderOne) holder).sv_va.getLayoutParams();
        //给图片设置高
        if(position == 0){
            params.height = 150;
        }else{
            params.height = 300;
        }
        holderOne.sv_va.setImageURI(list_data.get(position).getUser().getIcon());
        holderOne.itemView.setTag(position);
        ((MyHolderOne) holder).sv_va.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(list_data);
                Intent intent = new Intent(context,HotsActivity.class);
                intent.putExtra("next",""+position);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (list_data != null) {
            return list_data.size();
        }
        return 0;
    }

    public class MyHolderOne extends RecyclerView.ViewHolder {
        SimpleDraweeView sv_va;

        public MyHolderOne(View itemView) {
            super(itemView);
            sv_va = itemView.findViewById(R.id.sv_va);
        }
    }

}
