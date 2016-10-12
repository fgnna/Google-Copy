package com.it.googlecopy.module.collcetion;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.it.googlecopy.R;
import com.it.googlecopy.base.BaseFragment;
import com.it.googlecopy.module.collcetion.model.bean.CollectionBean;
import com.it.googlecopy.module.home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by je on 16-10-2.
 */

public class CollectionFragment extends BaseFragment {
    Toolbar mToolbar;
    View rootView;
    HomeActivity activity;
    private List<CollectionBean.DataBean> mBeanList = new ArrayList<>();
    LinearLayout mLinearLayout;



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
    public View initView() {
        rootView = View.inflate(mContext, R.layout.collection_fragment, null);
        mLinearLayout = (LinearLayout) ((HomeActivity) getActivity()).findViewById(R.id.home_llt);
        return rootView;
    }

    @Override
    public void initData() {
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
        AppBarLayout appBarLayout = (AppBarLayout) rootView.findViewById(R.id
                .collection_appBarLayout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int i = Math.abs(verticalOffset);
                mLinearLayout.setTranslationY(i);
            }
        });
    }


}
