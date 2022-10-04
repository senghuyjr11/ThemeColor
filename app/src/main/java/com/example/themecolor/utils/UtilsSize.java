package com.example.themecolor.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

public class UtilsSize {

    public static int getDeviceWidthPixels(Context activity){
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity)activity).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.widthPixels;
    }
    public static int getDeviceHeightPixels(Context activity){
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity)activity).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.heightPixels;
    }

    public static int pxToDp(Context context, int px){
        float density = context.getResources().getDisplayMetrics().density;

        return (int) (px / density);
    }

    public static int getDPToPx(Context context, int size) {
        size = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, size, context.getResources()
                        .getDisplayMetrics());
        return size;
    }

    public static float dipToPixels(Context context, float dipValue){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,  dipValue, metrics);
    }

    public static int getValueInDP(Context context, int value){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources().getDisplayMetrics());
    }


    public static int getImageWidth(Activity activity, boolean isMulti){
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int devicewidth = displaymetrics.widthPixels / 3;
        if (displaymetrics.widthPixels <= 768){
            if (displaymetrics.heightPixels <= 1280){
                if (isMulti){
                    return devicewidth / 2 + devicewidth / 3 - 5;
                }else{
                    return devicewidth * 2;
                }
            }else{
                if (isMulti){
                    return devicewidth / 2 + devicewidth / 3;
                }else{
                    return devicewidth * 2 + devicewidth / 3;
                }
            }
        } else if (displaymetrics.widthPixels <= 1080){
            if (displaymetrics.heightPixels <= 1980){
                if (isMulti){
                    return devicewidth / 2 + devicewidth / 3 - 10;
                }else{
                    return devicewidth * 2 + devicewidth / 3;
                }
            }else if (displaymetrics.heightPixels <= 2200){
                if (isMulti){
                    return devicewidth / 2 + devicewidth / 3;
                }else{
                    return devicewidth * 2 + devicewidth / 3;
                }
            }else{
                if (isMulti){
                    return devicewidth / 2 + devicewidth / 3;
                }else{
                    return devicewidth * 2 + devicewidth / 2 ;
                }
            }

        }else if (displaymetrics.widthPixels <= 1440){
            if (displaymetrics.heightPixels <= 2580) {
                if (isMulti) {
                    return UtilsSize.getValueInDP(activity.getBaseContext(), 97);
                } else {
                    return devicewidth * 2 + devicewidth / 3;
                }
            }else{
                if (isMulti) {
                    return devicewidth / 2 + devicewidth / 3;
                } else {
                    return devicewidth * 2 + devicewidth / 3;
                }
            }
        }else{
            if (isMulti){
                return devicewidth / 2 + devicewidth / 3 - 10;
            }else{
                return devicewidth - devicewidth / 2;
            }

        }
    }

    public static int getThemeColorWidth(Activity activity, boolean isMulti){
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

    public static int getLangWidth(Activity activity, boolean isMulti){
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int devicewidth = displaymetrics.widthPixels / 3;
        if (displaymetrics.widthPixels <= 768){
            if (displaymetrics.heightPixels <= 1280){
                return UtilsSize.getValueInDP(activity.getBaseContext(), 105);
            }else{
                return UtilsSize.getValueInDP(activity.getBaseContext(), 110);
            }
        } else if (displaymetrics.widthPixels <= 1080){
            if (displaymetrics.heightPixels <= 1980){
                return UtilsSize.getValueInDP(activity.getBaseContext(), 97);
            }else{
                return devicewidth / 2 + devicewidth / 3;
            }

        }else if (displaymetrics.widthPixels <= 1440){
            if (displaymetrics.heightPixels <= 2580) {
                return UtilsSize.getValueInDP(activity.getBaseContext(), 98);
            }else{
                return UtilsSize.getValueInDP(activity.getBaseContext(), 113);
            }
        }else{
            return UtilsSize.getValueInDP(activity.getBaseContext(), 110);
        }
    }

    public static int getLangHeight(Activity activity, boolean isMulti){
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int deviceheight = displaymetrics.heightPixels / 3;
        if (displaymetrics.widthPixels <= 768){
            if (displaymetrics.heightPixels <= 1280){
                return UtilsSize.getValueInDP(activity.getBaseContext(), 97);
            }else{
                return UtilsSize.getValueInDP(activity.getBaseContext(), 97);
            }
        } else if (displaymetrics.widthPixels <= 1080){
            if (displaymetrics.heightPixels <= 1980){
                return UtilsSize.getValueInDP(activity.getBaseContext(), 92);
            }else if (displaymetrics.heightPixels <= 2200){
                return deviceheight / 2 - deviceheight / 12;
            }else{
                return deviceheight / 2 - deviceheight / 8;
            }

        }else if (displaymetrics.widthPixels <= 1440){
            if (displaymetrics.heightPixels <= 2580) {
                return UtilsSize.getValueInDP(activity.getBaseContext(), 90);
            }else{
                return UtilsSize.getValueInDP(activity.getBaseContext(), 105);
            }
        }else{
            return UtilsSize.getValueInDP(activity.getBaseContext(), 110);
        }
    }

    public static int getImageHeight(Activity activity, boolean isMulti){
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int deviceheight = displaymetrics.heightPixels / 6;
        if (displaymetrics.widthPixels <= 768){
            if (displaymetrics.heightPixels <= 1280){
                if (isMulti){
                    return UtilsSize.getValueInDP(activity.getBaseContext(), 90);
                }else{
                    return UtilsSize.getValueInDP(activity.getBaseContext(), 250);
                }
            }else{
                if (isMulti){
                    return UtilsSize.getValueInDP(activity.getBaseContext(), 90);
                }else{
                    return deviceheight;
                }
            }
        } else if (displaymetrics.widthPixels <= 1080){
            if (displaymetrics.heightPixels <= 1980){
                if (isMulti){
                    return UtilsSize.getValueInDP(activity.getBaseContext(), 92);
                }else{
                    return deviceheight - deviceheight / 2;
                }
            }else if (displaymetrics.heightPixels <= 2200){
                if (isMulti){
                    return UtilsSize.getValueInDP(activity.getBaseContext(), 100);
                }else{
                    return deviceheight - deviceheight / 3;
                }
            } else{
                if (isMulti){
                    return UtilsSize.getValueInDP(activity.getBaseContext(), 110);
                }else{
                    return deviceheight - deviceheight / 2;
                }
            }

        }else if (displaymetrics.widthPixels <= 1440) {
            if (displaymetrics.heightPixels <= 2580){
                if (isMulti) {
//                    return deviceheight / 2 + deviceheight / 3;
                    return UtilsSize.getValueInDP(activity.getBaseContext(), 90);
                } else {
                    return UtilsSize.getValueInDP(activity.getBaseContext(), 105);
                }
            }else {
                if (isMulti) {
                    return UtilsSize.getValueInDP(activity.getBaseContext(), 100);
                } else {
                    return UtilsSize.getValueInDP(activity.getBaseContext(), 110);
                }
            }

        }else{
            if (isMulti){
                return deviceheight / 2 + deviceheight / 3 - 10;
            }else{
                return deviceheight - deviceheight / 2;
            }

        }
    }

    public static int getQRLogoWidth(Activity activity){
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int devicewidth = displaymetrics.widthPixels / 3;
        int fact = 500 - devicewidth;
        if (displaymetrics.widthPixels <= 768){
            if (displaymetrics.heightPixels <= 1280){
                return UtilsSize.getValueInDP(activity.getBaseContext(), 100);
            }else{
                return UtilsSize.getValueInDP(activity.getBaseContext(), 120);
            }
        } else if (displaymetrics.widthPixels <= 1080){
            if (displaymetrics.heightPixels <= 1980){
                return UtilsSize.getValueInDP(activity.getBaseContext(), 90);
            }else{
                return UtilsSize.getValueInDP(activity.getBaseContext(), 200);
            }

        }else if (displaymetrics.widthPixels < 1440){
            return UtilsSize.getValueInDP(activity.getBaseContext(), 250);
        }else{
            return UtilsSize.getValueInDP(activity.getBaseContext(), 270);
        }
    }

    public static int getImageWidth(int size){
        int w = size / 3;
        if (size <= 1080){
            return w / 2 + w / 3;
        }else if (size < 1440){
            return w / 2 + w / 3;
        }else{
            return w / 2 + w / 3 - 10;
        }
    }

    public static int getLogoutMarginTop(Activity activity, boolean isMulti){
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int devicewidth = displaymetrics.widthPixels / 3;
        if (displaymetrics.widthPixels <= 768){
            if (displaymetrics.heightPixels <= 1280){
                return UtilsSize.getValueInDP(activity.getBaseContext(), 0);
            }else{
                return UtilsSize.getValueInDP(activity.getBaseContext(), 0);
            }
        } else if (displaymetrics.widthPixels <= 1080){
            if (displaymetrics.heightPixels <= 1980){
                return UtilsSize.getValueInDP(activity.getBaseContext(), 0);
            }else{
                return UtilsSize.getValueInDP(activity.getBaseContext(), 100);
            }

        }else if (displaymetrics.widthPixels <= 1440){
            if (displaymetrics.heightPixels <= 2580) {
                return UtilsSize.getValueInDP(activity.getBaseContext(), 100);
            }else{
                return UtilsSize.getValueInDP(activity.getBaseContext(), 110);
            }
        }else{
            return UtilsSize.getValueInDP(activity.getBaseContext(), 110);
        }
    }

    public static int getMargin(Context context,View view, String margin){
        int m;
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) view.getLayoutParams();
        switch (margin){
            case "T":
                m = lp.topMargin;
                break;
            case "R":
                m = lp.rightMargin;
                break;
            case "B":
                m = lp.bottomMargin;
                break;
            case "L":
                m = lp.leftMargin;
                break;
            default:
                m = lp.topMargin + lp.rightMargin + lp.bottomMargin + lp.leftMargin;
                break;
        }

        return m;
    }

    public static void setMargin(View view, String margin, int t, int r, int b, int l){
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) view.getLayoutParams();
        switch (margin){
            case "T":
                lp.topMargin = t;
                break;
            case "R":
                lp.rightMargin = r;
                break;
            case "B":
                lp.bottomMargin = b;
                break;
            case "L":
                lp.leftMargin = l;
                break;
            default:
                lp.setMargins(l,t,r,b);
                break;
        }

    }

    public static int transferInputAmtWidth(Activity activity, View view, int size){
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int deviceheight = displaymetrics.heightPixels / 3;
        if (displaymetrics.widthPixels <= 768){
            if (displaymetrics.heightPixels <= 1280){
                return UtilsSize.getValueInDP(activity.getBaseContext(), 80);
            }else{
                return UtilsSize.getValueInDP(activity.getBaseContext(), 80);
            }
        } else if (displaymetrics.widthPixels <= 1080){
            if (displaymetrics.heightPixels <= 1980){
                return UtilsSize.getValueInDP(activity.getBaseContext(), 80);
            }else{
                setMargin(view, "A", size, 0, size, 0);
                return UtilsSize.getValueInDP(activity.getBaseContext(), 90);
            }

        }else if (displaymetrics.widthPixels <= 1440){
            if (displaymetrics.heightPixels <= 2580) {
                return UtilsSize.getValueInDP(activity.getBaseContext(), 80);
            }else{
                return UtilsSize.getValueInDP(activity.getBaseContext(), 90);
            }
        }else{
            return UtilsSize.getValueInDP(activity.getBaseContext(), 110);
        }
    }

    public static int transferInputAmtHeight(Activity activity, View view, int size){
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int deviceheight = displaymetrics.heightPixels / 3;
        if (displaymetrics.widthPixels <= 768){
            if (displaymetrics.heightPixels <= 1280){
                return UtilsSize.getValueInDP(activity.getBaseContext(), 60);
            }else{
                return UtilsSize.getValueInDP(activity.getBaseContext(), 60);
            }
        } else if (displaymetrics.widthPixels <= 1080){
            if (displaymetrics.heightPixels <= 1980){
                return UtilsSize.getValueInDP(activity.getBaseContext(), 60);
            }else{
                setMargin(view, "A", size, 0, size, 0);
                return UtilsSize.getValueInDP(activity.getBaseContext(), 70);
            }

        }else if (displaymetrics.widthPixels <= 1440){
            if (displaymetrics.heightPixels <= 2580) {
                return UtilsSize.getValueInDP(activity.getBaseContext(), 60);
            }else{
                return UtilsSize.getValueInDP(activity.getBaseContext(), 70);
            }
        }else{
            return UtilsSize.getValueInDP(activity.getBaseContext(), 70);
        }
    }

    public static int getPadding(Context context,View view, String margin){
        int m;
        //LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) view.getLayoutParams();
        switch (margin){
            case "T":
                m = view.getPaddingTop();
                break;
            case "R":
                m = view.getPaddingRight();
                break;
            case "B":
                m = view.getPaddingBottom();
                break;
            case "L":
                m = view.getPaddingLeft();
                break;
            default:
                m = view.getPaddingTop() + view.getPaddingRight() + view.getPaddingBottom() + view.getPaddingLeft();
                break;
        }

        return m;
    }

    public static int getViewWidth(Context context,View view){
        int w;
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) view.getLayoutParams();
        w = lp.height;
        return w;
    }

}
