package com.it.googlecopy.module.collcetion;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.it.googlecopy.R;

import java.util.List;

/**
 * Created by je on 16-10-6.
 */

public class CollectionItemAdapter extends RecyclerView.Adapter<CollectionViewHolder>{

    @Override
    public CollectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.collection_item,
                parent, false);
        CollectionViewHolder holder = new CollectionViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(CollectionViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
