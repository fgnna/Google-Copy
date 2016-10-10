package com.it.googlecopy.module.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.it.googlecopy.R;
import com.it.googlecopy.module.home.model.bean.HomeItem;
import com.it.googlecopy.utils.ImgTempCache;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by je on 16-10-8.
 */

public class HomeDetail extends AppCompatActivity {
    HomeItem.DataBean bean;
    List<View> mViewList;
    Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bean = (HomeItem.DataBean) getIntent().getSerializableExtra("bean");
        setContentView(R.layout.first_detail);
        initToolBar();
        CircleImageView headImg = (CircleImageView) findViewById(R.id.home_detail_head);
        headImg.setImageBitmap(ImgTempCache.sBitmapList.get(bean.getAvaterUrl()));
        ImageView contenImg = (ImageView) findViewById(R.id.home_detail_contentimg);
        contenImg.setImageBitmap(ImgTempCache.sBitmapList.get(bean.getImgUrl()));
        TextView title = (TextView) findViewById(R.id.home_detail_title);
        title.setText(bean.getTitle());
        TextView userName = (TextView) findViewById(R.id.home_detail_author);
        userName.setText(bean.getUserName());
        if (bean.isIsLike()) {
            ImageButton plusImgBtn = (ImageButton) findViewById(R.id.home_detail_plus_imgbtn);
            plusImgBtn.setImageResource(R.drawable.quantum_ic_plus_one_black_24);
            String str = bean.getLikeCount() + "";
            int i = Integer.parseInt(str);
            i++;
            TextView count = (TextView) findViewById(R.id.home_detail_plus_text);
            count.setText(String.valueOf(i));
        }else {
            TextView count = (TextView) findViewById(R.id.home_detail_plus_text);
            count.setText(bean.getLikeCount()+"");
        }

        LinearLayout comment = (LinearLayout) findViewById(R.id.first_detail_comment_llt);
        for(int i= 0; i < 10; i++){
            if(mViewList == null){
                mViewList = new ArrayList<>();
            }
        View view = View.inflate(this, R.layout.first_detail_item, null);
            mViewList.add(view);
        }
        for (int i = 0; i < mViewList.size(); i++) {
            comment.addView(mViewList.get(i));
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.homedetail_toolbar);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setBackgroundResource(android.R.color.holo_red_dark);
    }


}
