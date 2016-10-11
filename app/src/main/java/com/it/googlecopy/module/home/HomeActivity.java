package com.it.googlecopy.module.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.it.googlecopy.R;
import com.it.googlecopy.module.collcetion.CollectionFragment;
import com.it.googlecopy.utils.ImgUtil;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.media.CamcorderProfile.get;
import static com.it.googlecopy.R.id.m_home_framelayout;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

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
    List<ImageView> imgList;
    List<TextView> textList;
    LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home_main);
        initImgListAndTextList();
        mLinearLayout = (LinearLayout) findViewById(R.id.home_llt);
        initView();
        initDrawerLayout();
        initListener();
        tintDrawable(0);


    }

    private void initImgListAndTextList() {

        ImageView img1 = (ImageView) findViewById(R.id.firstpager_img2);
        ImageView img2 = (ImageView) findViewById(R.id.collection_img);
        ImageView img3 = (ImageView) findViewById(R.id.work_img);
        ImageView img4 = (ImageView) findViewById(R.id.notifications_img);


        imgList = new ArrayList<>();
        imgList.add(img1);
        imgList.add(img2);
        imgList.add(img3);
        imgList.add(img4);

        TextView text1 = (TextView) findViewById(R.id.first_text);
        TextView text2 = (TextView) findViewById(R.id.collection_text);
        TextView text3 = (TextView) findViewById(R.id.work_text);
        TextView text4 = (TextView) findViewById(R.id.notifications_text);

        textList = new ArrayList<>();
        textList.add(text1);
        textList.add(text2);
        textList.add(text3);
        textList.add(text4);


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
        getSupportFragmentManager().beginTransaction().replace(m_home_framelayout, home_fragment,
                "home").commitNow();
        //home_fragment.loadDatas();
        mFragmentList.add(home_fragment);

        Glide.with(this).load("http://img.my.csdn.net/uploads/201404/13/1397393290_5765.jpeg")
                .into(mHomeDrawLayoutHead);

    }


    public void onClick(View view) {
        fm = getSupportFragmentManager();
        switch (view.getId()) {
            case R.id.m_home_firstpager:
                if (setting_fragment != null) {
                    getFragmentManager().beginTransaction().hide(setting_fragment).commit();
                }
                tintDrawable(0);
                showFragment("home");
                break;
            case R.id.m_home_collection:
                System.out.println("collection");
                if (setting_fragment != null) {
                    getFragmentManager().beginTransaction().hide(setting_fragment).commit();
                }
                if (collection_fragment == null) {
                    collection_fragment = new CollectionFragment();
                    fm.beginTransaction().add(R.id.m_home_framelayout, collection_fragment,
                            "collection").commitNow();
                    mFragmentList.add(collection_fragment);
                }
                tintDrawable(1);
                showFragment("collection");
                break;
            case R.id.m_home_work:
                System.out.println("work");
                if (setting_fragment != null) {
                    getFragmentManager().beginTransaction().hide(setting_fragment).commit();
                }
                if (me_fragment == null) {
                    me_fragment = new MeFragment();
                    fm.beginTransaction().add(R.id.m_home_framelayout, me_fragment, "me")
                            .commitNow();
                    mFragmentList.add(me_fragment);
                }
                tintDrawable(2);
                showFragment("me");
                break;
            case R.id.m_home_notifications:
                System.out.println("setting");
                if (setting_fragment == null) {
                    setting_fragment = new SettingFragment();
                    getFragmentManager().beginTransaction().add(R.id.m_home_framelayout,
                            setting_fragment, "setting").commit();
                }
                tintDrawable(3);
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

    private void tintDrawable(int i) {
        Drawable tintDrawable;
        ImageView imageView = imgList.get(i);
        for (int i1 = 0; i1 < imgList.size(); i1++) {
            if (imgList.get(i1) == imageView) {
               tintDrawable = ImgUtil.getTintDrawable(imageView.getDrawable(),
                        ContextCompat.getColor(this,
                        android.R.color.holo_red_light));
                imageView.setImageDrawable(tintDrawable);
                textList.get(i1).setTextColor(ContextCompat.getColor(this,
                        android.R.color.holo_red_light));
            }else {
                ImageView imageView1 = imgList.get(i1);
                tintDrawable = ImgUtil.getTintDrawable(imageView1.getDrawable(),
                        ContextCompat.getColor(this, android.R.color.white));
                imageView1.setImageDrawable(tintDrawable);
                textList.get(i1).setTextColor(ContextCompat.getColor(this,
                        android.R.color.white));
            }
        }


    }

    /**
     * fragement的显示
     */
    private void showFragment(String tag) {

        if (tag == "setting") {
            getFragmentManager().beginTransaction().show(setting_fragment).commit();
        }
        Fragment tagFragment = getSupportFragmentManager().findFragmentByTag(tag);
        for (Fragment fragment : mFragmentList) {
            String tag1 = fragment.getTag();
            getSupportFragmentManager().getFragments();

            if (tag1 == tag) {
                getSupportFragmentManager().beginTransaction().show(tagFragment).commitNow();
            } else {
                getSupportFragmentManager().beginTransaction().hide(fragment).commitNow();
            }

        }
    }


}
