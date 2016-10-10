package com.it.googlecopy.module.home;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by je on 16-10-10.
 */

public class CustomExpandBehavior extends CoordinatorLayout.Behavior<View> {
    CustomExpandBehavior(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    /**
     * 是否跟随AppBarLayout对象
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        //这个方法是说明这个子控件是依赖AppBarLayout的
        return dependency instanceof AppBarLayout;
    }

    /**
     * 跟随改变行为
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        float delata = Math.abs(dependency.getTop());//获取更随布局的顶部位置
        child.setTranslationY(delata);
        return true;
    }
}
