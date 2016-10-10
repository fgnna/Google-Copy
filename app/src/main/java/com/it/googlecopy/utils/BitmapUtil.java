package com.it.googlecopy.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by je on 16-10-6.
 */

public class BitmapUtil {
    /**
     * 从View获取Bitmap
     *
     * @param view View
     * @return Bitmap
     */
    public static Bitmap getBitmapFromView(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),
                Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(bitmap);

        view.layout(view.getLeft(), view.getTop(), view.getRight(),
                view.getBottom());
        view.draw(canvas);

        return bitmap;
    }

}
