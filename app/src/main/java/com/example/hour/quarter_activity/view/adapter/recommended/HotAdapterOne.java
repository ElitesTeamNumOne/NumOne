package com.example.hour.quarter_activity.view.adapter.recommended;

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
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayerStandard;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by wangguojian on 2018/1/25.
 */

public class HotAdapterOne extends RecyclerView.Adapter {
    private Context context;
    private List<DataHot.DataBean> list_data;
    private int num = 2;
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
        final MyHolderOne holderOne = (MyHolderOne) holder;
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
        holderOne.mImageShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShare();
            }
        });
        //控制动画
        holderOne.amFiveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num % 2 == 0) {
                    holderOne.amFiveImage.setImageResource(R.drawable.jokes_jian);
                    holderOne.amFourImage.setVisibility(View.INVISIBLE);
                    holderOne.amThreeImage.setVisibility(View.INVISIBLE);
                    holderOne.amTwoImage.setVisibility(View.INVISIBLE);
                    getanimationOpen(holderOne.amFiveImage, holderOne.amFourImage, holderOne.amThreeImage, holderOne.amTwoImage);
                }else{
                    holderOne.amFiveImage.setImageResource(R.drawable.jokes_jia);
                    holderOne.amFourImage.setVisibility(View.GONE);
                    holderOne.amThreeImage.setVisibility(View.GONE);
                    holderOne.amTwoImage.setVisibility(View.GONE);
                    getanimationShut(holderOne.amFiveImage, holderOne.amFourImage, holderOne.amThreeImage, holderOne.amTwoImage);
                }
                num++;
            }
        });
    }
    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，微信、QQ和QQ空间等平台使用
        oks.setTitle(context.getString(R.string.share));
        // titleUrl QQ和QQ空间跳转链接
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url在微信、微博，Facebook等平台中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网使用
        oks.setComment("我是测试评论文本");
        // 启动分享GUI
        oks.show(context);
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
        @BindView(R.id.mImagePraise)
        ImageView mImagePraise;
        @BindView(R.id.mTextPraise)
        TextView mTextPraise;
        @BindView(R.id.mImageCollection)
        ImageView mImageCollection;
        @BindView(R.id.mTextCollection)
        TextView mTextCollection;
        @BindView(R.id.mImageShare)
        ImageView mImageShare;
        @BindView(R.id.mTextShare)
        TextView mTextShare;
        @BindView(R.id.mImageComments)
        ImageView mImageComments;
        @BindView(R.id.mTextComments)
        TextView mTextComments;
        public MyHolderOne(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void getanimationOpen(ImageView One, ImageView Two, ImageView Three, ImageView Four) {

        RotateAnimation ra = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        //设置播放时间
        ra.setFillAfter(true);
        ra.setDuration(800);
        //动画播放完毕后，组件停留在动画结束的位置上

        One.startAnimation(ra);

        TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, -3, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0);

        //设置动画持续时间
        ta.setDuration(500);
        //动画播放完毕后，组件停留在动画结束的位置上
        ta.setFillAfter(true);
        //播放动画
        Two.startAnimation(ta);
        TranslateAnimation ta2 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, -2, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0);
        //设置动画持续时间
        ta2.setDuration(500);
        //动画播放完毕后，组件停留在动画结束的位置上
        ta2.setFillAfter(true);
        //播放动画
        Three.startAnimation(ta2);
        TranslateAnimation ta3 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, -1, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0);
        //设置动画持续时间
        ta3.setDuration(500);
        //动画播放完毕后，组件停留在动画结束的位置上
        ta3.setFillAfter(true);
        //播放动画
        Four.startAnimation(ta3);
    }

    public void getanimationShut(ImageView One, ImageView Two, ImageView Three, ImageView Four) {
        RotateAnimation ra = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        //设置播放时间
        ra.setFillAfter(true);
        ra.setDuration(800);
        //动画播放完毕后，组件停留在动画结束的位置上

        One.startAnimation(ra);

        TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF, -3f, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0);

        //设置动画持续时间
        ta.setDuration(500);
        //动画播放完毕后，组件停留在动画结束的位置上
        ta.setFillAfter(true);
        //播放动画
        Two.startAnimation(ta);
        TranslateAnimation ta2 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, -2f, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0);
        //设置动画持续时间
        ta2.setDuration(500);
        //动画播放完毕后，组件停留在动画结束的位置上
        ta2.setFillAfter(true);
        //播放动画
        Three.startAnimation(ta2);
        TranslateAnimation ta3 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, -1f, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0);
        //设置动画持续时间
        ta3.setDuration(500);
        //动画播放完毕后，组件停留在动画结束的位置上
        ta3.setFillAfter(true);
        //播放动画
        Four.startAnimation(ta3);
    }

}
