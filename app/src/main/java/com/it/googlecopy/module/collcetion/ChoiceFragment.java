package com.it.googlecopy.module.collcetion;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.it.googlecopy.R;

import java.util.List;


public class ChoiceFragment extends Fragment {
    private List<CollectionBean.DataBean> mBeanList;
    private View rootView;
    private RecyclerView mRecyclerView;
    public static ChoiceFragment newInstance(List<CollectionBean.DataBean> list){

        ChoiceFragment choiceFragment = new ChoiceFragment();
        choiceFragment.mBeanList = list;
        return choiceFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.collection_pager_fragment,container,false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.m_tab_choice);
        setupRecyclerView(mRecyclerView);
        return mRecyclerView;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        CollectionItemAdapter adapter = new CollectionItemAdapter(mBeanList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onPause() {
        super.onPause();

    }
}
