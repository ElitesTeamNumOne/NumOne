package com.example.hour.quarter_activity.view.fragment.sidefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hour.quarter_activity.R;

/**
 * Created by wangguojian on 2018/1/23.
 */

public class MenuLeftFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menuleft_layout, container, false);
        return view;
    }
}