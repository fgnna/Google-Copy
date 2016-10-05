package com.it.googlecopy.module.home;


import android.app.DownloadManager;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.google.gson.Gson;
import com.it.googlecopy.R;
import com.it.googlecopy.base.BaseFragment;
import com.it.googlecopy.module.home.adapter.HomeItemAdapter;
import com.it.googlecopy.module.home.bean.HomeItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by je on 16-10-2.
 */

public class HomeFragment extends Fragment {
    Toolbar mToolbar;
    RecyclerView mRecyclerView;
    List<HomeItem.DataBean> mDataBeen;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.home_fragment_recyvlerview);
        mToolbar= (Toolbar) view.findViewById(R.id.toolbar);
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
        initData();

    }



    /** 访问网络拿数据 */
    public void initData() {
        if(mDataBeen == null){
            mDataBeen = new ArrayList<>();
        }
        final Gson gson = new Gson();
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest("http://192.168.1" +
                ".105:8080/demo/query", new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                HomeItem homeItem = gson.fromJson(response, HomeItem.class);
                mDataBeen = homeItem.getData();
                HomeItemAdapter homeItemAdapter = new HomeItemAdapter(mDataBeen);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                mRecyclerView.setLayoutManager(linearLayoutManager);
                mRecyclerView.setItemAnimator(new DefaultItemAnimator());  //设置item默认动画
                mRecyclerView.setAdapter(homeItemAdapter);
                System.out.println(mDataBeen.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("-------------------------------"+error.toString());
            }
        } ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();

                return map;
            }
        };

        requestQueue.add(stringRequest);
        System.out.println("完毕");



    }
}
