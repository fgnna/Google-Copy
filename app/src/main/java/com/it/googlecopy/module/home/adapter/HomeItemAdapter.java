package com.it.googlecopy.module.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.it.googlecopy.R;
import com.it.googlecopy.module.home.HomeDetail;
import com.it.googlecopy.module.home.adapter.Holder.HomeItemViewHolder;
import com.it.googlecopy.module.home.model.bean.HomeItem;
import com.it.googlecopy.utils.ImgTempCache;
import com.it.googlecopy.utils.ShareUtil;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;


/**
 * Created by je on 16-10-4.
 */

public class HomeItemAdapter extends RecyclerView.Adapter<HomeItemViewHolder> {

    private List<HomeItem.DataBean> itemList;
    Context mContext;

    private List<Integer> checkPositionlist; //选中的数据

    public  HomeItemAdapter(List<HomeItem.DataBean> itemList) {
        this.itemList = itemList;
    }

    @Override
    public HomeItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item,
                parent, false);
        mContext = parent.getContext();
        checkPositionlist = new ArrayList<>();
        HomeItemViewHolder holder = new HomeItemViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(final HomeItemViewHolder holder, int position) {
        final HomeItem.DataBean dataBean = itemList.get(position);

        TextView pulsText = holder.getPulsText();
        int likeCount = dataBean.likeCount;
        pulsText.setText(likeCount + "");
        if (dataBean.isLike) {
            if(!checkPositionlist.contains(holder.getPulsImgBtn().getTag())) {
                holder.getPulsImgBtn().setImageResource(R.drawable.quantum_ic_plus_one_black_24);
                holder.getPulsImgBtn().setTag(position);
                checkPositionlist.add(position);
            }
            String str = holder.getPulsText().getText().toString();
            int i = Integer.parseInt(str);
            i++;
            holder.getPulsText().setText(String.valueOf(i));

        }
        else {
            if (checkPositionlist.contains(holder.getPulsImgBtn().getTag())) {
                holder.getPulsImgBtn().setImageResource(R.drawable.quantum_ic_plus_one_white_24);
                checkPositionlist.remove(new Integer(position));
            }
        }
        holder.getTitle().setText(dataBean.title);
        holder.getUserName().setText(dataBean.userName);
        Glide.with(mContext).load(dataBean.avaterUrl).asBitmap().placeholder(R.drawable
                .bg_toast_grey700_44).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                ImgTempCache.addCache(dataBean.avaterUrl,resource);
                holder.getHead().setImageBitmap(resource);
            }
        });
        Glide.with(mContext).load(dataBean.imgUrl).asBitmap().placeholder(R.drawable.bg_toast_grey700_44).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                ImgTempCache.addCache(dataBean.imgUrl,resource);
                holder.getContentImg().setImageBitmap(resource);
            }
        });


        holder.getCommentBtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick(dataBean);
            }
        });
        holder.getContentImg().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick(dataBean);
            }
        });

        holder.getShareBtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareUtil.showShare(mContext);
            }
        });


    }
    private void itemClick(HomeItem.DataBean dataBean) {
        Intent intent = new Intent(mContext, HomeDetail.class);
        intent.putExtra("bean",dataBean);
        mContext.startActivity(intent);
    }
    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void setDatas(List<HomeItem.DataBean> list){
        this.itemList = list;
        notifyDataSetChanged();
    }







}


