package com.example.hour.quarter_activity.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.hour.quarter_activity.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by HP on 2018/1/24.
 */


public abstract class BaseOrdinaryActivity extends AppCompatActivity {
    protected FragmentManager mFragmentManager;
    protected Activity mContext;//上下文
    private String mTitle;
    protected Fragment mFragment;
    private Unbinder mUnBinder;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //acticity跳转动画——右进左出
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        //展示页面
        setContentView(getLayoutId());
        //初始化共有内容
        init();
        //初始化数据
        initDatas();
    }

    private void init() {
        mContext = this;
        //ButterKnife绑定
        mUnBinder = ButterKnife.bind(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //ButterKnift解除绑定
        mUnBinder.unbind();
        // eventbus  解绑
        EventBus.getDefault().unregister(this);
        //删除当前Activity
    }

    protected abstract int getLayoutId();

    protected abstract void initDatas();

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


    public FragmentTransaction fragmentReplace(int layoutID, Fragment fragment){
        return mFragmentManager.beginTransaction().replace(layoutID,fragment);
    }

    public void showFragment(Fragment fragment ,int layoutID) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
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

    /**
     * 隐藏软键盘
     *
     * @param v
     */
//    public void hideInputMethod(final EditText v) {
//        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(v.getWindowToken(),InputMethodManager.HIDE_IMPLICIT_ONLY);
//
//    }

    /**
     * 显示软键盘
     *
     * @param v
     */
    public void showInputMethod(final EditText v) {

        v.requestFocus();
        InputMethodManager imm = (InputMethodManager)mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(v,InputMethodManager.SHOW_IMPLICIT);
    }
}
