package com.it.googlecopy.module.home;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.it.googlecopy.R;
import com.it.googlecopy.module.collcetion.CollectionBean;
import com.it.googlecopy.module.collcetion.CollectionPagerAdapter;
import com.it.googlecopy.module.collcetion.ChoiceFragment;
import com.it.googlecopy.utils.ThreadPoolUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by je on 16-10-2.
 */

public class CollectionFragment extends Fragment {
    Toolbar mToolbar;
    View rootView;
    HomeActivity activity;
    boolean isFrist = false;
    private List<CollectionBean.DataBean> mBeanList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.collection_fragment, container, false);
        return rootView;
    }


    private void initViewPagerAndTabs() {
        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.m_colletion_vp);
        final CollectionPagerAdapter pagerAdapter = new CollectionPagerAdapter(activity
                .getSupportFragmentManager());

        pagerAdapter.addFragment(ChoiceFragment.newInstance(this), "精选");
        pagerAdapter.addFragment(ChoiceFragment.newInstance(this), "已关注");
        pagerAdapter.addFragment(ChoiceFragment.newInstance(this), "你的收藏集");
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.m_colletion_tablayout);
        tabLayout.setBackgroundResource(android.R.color.holo_blue_dark);
        tabLayout.setupWithViewPager(viewPager);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = (HomeActivity) getActivity();
        initToolbar();
        initDrawerLayout();
        initViewPagerAndTabs();


    }





    private void initDrawerLayout() {
        DrawerLayout drawerLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(activity,
                drawerLayout, mToolbar, R.string.navigation_drawer_open, R.string
                .navigation_drawer_close);
        drawerToggle.syncState();
    }

    private void initToolbar() {
        mToolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        HomeActivity activity = (HomeActivity) getActivity();
        mToolbar.setTitle("收藏集");
        mToolbar.setBackgroundResource(android.R.color.holo_blue_dark);
        mToolbar.setTitleTextColor(Color.WHITE);
        activity.setSupportActionBar(mToolbar);
    }


}
