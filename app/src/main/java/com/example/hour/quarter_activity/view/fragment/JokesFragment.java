package com.example.hour.quarter_activity.view.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.presenter.Jokes_Presenter;
import com.example.hour.quarter_activity.view.Jokes.Jokes_Adapter;
import com.example.hour.quarter_activity.view.Jokes.Jokes_Bean;
import com.example.hour.quarter_activity.view.Jokes.OnitemCliecklineasn;
import com.example.hour.quarter_activity.view.Jokes.OnjiaCliecklineasn;
import com.example.hour.quarter_activity.view.Jokes_IView;

import java.util.List;

/**
 * Created by wangguojian on 2018/1/23.
 */

//praiseNum点赞

public class JokesFragment extends Fragment implements Jokes_IView{

    private RecyclerView recyc;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler()
    {
        public void handleMessage(android.os.Message msg)

        {
            switch (msg.what)
            {
                case 1:
                    //为了保险起见可以先判断当前是否在刷新中（旋转的小圈圈在旋转）....
                    if(swipe.isRefreshing()){
                        //关闭刷新动画
                        swipe.setRefreshing(false);
                    }
                    break;

            }
        };
    };
    private Jokes_Presenter presenter;

    private int page=1;
    private SwipeRefreshLayout swipe;


    private int num=0;

    private PopupWindow window;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.jokes_layout,null);

        recyc = view.findViewById(R.id.jokes_recyc);
        swipe = view.findViewById(R.id.jokes_swipe);
        presenter = new Jokes_Presenter(this);
        presenter.data(""+page);

        //设置在listview上下拉刷新的监听
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ++page;
                presenter.data(page+"");
                   mHandler.sendEmptyMessageDelayed(1, 1000);
            }
        });


        return view;
    }



    @Override
    public void jokes_data(Jokes_Bean bean) {


        final List<Jokes_Bean.DataBean> data = bean.getData();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyc.setLayoutManager(linearLayoutManager);
        final Jokes_Adapter mdapter = new Jokes_Adapter(getActivity(),data);
        recyc.setAdapter(mdapter);
        mdapter.setOnItemClickListener(new OnitemCliecklineasn() {
            @Override
            public void onItemClick(View view, int postion) {
                Toast.makeText(getActivity(),"点击测试成功"+postion,Toast.LENGTH_SHORT).show();
            }
        });
        mdapter.setOnjiaClickListener(new OnjiaCliecklineasn() {
            @Override
            public void onItemClick(View view, int postion) {


                Object praiseNum = data.get(postion).getPraiseNum();
                String dianzan= (String) praiseNum;
                ImageView image=view.findViewById(R.id.jokes_jia);
                    image.setImageResource(R.drawable.jokes_jian);
                    Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.animal1);
                    image.setAnimation(animation);
                    showPopupWindow2(view,dianzan);
            }
        });



    }

    private void showPopupWindow2(final View vvv, final String dianzan) {

        final View view = LayoutInflater.from(getActivity()).inflate(R.layout.jokes_popwindow, null);
        window = new PopupWindow(view, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        window.setTouchable(true);
        window.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        window.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                ImageView image=vvv.findViewById(R.id.jokes_jia);
                image.setImageResource(R.drawable.jokes_jia);
            }
        });
        final TextView dianzanshu=view.findViewById(R.id.jokes_pop_dianzanshu);
        if (dianzan==null){
            int dianza=0;

            dianzanshu.setText(dianza+"");
        }else {
            dianzanshu.setText(dianzan);
        }

        LinearLayout jokes_pop_dinazan=view.findViewById(R.id.jokes_pop_dinazan);
        jokes_pop_dinazan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"点赞",Toast.LENGTH_SHORT).show();
                if (dianzan==null){
                    int dianzan=0;
                    int s = dianzan + 1;
                    dianzanshu.setText(s+"");
                }


            }
        });
        LinearLayout jokes_pop_fenxiang=view.findViewById(R.id.jokes_pop_fenxiang);
        jokes_pop_fenxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"分享",Toast.LENGTH_SHORT).show();
            }
        });
        LinearLayout jokes_pop_pinglun=view.findViewById(R.id.jokes_pop_pinglun);
        jokes_pop_pinglun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"评论",Toast.LENGTH_SHORT).show();
            }
        });
        window.setBackgroundDrawable(getResources().getDrawable(R.color.touming));
        window.setAnimationStyle(R.style.mypopwindow_anim_style);
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        int  mShowMorePopupWindowWidth = -view.getMeasuredWidth();
        int  mShowMorePopupWindowHeight = -view.getMeasuredHeight();
        window.showAsDropDown(vvv,mShowMorePopupWindowWidth, mShowMorePopupWindowHeight+45);
    }

}
