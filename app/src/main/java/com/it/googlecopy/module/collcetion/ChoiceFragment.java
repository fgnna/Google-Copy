package com.it.googlecopy.module.collcetion;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.it.googlecopy.module.home.CollectionFragment;
import com.it.googlecopy.utils.ThreadPoolUtil;

import java.util.ArrayList;
import java.util.List;


public class ChoiceFragment extends Fragment {
    private List<CollectionBean.DataBean> mBeanList;
    private View rootView;
    CollectionFragment mCollectionFragment;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;
    public CollectionItemAdapter adapter;

    public static ChoiceFragment newInstance(Fragment fragment){
        ChoiceFragment choiceFragment = new ChoiceFragment();
        choiceFragment.mCollectionFragment = (CollectionFragment) fragment;

        return choiceFragment;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.collection_pager_fragment,container,false);
        mRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.m_colletion_choice_refreshlayout);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.m_tab_choice);
        initRefreshLayout();
        initRecyclerView();
        return rootView;
    }


    private void initRefreshLayout() {
        mRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_dark,
                android.R.color.holo_red_dark,
                android.R.color.holo_green_dark,
                android.R.color.holo_purple);
        mRefreshLayout.setProgressViewOffset(false,130,180);
        mRefreshLayout.setRefreshing(true);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                reLoadDatas();
            }
        });
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        adapter = new CollectionItemAdapter(mBeanList);
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        reLoadDatas();
    }


    public void reLoadDatas(){
        ThreadPoolUtil.execute(new Runnable() {
            @Override
            public void run() {
               loadData();
                SystemClock.sleep(3000);//模拟访问网络加载数据
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.setDatas(mBeanList);//刷新界面，显示新的数据
                        mRefreshLayout.setRefreshing(false); //隐藏下拉刷新控件
                    }
                });
            }
        });
    }



    public void loadData() {
        final Gson gson = new Gson();
        RequestQueue requestQueue = Volley.newRequestQueue(mCollectionFragment.getActivity());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.1" +
                ".105:8080/demo/keep", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                System.out.println("keep 成功");
                if(mBeanList == null){
                    mBeanList = new ArrayList<>();
                }
                CollectionBean collectionBean = gson.fromJson(response, CollectionBean.class);
                mBeanList.addAll(collectionBean.getData());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("keep 失败");
            }
        });

        requestQueue.add(stringRequest);
    }


    public void addDatas(List<CollectionBean.DataBean> list){
        this.mBeanList.addAll(list);
        adapter.setDatas(mBeanList);
        adapter.notifyDataSetChanged();
    }



}
