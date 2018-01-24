package com.example.hour.quarter_activity.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hour.quarter_activity.R;

/**
 * Created by 小社会 on 2018/1/24,0024.
 */

public class HotFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =View.inflate(getActivity(), R.layout.hot_fragment,null);
        return view;
    }
}
