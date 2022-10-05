package com.example.themecolor.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

public class UtilsSize {

    public static int getValueInDP(Context context, int value){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources().getDisplayMetrics());
    }

    public static int getThemeColorWidth(Activity activity){
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        if (displaymetrics.widthPixels <= 768){
            if (displaymetrics.heightPixels <= 1280){
                return UtilsSize.getValueInDP(activity.getBaseContext(), 58);
            }else{
                return UtilsSize.getValueInDP(activity.getBaseContext(), 60);
            }
        } else if (displaymetrics.widthPixels <= 1080){
            if (displaymetrics.heightPixels <= 1980){
                return UtilsSize.getValueInDP(activity.getBaseContext(), 54);
            }else{
                return UtilsSize.getValueInDP(activity.getBaseContext(), 64);
            }

        }else if (displaymetrics.widthPixels <= 1440){
            if (displaymetrics.heightPixels <= 2580) {
                return UtilsSize.getValueInDP(activity.getBaseContext(), 54);
            }else{
                return UtilsSize.getValueInDP(activity.getBaseContext(), 64);
            }
        }else{
            return UtilsSize.getValueInDP(activity.getBaseContext(), 90);
        }
    }

    public static int getThemeColorHeight(Activity activity, boolean isMulti){
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        if (displaymetrics.widthPixels <= 768){
            if (displaymetrics.heightPixels <= 1280){
                return UtilsSize.getValueInDP(activity.getBaseContext(), 90);
            }else{
                return UtilsSize.getValueInDP(activity.getBaseContext(), 100);
            }
        } else if (displaymetrics.widthPixels <= 1080){
            if (displaymetrics.heightPixels <= 1980){
                return UtilsSize.getValueInDP(activity.getBaseContext(), 100);
            }else{
                return UtilsSize.getValueInDP(activity.getBaseContext(), 120);
            }

        }else if (displaymetrics.widthPixels <= 1440){
            if (displaymetrics.heightPixels <= 2580) {
                return UtilsSize.getValueInDP(activity.getBaseContext(), 100);
            }else{
                return UtilsSize.getValueInDP(activity.getBaseContext(), 110);
            }
        }else{
            return UtilsSize.getValueInDP(activity.getBaseContext(), 120);
        }
    }

}
