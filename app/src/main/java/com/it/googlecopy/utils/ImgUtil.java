package com.it.googlecopy.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;

/**
 * Created by je on 16-10-6.
 */

public class ImgUtil {
    private ImgUtil(){}

    public static Drawable getTintDrawable(Drawable drawable, @ColorInt int color) {
        Drawable.ConstantState state = drawable.getConstantState();
        Drawable drawable1 = DrawableCompat.wrap(state == null ? drawable : state.newDrawable()).mutate();
        drawable1.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        DrawableCompat.setTint(drawable1, color);
        return drawable1;
    }

}
