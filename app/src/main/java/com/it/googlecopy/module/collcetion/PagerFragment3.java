package com.it.googlecopy.module.collcetion;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.it.googlecopy.R;


public class PagerFragment3 extends Fragment {

    View rootView;
    public static PagerFragment3 newInstance(){
        PagerFragment3 pagerFragment3 = new PagerFragment3();
        return pagerFragment3;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.collection_pager_fragment3,container,false);
        return rootView;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {

    }


}
