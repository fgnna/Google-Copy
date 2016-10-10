package com.it.googlecopy.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.R.attr.bitmap;

/**
 * Created by je on 16-10-8.
 */

public class ImgTempCache {
    private ImgTempCache(){}



    public static Map<String, Bitmap> sBitmapList = new HashMap<>();
    public static void addCache(String key,Bitmap bitmap){
        sBitmapList.put(key, bitmap);
    }
}
