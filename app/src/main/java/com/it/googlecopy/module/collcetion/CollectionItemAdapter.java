package com.it.googlecopy.module.collcetion;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.it.googlecopy.R;
import com.it.googlecopy.module.collcetion.model.bean.CollectionBean;

import java.util.List;

/**
 * Created by je on 16-10-6.
 */

public class CollectionItemAdapter extends RecyclerView.Adapter<CollectionViewHolder> {
    private List<CollectionBean.DataBean> mCollectionBeanList;
    private Context mContext;

    public void setDatas(List<CollectionBean.DataBean> dataBeen){
        this.mCollectionBeanList = dataBeen;
        notifyDataSetChanged();
    }

    public CollectionItemAdapter(List<CollectionBean.DataBean> beanList) {
        this.mCollectionBeanList = beanList;
    }

    @Override
    public CollectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.collection_item,
                parent, false);
        CollectionViewHolder holder = new CollectionViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(final CollectionViewHolder holder, int position) {
        final CollectionBean.DataBean bean = mCollectionBeanList.get(position);
        Glide.with(mContext).load(bean.avaterUrl).placeholder(R.drawable.bg_toast_grey700_44)
                .into(holder.getCollection_imgHead());

      /*  Glide.with(mContext).load(bean.getImgUrl()).listener(new RequestListener<String, GlideDrawable>() {

            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target,
                                       boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model,
                                           Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {

                (( GlideBitmapDrawable)resource).getBitmap();
                return false;
            }
        }).asBitmap().into(holder.getCollection_imgHead());*/

        Glide.with(mContext).load(bean.imgUrl).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                holder.getCollection_imgtop().setImageBitmap(resource);
                Palette.Builder builder = Palette.from(resource);
                builder.generate(new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(Palette palette) {
                        //获取到暗种色调
                        Palette.Swatch vibrantSwatch = palette.getDarkVibrantSwatch();
                        holder.getCollection_imgbuttom().setBackgroundColor(vibrantSwatch
                                .getRgb());
                    }
                });
            }
        });

        holder.getCollection_text_auther().setText(bean.userName);
        holder.getCollection_text_titile().setText(bean.title);
        }





    @Override
    public int getItemCount() {
        return mCollectionBeanList == null ? 0 : mCollectionBeanList.size();
    }


}
