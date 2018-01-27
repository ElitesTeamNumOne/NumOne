package com.example.hour.quarter_activity.view.fragment.uploadfragment;

/**
 * Created by HP on 2018/1/24.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public  abstract class BaseOrdinaryFragment extends Fragment {

    protected View mView;
    protected Activity mActivity;
    protected Context mContext;
    private Unbinder mUnBinder;
    private Fragment mFragment;

    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(),container,false);
        return mView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mUnBinder = ButterKnife.bind(this,view);

        initData();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        mUnBinder.unbind();
        EventBus.getDefault().unregister(this);
    }

    public static void registerEvent(Object obj){
        EventBus.getDefault().register(obj);
    }

    public static void sendEvent(Object obj){
        EventBus.getDefault().postSticky(obj);
    }

    protected void startActivity(Class<?> cls){
        startActivity(new Intent(mContext,cls));
    }

    @Subscribe(threadMode = ThreadMode.MAIN , sticky = true)
    public void onEventMainThread(Object obj){

    }

    public void showFragment(Fragment fragment ,int layoutID) {

        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        if (mFragment != null) {
            fragmentTransaction.hide(mFragment);
        }
        if (!fragment.isAdded()) {
            fragmentTransaction.add(layoutID, fragment);
        }
        fragmentTransaction.show(fragment);
        fragmentTransaction.commit();
        mFragment = fragment;

    }


    protected abstract int getLayoutId();

    protected abstract void initData();
}

