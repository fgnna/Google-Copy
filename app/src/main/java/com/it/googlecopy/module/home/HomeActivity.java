package com.it.googlecopy.module.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.it.googlecopy.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{


    public Toolbar mToolbar;
    FragmentManager fm;
    HomeFragment home_fragment;
    CollectionFragment collection_fragment;
    WorkFragment work_fragment;
    NotificationsFragment notifications_fragment;
    RelativeLayout mFirstPager;
    RelativeLayout mCollection;
    RelativeLayout mWork;
    RelativeLayout mNotifications;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home_main);


        initView();
        initToolbar("首页");
        initDrawerLayout();
        initFragments();
        initListener();


    }

    private void initListener() {
        mFirstPager.setOnClickListener(this);
        mCollection.setOnClickListener(this);
        mWork.setOnClickListener(this);
        mNotifications.setOnClickListener(this);
    }

    private void initFragments() {
        home_fragment = new HomeFragment();
        collection_fragment = new CollectionFragment();
        work_fragment = new WorkFragment();
        notifications_fragment = new NotificationsFragment();

    }

    public void initDrawerLayout() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, mToolbar, R.string.navigation_drawer_open, R.string
                .navigation_drawer_close);
        drawerToggle.syncState();


    }

    public void initToolbar(String title) {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(title);
        setSupportActionBar(mToolbar);
    }


    private void initView() {
        CircleImageView mHomeDrawLayoutHead = (CircleImageView) findViewById(R.id
                .m_home_drawleft_head);

        mFirstPager = (RelativeLayout) findViewById(R.id.m_home_firstpager);
        mCollection = (RelativeLayout) findViewById(R.id.m_home_collection);
        mWork = (RelativeLayout) findViewById(R.id.m_home_work);
        mNotifications = (RelativeLayout) findViewById(R.id.m_home_notifications);

        Glide.with(this).load(R.drawable.bg).into(mHomeDrawLayoutHead);


    }



    public void onClick(View view) {
        fm = getSupportFragmentManager();
        switch (view.getId()) {
            case R.id.m_home_firstpager:

                if(findViewById(R.id.empty_fragment) != null) {
                    System.out.println("first");
                    //fm.beginTransaction().replace(R.id.empty_fragment, home_fragment).commit();
                    fm.beginTransaction().show(home_fragment).commit();
                }
                break;
            case R.id.m_home_collection:
                System.out.println("collection");
                fm.beginTransaction().replace(R.id.empty_fragment, collection_fragment).commit();
                break;
            case R.id.m_home_work:
                System.out.println("work");
                fm.beginTransaction().replace(R.id.empty_fragment, work_fragment).commit();
                break;
            case R.id.m_home_notifications:
                System.out.println("notifications");
                fm.beginTransaction().replace(R.id.empty_fragment, notifications_fragment).commit();
                break;

            case R.id.m_home_drawleft_personaldata:
                break;
            case R.id.m_home_drawleft_connection:
                break;
            case R.id.m_home_drawleft_location:
                break;
            case R.id.m_home_drawleft_activity:
                break;
            case R.id.m_home_drawleft_setting:
                break;
            case R.id.m_home_drawleft_send:
                break;
            case R.id.m_home_drawleft_help:
                break;
        }
    }


}
