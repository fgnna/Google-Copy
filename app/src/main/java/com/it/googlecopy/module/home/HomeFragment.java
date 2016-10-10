package com.it.googlecopy.module.home;


import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.google.gson.Gson;
import com.it.googlecopy.R;
import com.it.googlecopy.module.home.adapter.HomeItemAdapter;
import com.it.googlecopy.module.home.model.bean.HomeItem;
import com.it.googlecopy.utils.ThreadPoolUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by je on 16-10-2.
 */

public class HomeFragment extends Fragment {
    Toolbar mToolbar;
    RecyclerView mRecyclerView;
    List<HomeItem.DataBean> mDataBeen;
    private SwipeRefreshLayout mRefreshLayout;
    HomeActivity mHomeActivity;
    FloatingActionButton fab;
    HomeItemAdapter homeItemAdapter;
    CoordinatorLayout conten;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.home_fragment_recyvlerview);
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.m_home_fragment_refreshlayout);
        conten = (CoordinatorLayout) view.findViewById(R.id.homt_conten);
        mHomeActivity = (HomeActivity) getActivity();
        mHomeActivity.mLinearLayout.setVerticalScrollBarEnabled(true);
        initRefreshLayout();
        initRecyclerView();

        CoordinatorLayout.LayoutParams coordinatorLayoutLayoutParams = (CoordinatorLayout
                .LayoutParams) conten.getLayoutParams();


//        coordinatorLayoutLayoutParams.setBehavior();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HomeActivity activity = (HomeActivity) getActivity();
        mToolbar.setTitle("首页");

        activity.setSupportActionBar(mToolbar);

        DrawerLayout drawerLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(activity,
                drawerLayout, mToolbar, R.string.navigation_drawer_open, R.string
                .navigation_drawer_close);
        mToolbar.setBackgroundResource(android.R.color.holo_red_dark);
        mToolbar.setTitleTextColor(Color.WHITE);
        drawerToggle.syncState();
       /* fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"别乱点！",Snackbar.LENGTH_SHORT).setAction("Action", null).show();
            }
        });*/


    }

    private void initRefreshLayout() {
        mRefreshLayout.setColorSchemeResources( //要显示的颜色
                android.R.color.holo_blue_dark,
                android.R.color.holo_red_dark,
                android.R.color.holo_green_dark,
                android.R.color.holo_purple);

        mRefreshLayout.setProgressViewOffset(false,130,180);
        mRefreshLayout.setRefreshing(true); //显示下拉刷新控件
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                reloadDatas();
            }
        });
    }

    private void initRecyclerView() {
        mDataBeen = new ArrayList<>();
        homeItemAdapter = new HomeItemAdapter(mDataBeen);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());  //设置item默认动画
        mRecyclerView.setAdapter(homeItemAdapter);
        homeItemAdapter.notifyDataSetChanged();
        reloadDatas();
    }



    private void reloadDatas() {
        ThreadPoolUtil.execute(new Runnable() {
            @Override
            public void run() {
                loadDatas();//加载新的数据
                SystemClock.sleep(3000);//模拟访问网络加载数据
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        homeItemAdapter.setDatas(mDataBeen);//刷新界面，显示新的数据
                        mRefreshLayout.setRefreshing(false); //隐藏下拉刷新控件
                    }
                });
            }
        });
    }

    public void loadDatas(){
        if (mDataBeen == null) {
            mDataBeen = new ArrayList<>();
        }
        final Gson gson = new Gson();
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest("http://192.168.1" +
                ".105:8080/demo/query", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                HomeItem homeItem = gson.fromJson(response, HomeItem.class);
                mDataBeen.addAll(homeItem.data);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("-------------------------------" + error.toString());
            }
        });
        requestQueue.add(stringRequest);


    }
}
