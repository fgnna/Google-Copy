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
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.it.googlecopy.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.it.googlecopy.R.id.m_home_framelayout;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    Fragment currentFragment;
    public Toolbar mToolbar;
    FragmentManager fm;
    HomeFragment home_fragment;
    CollectionFragment collection_fragment;
    MeFragment me_fragment;
    SettingFragment setting_fragment;

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
        FrameLayout frameLayout = (FrameLayout) findViewById(m_home_framelayout);
        mFirstPager = (RelativeLayout) findViewById(R.id.m_home_firstpager);
        mCollection = (RelativeLayout) findViewById(R.id.m_home_collection);
        mNotifications = (RelativeLayout) findViewById(R.id.m_home_notifications);
        mWork = (RelativeLayout) findViewById(R.id.m_home_work);
        home_fragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(m_home_framelayout,home_fragment,"home").commitNow();
        home_fragment.initData();
        mFragmentList.add(home_fragment);

        Glide.with(this).load("http://img.my.csdn.net/uploads/201404/13/1397393290_5765.jpeg").into(mHomeDrawLayoutHead);

    }



    public void onClick(View view) {
        fm = getSupportFragmentManager();
        switch (view.getId()) {
            case R.id.m_home_firstpager:
                if(setting_fragment != null) {
                    getFragmentManager().beginTransaction().hide(setting_fragment).commit();
                }
                showFragment("home");
                break;
            case R.id.m_home_collection:
                System.out.println("collection");
                if(setting_fragment != null) {
                    getFragmentManager().beginTransaction().hide(setting_fragment).commit();
                }
                if(collection_fragment == null){
                    collection_fragment = new CollectionFragment();
                    fm.beginTransaction().add(R.id.m_home_framelayout,collection_fragment,"collection").commitNow();
                    mFragmentList.add(collection_fragment);
                }

                showFragment("collection");
                break;
            case R.id.m_home_work:
                System.out.println("work");
                if(setting_fragment != null) {
                    getFragmentManager().beginTransaction().hide(setting_fragment).commit();
                }
                if(me_fragment == null){
                    me_fragment = new MeFragment();
                    fm.beginTransaction().add(R.id.m_home_framelayout, me_fragment,"me").commitNow();
                    mFragmentList.add(me_fragment);
                }
                showFragment("me");
                break;
            case R.id.m_home_notifications:
                System.out.println("setting");
                if(setting_fragment == null){
                    setting_fragment = new SettingFragment();
                    getFragmentManager().beginTransaction().add(R.id.m_home_framelayout, setting_fragment,"setting").commit();
                }
                showFragment("setting");
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

    /** fragement的显示 */
    private void showFragment(String tag) {

        if(tag == "setting"){
            getFragmentManager().beginTransaction().show(setting_fragment).commit();
        }
            Fragment tagFragment = getSupportFragmentManager().findFragmentByTag(tag);
        for (Fragment fragment : mFragmentList) {
            String tag1 = fragment.getTag();
            getSupportFragmentManager().getFragments();

            if(tag1 == tag){
                getSupportFragmentManager().beginTransaction().show(tagFragment).commitNow();
            }else {
                getSupportFragmentManager().beginTransaction().hide(fragment).commitNow();
            }

        }
    }


}
