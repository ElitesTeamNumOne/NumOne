package com.example.hour.quarter_activity.view.activity.sideactivity.worksfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hour.quarter_activity.R;

/**
 * Created by 信徒° on 2018/2/4.
 */

public class UploadFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.upload_layout, container, false);
        return view;
    }
}
