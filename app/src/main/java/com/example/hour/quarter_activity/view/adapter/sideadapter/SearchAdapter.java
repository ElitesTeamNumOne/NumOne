package com.example.hour.quarter_activity.view.adapter.sideadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.model.sidebean.SearchBean;

/**
 * Created by 信徒° on 2018/2/3.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyHolder> {
    private Context context;
    private SearchBean bean;

    public SearchAdapter(Context context, SearchBean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public SearchAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyHolder holder = new MyHolder(LayoutInflater.from(context).inflate(R.layout.search_layout, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(SearchAdapter.MyHolder holder, int position) {
        //加载文字
        holder.rand_tv.setText(bean.getData().get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return bean.getData()!=null?bean.getData().size():0;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView rand_tv;
        public MyHolder(View itemView) {
            super(itemView);
            rand_tv = itemView.findViewById(R.id.rand_tv);
        }
    }
}
