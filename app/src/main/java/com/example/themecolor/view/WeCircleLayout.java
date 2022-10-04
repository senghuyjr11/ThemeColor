package com.example.themecolor.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.themecolor.R;
import com.example.themecolor.conf.Conf;

public class WeCircleLayout extends LinearLayout implements Conf.OnThemeSet {
    public WeCircleLayout(Context context) {
        super(context);
        Conf.onCheckTheme(context,this);
    }

    public WeCircleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Conf.onCheckTheme(context,this);
    }

    public WeCircleLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Conf.onCheckTheme(context,this);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onSetTheme(Context context, int color) {
        this.setBackground(context.getDrawable(R.drawable.shape_button_bg_circle));
    }
}
