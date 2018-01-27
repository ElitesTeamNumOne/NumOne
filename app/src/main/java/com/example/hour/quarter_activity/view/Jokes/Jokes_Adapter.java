package com.example.hour.quarter_activity.view.Jokes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hour.quarter_activity.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 王帅彪 on 2018/1/24.
 */

public class Jokes_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<Jokes_Bean.DataBean> list;
    private OnitemCliecklineasn mItemClickListener;
    private OnjiaCliecklineasn mOnjiaClickListener;
    public Jokes_Adapter(Context context,List<Jokes_Bean.DataBean> list){
        this.context=context;
        this.list=list;
    }

    public void setOnItemClickListener(OnitemCliecklineasn listener) {
        this.mItemClickListener = listener;
    }

    public void setOnjiaClickListener(OnjiaCliecklineasn listener) {
        this.mOnjiaClickListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.jokes_item, parent, false);
        return new ViewHolder(view,mItemClickListener,mOnjiaClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder hoder= (ViewHolder) holder;

        Object icon = list.get(position).getUser().getIcon();
        String url= (String) icon;

        if (url==null){
            hoder.jokes_icon.setImageResource(R.mipmap.ic_launcher);
        }else{
            Picasso.with(context).load(url).into(hoder.jokes_icon);
        }


        hoder.jokes_nickname.setText(list.get(position).getUser().getNickname()+"");
        hoder.jokes_time.setText(list.get(position).getCreateTime());
        hoder.jokes_content.setText(list.get(position).getContent());

        hoder.jokes_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnjiaClickListener.onItemClick(view,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list!=null?list.size():0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private OnitemCliecklineasn mListener;
        public TextView jokes_nickname, jokes_time, jokes_content;
        public CircleImageView jokes_icon;
        public ImageView jokes_jia;
        private OnjiaCliecklineasn mOnjiaClickListener;
        ViewHolder(View itemView,OnitemCliecklineasn lineasn, OnjiaCliecklineasn mOnjiaClickListener) {
            super(itemView);
            jokes_icon = itemView.findViewById(R.id.jokes_icon);
            jokes_nickname = itemView.findViewById(R.id.jokes_nickname);
            jokes_time = itemView.findViewById(R.id.jokes_time);
            jokes_content = itemView.findViewById(R.id.jokes_content);
            jokes_jia = itemView.findViewById(R.id.jokes_jia);
            this.mListener=lineasn;
            itemView.setOnClickListener(this);

        }
        @Override
        public void onClick(View view) {
            mListener.onItemClick(view, getPosition());
        }
    }
}
