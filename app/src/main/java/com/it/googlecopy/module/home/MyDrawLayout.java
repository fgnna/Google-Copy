package com.it.googlecopy.module.home;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by je on 16-10-11.
 */

public class MyDrawLayout extends DrawerLayout {

    private int mTouchSlop;
    private float mLastMotionX;
    private float mLastMotionY;

    public MyDrawLayout(Context context) {
        super(context);
    }

    public MyDrawLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyDrawLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        final ViewConfiguration configuration = ViewConfiguration.get(getContext());
        mTouchSlop = configuration.getScaledTouchSlop(); // 表示滑动的时候手指移动要大于这个距离才开始移动控件
    }

/*    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            float x = ev.getX();
            float y = ev.getY();

            switch (ev.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mLastMotionX = x;
                    mLastMotionY = y;
                    System.out.println("down X ----" + mLastMotionY + " down Y ----" +mLastMotionY);
                    break;

                case MotionEvent.ACTION_MOVE:
                    int xDiff = (int) Math.abs(x - mLastMotionX);
                    int yDiff = (int) Math.abs(y - mLastMotionY);
                    int x_yDiff = xDiff * xDiff + yDiff * yDiff;

                    boolean XMoved = x_yDiff > mTouchSlop * mTouchSlop;

                    if (XMoved) {
                        if (xDiff > yDiff * 4) {
                            return false;
                        } else {
                            return true;
                        }
                    }
                    break;

                default:
                    break;

            }
            return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        try {
            return super.onTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
        }
        return false;
    }*/
}

