package com.it.googlecopy.module.home;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.it.googlecopy.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {


    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.home_main);
        initView();
        initToolbar();
        initDrawerLayout();
    }

    private void initDrawerLayout() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, mToolbar, R.string.navigation_drawer_open, R.string
                .navigation_drawer_close);
        drawerToggle.syncState();
        LinearLayout drawLeft = (LinearLayout) findViewById(R.id.m_home_drawleft);

    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("首页");
        setSupportActionBar(mToolbar);
    }


    private void initView() {
        CircleImageView mHomeDrawLayoutHead = (CircleImageView) findViewById(R.id
                .m_home_drawleft_head);

        /*ImageView ivtest = (ImageView) findViewById(R.id.test);
        Glide.with(this).load("http://img.woyaogexing.com/2016/09/30/70d7aa164c0cc43f!200x200" +
                ".jpg").placeholder(R.drawable.ic_help_black_24dp).error(R.drawable
                .ic_account_circle_black_24dp).into(mHomeDrawLayoutHead);*/

        Glide.with(this).load(R.drawable.bg).into(mHomeDrawLayoutHead);


    }


}
