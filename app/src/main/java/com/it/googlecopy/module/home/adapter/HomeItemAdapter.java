package com.it.googlecopy.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.it.googlecopy.R;
import com.it.googlecopy.module.home.HomeActivity;
import com.it.googlecopy.module.home.adapter.Holder.HomeItemViewHolder;
import com.it.googlecopy.module.home.bean.HomeItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by je on 16-10-4.
 */

public class HomeItemAdapter extends RecyclerView.Adapter<HomeItemViewHolder> {
    private List<HomeItem.DataBean> itemList;
    Context mContext;
    private List<Integer> checkPositionlist; //选中的数据

    public HomeItemAdapter(List<HomeItem.DataBean> itemList){
        this.itemList = itemList;
    }
    @Override
    public HomeItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item,parent,false);
        mContext = parent.getContext();
        checkPositionlist = new ArrayList<>();
        HomeItemViewHolder holder = new HomeItemViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(HomeItemViewHolder holder, int position) {
        HomeItem.DataBean dataBean = itemList.get(position);
        Glide.with(mContext).load(dataBean.getAvaterUrl()).placeholder(R.drawable.bg_toast_grey700_44).into(holder.getHead());

        TextView pulsText = holder.getPulsText();
        int likeCount = dataBean.getLikeCount();
        pulsText.setText(likeCount+"");
        if(dataBean.isIsLike()){
            if(!checkPositionlist.contains(holder.getPulsImgBtn().getTag())) {
                holder.getPulsImgBtn().setTag(new Integer(position));
                holder.getPulsImgBtn().setImageResource(R.drawable.quantum_ic_plus_one_black_24);
                String str = holder.getPulsText().getText().toString();
                int i = Integer.parseInt(str);
                i++;
                holder.getPulsText().setText(String.valueOf(i));
            }
        }else {
            if(!checkPositionlist.contains(holder.getPulsImgBtn().getTag())){
                checkPositionlist.remove(new Integer(position));
            }
        }
        holder.getTitle().setText(dataBean.getTitle());
        holder.getUserName().setText(dataBean.getUserName());
        Glide.with(mContext).load(dataBean.getImgUrl()).placeholder(R.drawable.bg).into(holder.getContentImg());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


}


