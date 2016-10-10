package com.it.googlecopy.base;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.it.googlecopy.R;

public class TintTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tint_test);
        ImageView img1 = (ImageView) findViewById(R.id.imager1);
        ImageView img2 = (ImageView) findViewById(R.id.imager2);
        ImageView img3 = (ImageView) findViewById(R.id.imager3);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.ic_my_location_black_24dp);
        Drawable drawable1 = getTintDrawable(drawable, ContextCompat.getColor(this, android.R
                .color.holo_green_dark));
        img1.setImageDrawable(drawable1);



        int[] colors = new int[]{ContextCompat.getColor(this,R.color.pink),ContextCompat.getColor(this,R.color.pink1)};
        int[][] states = new int[2][];
        states[0] = new int[]{android.R.attr.state_pressed};
        states[1] = new int[]{};



    }

    private Drawable getTintDrawable(Drawable drawable,@ColorInt int color) {
        Drawable.ConstantState state = drawable.getConstantState();
        Drawable drawable1 = DrawableCompat.wrap(state == null ? drawable : state.newDrawable()).mutate();
        drawable1.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        DrawableCompat.setTint(drawable1, color);
        return drawable1;
    }

   /* private Drawable getStatesDrawable(Drawable drawable, int[] colors, int[][] states){
        ColorStateList colorStateList = new ColorStateList(states, colors);
        Drawable.ConstantState constantState = drawable.getConstantState();
        drawable = DrawableCompat.wrap(states == null ? drawable : constantState
                .newDrawable()).mutate();
        DrawableCompat.setTintList(drawable,colorStateList);
    }*/

}
