package com.example.hour.quarter_activity.view.activity.sideactivity.noticefragment;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.hour.quarter_activity.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.lang.reflect.Field;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 信徒° on 2018/2/4.
 */

public class NewxFragment extends Fragment {
    @BindView(R.id.newx_tp)
    SimpleDraweeView newxTp;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.newx_layout, container, false);
        unbinder = ButterKnife.bind(this, view);

                // 图片地址http://img.huofar.com/data/jiankangrenwu/shizi.gif
                Uri uri = Uri.parse("http://a.hiphotos.baidu.com/image/pic/item/c2fdfc039245d6888c65ecb9afc27d1ed21b2443.gif");
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setUri(uri)
                        .setAutoPlayAnimations(true)//设置为true将循环播放Gif动画
                        .build();
                newxTp.setController(controller);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
