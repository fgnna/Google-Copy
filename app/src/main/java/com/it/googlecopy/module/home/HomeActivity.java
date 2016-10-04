package com.it.googlecopy.module.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    Fragment currentFragment;
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
    List<Fragment> mFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home_main);


        initView();
        initDrawerLayout();
        initListener();


    }

    private void initListener() {
        mFirstPager.setOnClickListener(this);
        mCollection.setOnClickListener(this);
        mWork.setOnClickListener(this);
        mNotifications.setOnClickListener(this);
    }



    public void initDrawerLayout() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, mToolbar, R.string.navigation_drawer_open, R.string
                .navigation_drawer_close);
        drawerToggle.syncState();


    }


    private void initView() {
        mFragmentList = new ArrayList<>();
        CircleImageView mHomeDrawLayoutHead = (CircleImageView) findViewById(R.id
                .m_home_drawleft_head);

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.m_home_framelayout);
        home_fragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.m_home_framelayout,home_fragment,"home").addToBackStack(null).commit();
        mFragmentList.add(home_fragment);

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
                if(home_fragment == null){
                    home_fragment = new HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.m_home_framelayout,home_fragment,"home").
                            addToBackStack(null).commit();
                    mFragmentList.add(home_fragment);
                }
                showFragment("home");
                break;
            case R.id.m_home_collection:
                System.out.println("collection");
                if(collection_fragment == null){
                    collection_fragment = new CollectionFragment();

                    getSupportFragmentManager().beginTransaction().replace(R.id.m_home_framelayout,collection_fragment,"collection")
                            .addToBackStack(null).commit();
                    mFragmentList.add(home_fragment);
                }
                showFragment("collection");
                break;
            case R.id.m_home_work:
                System.out.println("work");
                if(work_fragment == null){
                    work_fragment = new WorkFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.m_home_framelayout,home_fragment,"home").commit();
                    mFragmentList.add(work_fragment);
                }
                showFragment("work");
                break;
            case R.id.m_home_notifications:
                System.out.println("notifications");
                if(notifications_fragment == null){
                    notifications_fragment = new NotificationsFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.m_home_framelayout,notifications_fragment,"notifications").commit();
                    mFragmentList.add(home_fragment);
                }
                showFragment("notifications");
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

    private void showFragment(String tag) {
        for (Fragment fragment : mFragmentList) {
            Fragment tagFragment = getSupportFragmentManager().findFragmentByTag(tag);
            String tag1 = fragment.getTag();

            if(tag1 == tag){
                getSupportFragmentManager().beginTransaction().show(tagFragment).commit();
            }else {
                getSupportFragmentManager().beginTransaction().hide(tagFragment).commit();
            }
        }
    }


}
