package com.it.googlecopy.module.home;


import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.it.googlecopy.R;

/**
 * Created by je on 16-10-11.
 */

public class SettingFragment extends Fragment {
    Context mContext;
    Toolbar mToolbar;
    View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        mContext = getActivity();
        rootView = inflater.inflate(R.layout.setting_fragment,container,false);
        mToolbar = (Toolbar) rootView.findViewById(R.id.setting_toolbar);
      /*  SettingDetailFragment frm= (SettingDetailFragment) getFragmentManager().findFragmentById(R.id.setting_detail_fragment);

        initView();*/

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mToolbar.setTitle("设置");
        HomeActivity activity = (HomeActivity) getActivity();
        activity.setSupportActionBar(mToolbar);

        DrawerLayout drawerLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(activity,
                drawerLayout, mToolbar, R.string.navigation_drawer_open, R.string
                .navigation_drawer_close);
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setBackgroundResource(android.R.color.holo_red_dark);
        drawerToggle.syncState();
    }







}
