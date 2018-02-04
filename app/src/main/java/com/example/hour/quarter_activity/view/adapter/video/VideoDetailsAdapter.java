package com.example.hour.quarter_activity.view.adapter.video;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.model.bean.DataHot;
import com.example.hour.quarter_activity.view.activity.HotsActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;


/**
 * Created by BoBrother on 2018/2/4.
 */

public class VideoDetailsAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<DataHot.DataBean> list_data;

    public VideoDetailsAdapter(Context context, List<DataHot.DataBean> list_data) {
        this.context = context;
        this.list_data = list_data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = View.inflate(context, R.layout.video_details, null);
        return new MyHolderDeatails(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,final int position) {
        VideoDetailsAdapter.MyHolderDeatails holderDa = (VideoDetailsAdapter.MyHolderDeatails) holder;
        //加载子布局控件
        ViewGroup.LayoutParams params = ((MyHolderDeatails) holder).sv_vda.getLayoutParams();
        //给图片设置高
        if(position == 0){
            params.height = 150;
        }else{
            params.height = 300;
        }
        holderDa.sv_vda.setImageURI(list_data.get(position).getUser().getIcon());
        holderDa.itemView.setTag(position);
        ((MyHolderDeatails) holder).sv_vda.setOnClickListener(new View.OnClickListener() {
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



    public class MyHolderDeatails extends RecyclerView.ViewHolder {
        SimpleDraweeView sv_vda;
        public MyHolderDeatails(View itemView) {
            super(itemView);
            sv_vda = itemView.findViewById(R.id.sv_vda);
        }
    }


}
