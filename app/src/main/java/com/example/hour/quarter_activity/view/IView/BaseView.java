package com.example.hour.quarter_activity.view.IView;

import android.content.Context;

/**
 * Created by HP on 2018/1/24.
 */

public interface BaseView {

    Context context();

    void onSucceed(Object object);

    void onFail(String str);


}
