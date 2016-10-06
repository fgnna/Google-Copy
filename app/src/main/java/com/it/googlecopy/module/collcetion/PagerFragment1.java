package com.it.googlecopy.module.collcetion;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.it.googlecopy.R;

import java.util.ArrayList;
import java.util.List;


public class PagerFragment1 extends Fragment {
    private View rootView;
    private RecyclerView mRecyclerView;
    public static PagerFragment1 newInstance(){
        PagerFragment1 pagerFragment1 = new PagerFragment1();
        return pagerFragment1;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.collection_pager_fragment1,container,false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.m_tab_choice);
        setupRecyclerView(mRecyclerView);
        return mRecyclerView;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(createItemList());
        recyclerView.setAdapter(recyclerAdapter);
    }

    private List<String> createItemList() {
        List<String> itemList = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                itemList.add("Item " + i);
            }

        return itemList;
    }


}
