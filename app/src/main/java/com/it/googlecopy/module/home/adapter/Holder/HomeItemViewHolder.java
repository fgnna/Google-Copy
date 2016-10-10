package com.it.googlecopy.module.home.adapter.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.it.googlecopy.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by je on 16-10-4.
 */

public class HomeItemViewHolder extends RecyclerView.ViewHolder {


    private CircleImageView head;
    private TextView userName;
    private TextView title;
    private TextView pulsText;
    private ImageButton pulsImgBtn;
    private ImageView contentImg;
    private ImageButton commentBtn;

    public ImageButton getShareBtn() {
        return shareBtn;
    }

    private ImageButton shareBtn;

    public ImageButton getCommentBtn() {
        return commentBtn;
    }


    public ImageView getContentImg() {
        return contentImg;
    }


    public CircleImageView getHead() {
        return head;
    }

    public TextView getUserName() {
        return userName;
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getPulsText() {
        return pulsText;
    }

    public ImageButton getPulsImgBtn() {
        return pulsImgBtn;
    }

    public HomeItemViewHolder(View itemView) {
        super(itemView);
        this.userName = (TextView) itemView.findViewById(R.id.home_item_name);
        this.head = (CircleImageView) itemView.findViewById(R.id.home_item_head);
        this.pulsImgBtn = (ImageButton) itemView.findViewById(R.id.home_item_plus_imgbtn);
        this.title = (TextView) itemView.findViewById(R.id.home_item_title);
        this.pulsText = (TextView) itemView.findViewById(R.id.home_item_plus_text);
        this.contentImg = (ImageView) itemView.findViewById(R.id.home_item_contentimg);
        this.commentBtn = (ImageButton) itemView.findViewById(R.id.home_item_comment_imgbtn);
        this.shareBtn = (ImageButton) itemView.findViewById(R.id.home_item_share_imgbtn);
    }


}
