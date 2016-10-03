package com.it.googlecopy.module.home;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.it.googlecopy.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {


    @BindView(R.id.m_home_firstpager)
    RelativeLayout mMHomeFirstpager;
    @BindView(R.id.m_home_collection)
    RelativeLayout mMHomeCollection;
    @BindView(R.id.m_home_work)
    RelativeLayout mMHomeWork;
    @BindView(R.id.m_home_notifications)
    RelativeLayout mMHomeNotifications;
    @BindView(R.id.fragments)
    FrameLayout mFragments;
    @BindView(R.id.m_home_drawleft_personaldata)
    RelativeLayout mMHomeDrawleftPersonaldata;
    @BindView(R.id.m_home_drawleft_connection)
    RelativeLayout mMHomeDrawleftConnection;
    @BindView(R.id.m_home_drawleft_location)
    RelativeLayout mMHomeDrawleftLocation;
    @BindView(R.id.m_home_drawleft_activity)
    RelativeLayout mMHomeDrawleftActivity;
    @BindView(R.id.m_home_drawleft_setting)
    RelativeLayout mMHomeDrawleftSetting;
    @BindView(R.id.m_home_drawleft_send)
    RelativeLayout mMHomeDrawleftSend;
    @BindView(R.id.m_home_drawleft_help)
    RelativeLayout mMHomeDrawleftHelp;
    private Toolbar mToolbar;
    FragmentManager fm;
    Home_Fragment home_fragment;
    Collection_Fragment collection_fragment;
    Work_Fragment work_fragment;
    Notifications_Fragment notifications_fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.home_main);
        ButterKnife.bind(this);
        initView();
        initToolbar();
        initDrawerLayout();
        initFragments();
        initListener();

    }

    private void initListener() {

    }

    private void initFragments() {
        home_fragment = new Home_Fragment();
        Bundle bundle = new Bundle();
        collection_fragment = new Collection_Fragment();
        work_fragment = new Work_Fragment();
        notifications_fragment = new Notifications_Fragment();
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


    @OnClick({R.id.m_home_firstpager, R.id.m_home_collection, R.id.m_home_work, R.id
            .m_home_notifications,R.id.m_home_drawleft_personaldata, R.id.m_home_drawleft_connection, R.id
            .m_home_drawleft_location, R.id.m_home_drawleft_activity, R.id
            .m_home_drawleft_setting, R.id.m_home_drawleft_send, R.id.m_home_drawleft_help})
    public void onClick(View view) {
        fm = getSupportFragmentManager();
        switch (view.getId()) {
            case R.id.m_home_firstpager:
                System.out.println("first");
                fm.beginTransaction().replace(R.id.fragments, home_fragment).commit();
                break;
            case R.id.m_home_collection:
                System.out.println("collection");
                fm.beginTransaction().replace(R.id.fragments, collection_fragment).commit();
                break;
            case R.id.m_home_work:
                fm.beginTransaction().replace(R.id.fragments, work_fragment).commit();
                break;
            case R.id.m_home_notifications:
                fm.beginTransaction().replace(R.id.fragments, notifications_fragment).commit();
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
