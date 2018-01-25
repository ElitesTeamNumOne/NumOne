package com.example.hour.quarter_activity.view.fragment.uploadfragment;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hour.quarter_activity.R;
import com.example.hour.quarter_activity.model.UpLoadEvent;
import com.example.hour.quarter_activity.presenter.UpLoadPresenter;
import com.example.hour.quarter_activity.utils.LogUtils;
import com.example.hour.quarter_activity.view.IView.UpLoadView;
import com.example.hour.quarter_activity.view.fragment.uploadfragment.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.hour.quarter_activity.utils.Utils.convertIconToString;

/**
 * Created by HP on 2018/1/24.
 */


public class UpLoadTextFragment extends BaseFragment<UpLoadPresenter> implements UpLoadView {
    @BindView(R.id.up_cancel)
    TextView mUpCancel;
    @BindView(R.id.up_publish)
    TextView mUpPublish;
    @BindView(R.id.up_et)
    EditText mUpEt;
    @BindView(R.id.up_iv)
    ImageView mUpIv;
    @BindView(R.id.up_tv_at)
    TextView mUpTvAt;
    @BindView(R.id.up_iv_right)
    ImageView mUpIvRight;

    public Bitmap mBimap;

    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void onSucceed(Object object) {

    }

    @Override
    public void onFail(String str) {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new UpLoadPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_uptext;
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.up_cancel, R.id.up_publish, R.id.up_iv, R.id.up_tv_at, R.id.up_iv_right})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.up_cancel:
                mUpEt.setText("");
                mUpIv.setImageResource(R.mipmap.plus);
                sendEvent(new UpLoadEvent(3));
                break;
            case R.id.up_publish:
                // TODO: 2017/8/1   发表
                String iconToString = convertIconToString(mBimap);
                mPresenter.upLoadIv(iconToString);
                break;
            case R.id.up_iv:
                //相机 照片选择
                selectIv();
                break;
            case R.id.up_tv_at:
                break;
            case R.id.up_iv_right:
                break;
        }
    }

    public void selectIv(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final String[] items = {"照相机", "本地图片", "取消"};
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        invokecamera();
                        dialog.dismiss();
                        break;
                    case 1:
                        invokeimgages();
                        dialog.dismiss();
                        break;
                    case 2:
                        dialog.dismiss();
                        break;
                }
            }
        });

        builder.create().show();
    }

    public void invokeimgages() {
        //调用系统相册
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 200);

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 200) {
            //得到像册中图片的地址
            Uri uri = data.getData();
            crop(uri);
            LogUtils.a(uri);
        } else if (requestCode == 9999) {
            //得到裁剪后的照片
            mBimap = data.getParcelableExtra("data");
            mUpIv.setImageBitmap(mBimap);

        } else if (requestCode == 100) {
            //得到照片
            mBimap = data.getParcelableExtra("data");
            mUpIv.setImageBitmap(mBimap);
        }


        super.onActivityResult(requestCode, resultCode, data);
    }


    private void crop(Uri uri) {
        // 裁剪图片意图
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        //是否裁剪
        intent.putExtra("crop", "true");
        // 裁剪框的比例，1：1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 裁剪后输出图片的尺寸大小
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);

        intent.putExtra("outputFormat", "JPEG");// 图片格式
        intent.putExtra("noFaceDetection", false);// 取消人脸识别

        // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_CUT
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 9999);
    }

    public void invokecamera() {
        //启动照像机组件
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.addCategory("android.intent.category.DEFAULT");
        startActivityForResult(intent, 100);
    }
}
