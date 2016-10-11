package com.it.googlecopy.module.home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.it.googlecopy.R;

/**
 * Created by je on 16-10-2.
 */

public class MeFragment extends Fragment {
    Toolbar mToolbar;
    AppBarLayout mAppBarLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.me_fragment, container, false);
        mToolbar= (Toolbar) view.findViewById(R.id.toolbar);
        mAppBarLayout = (AppBarLayout) view.findViewById(R.id.app_bar);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HomeActivity activity = (HomeActivity) getActivity();
        mToolbar.setTitle("");
        activity.setSupportActionBar(mToolbar);

        DrawerLayout drawerLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(activity,
                drawerLayout, mToolbar, R.string.navigation_drawer_open, R.string
                .navigation_drawer_close);
        //mToolbar.setBackgroundResource(android.R.color.holo_green_dark);
        mToolbar.setTitleTextColor(Color.WHITE);
        drawerToggle.syncState();
        initToolbarChanger();
    }

    private void initToolbarChanger() {
        final LinearLayout llt = ((HomeActivity)getActivity()).mLinearLayout;
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int i = Math.abs(verticalOffset);
                llt.setTranslationY(i);
            }
        });
    }
}
