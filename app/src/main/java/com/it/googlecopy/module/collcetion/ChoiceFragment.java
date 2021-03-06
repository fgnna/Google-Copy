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

import com.it.googlecopy.R;
import com.it.googlecopy.base.BaseAsyncTask;
import com.it.googlecopy.module.collcetion.model.bean.CollectionBean;
import com.it.googlecopy.module.collcetion.model.bean.CollectionModel;
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
        if(mBeanList == null){
            mBeanList = new ArrayList<>();
        }
        new BaseAsyncTask(getActivity(), null) {
            @Override
            protected Object doInBackground() throws Exception {
                return CollectionModel.getCollectionData();
            }

            @Override
            protected void onNullData() {

            }

            @Override
            protected void onSuccess(Object data) {
                mBeanList.addAll(((CollectionBean)data).data);
            }
        }.execute();
    }


    public void addDatas(List<CollectionBean.DataBean> list){
        this.mBeanList.addAll(list);
        adapter.setDatas(mBeanList);
        adapter.notifyDataSetChanged();
    }



}
