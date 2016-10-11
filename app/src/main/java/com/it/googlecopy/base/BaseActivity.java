package com.it.googlecopy.base;

import android.Manifest;
import android.accounts.NetworkErrorException;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.SwipeRefreshLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;


/**
 * activiy基类
 * Created by jie on 15-6-17.
 */
public abstract class BaseActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    protected boolean mIsStoped = false;
    protected boolean mIsFinished = false;
    protected boolean mIsDestroyed = false;
    protected Toolbar mToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    protected  void setToolBarTitle(String title)
    {
        if(null != getSupportActionBar())
        {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);

    }

    /**
     * 监听左上角返回按钮事件
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mIsStoped = false;
        mIsFinished = false;
        mIsDestroyed = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.mIsDestroyed = true;
    }

    @Override
    public void finish() {
        this.mIsFinished = true;
        super.finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.mIsStoped = true;
    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onPause() {
        super.onPause();

    }



    public boolean isStoped() {
        return this.mIsStoped;
    }

    public boolean isFinished() {
        return this.mIsFinished;
    }

    public boolean isDestroyed() {
        return this.mIsDestroyed;
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (onBackDown()) {
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }



    protected boolean onBackDown() {
        return false;
    }


    /**
     * 6.0申请权限时临时存放的回调变量，用完即销毁

    private MPermissionUtils.MPermissionsCallBack mCallBack;
    private static final int RequestPermissionCodeRW = 88;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (null != mCallBack || requestCode == RequestPermissionCodeRW) {
            MPermissionUtils.handleRWPermissionsResult(grantResults, mCallBack);
        }
        mCallBack = null;
    }


    /**
     * 处理磁盘存取权限
     *
     * @param callBack

    public void requestRWPermissionsCallback(MPermissionUtils.MPermissionsCallBack callBack) {
        if (MPermissionUtils.checkRWPermissionNotRequest(this)) {
            callBack.onGranted();
            return;
        }
        mCallBack = callBack;
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, RequestPermissionCodeRW);
    }


    */
}
