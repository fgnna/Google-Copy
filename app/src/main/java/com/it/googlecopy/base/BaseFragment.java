package com.it.googlecopy.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 片段基类
 * Created by je on 16-10-2.
 */

public abstract class BaseFragment extends Fragment {
    public Context mContext;
    private View rooView; //片段根节点

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rooView = initView();
        return rooView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /** 初始化视图 */
    public abstract View initView();

    /** 初始化数据 */
    public abstract void initData();
}
