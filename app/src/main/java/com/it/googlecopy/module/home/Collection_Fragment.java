package com.it.googlecopy.module.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.it.googlecopy.R;
import com.it.googlecopy.base.BaseFragment;

/**
 * Created by je on 16-10-2.
 */

public class Collection_Fragment extends BaseFragment{

    @Override
    public View initView() {
        View view = View.inflate(mContext,R.layout.collection_fragment,null);
        return view;
    }

    @Override
    public void initData() {

    }
}
