package com.example.hour.quarter_activity.presenter;

import com.example.hour.quarter_activity.model.Jokes_IMoudel;
import com.example.hour.quarter_activity.model.Jokes_Moudel;
import com.example.hour.quarter_activity.view.Jokes.Jokes_Bean;
import com.example.hour.quarter_activity.view.Jokes_IView;

/**
 * Created by 王帅彪 on 2018/1/24.
 */

public class Jokes_Presenter {
    private Jokes_IView iView;
    private Jokes_Moudel moudel;
    public Jokes_Presenter(Jokes_IView iView){
        this.iView=iView;
        this.moudel=new Jokes_Moudel();
    }


    public void data(String page){

        moudel.moudel_data(page,new Jokes_IMoudel() {
            @Override
            public void jokes_data(Jokes_Bean bean) {
                iView.jokes_data(bean);
            }
        });
    }

}
