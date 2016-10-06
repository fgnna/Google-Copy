package com.it.googlecopy.module.collcetion;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.it.googlecopy.R;

/**
 * Created by je on 16-10-6.
 */

public class CollectionViewHolder extends RecyclerView.ViewHolder {
    private ImageView collection_imgtop;
    private ImageView collection_imgbuttom;
    private ImageView collection_imgHead;
    private TextView collection_text_auther;
    private TextView collection_text_titile;

    public CollectionViewHolder(View itemView) {
        super(itemView);
        this.collection_imgtop = (ImageView) itemView.findViewById(R.id.m_colletion_item_topimg);
        this.collection_imgbuttom = (ImageView) itemView.findViewById(R.id
                .m_colletion_item_buttomimg);
        this.collection_imgHead = (ImageView) itemView.findViewById(R.id.m_colletion_item_head);
        this.collection_text_auther = (TextView) itemView.findViewById(R.id
                .m_colletion_item_author);
        this.collection_text_titile = (TextView) itemView.findViewById(R.id
                .m_colletion_item_titile);
    }
}
