package com.example.themecolor.conf;

import static com.example.themecolor.conf.Conf.SuperActivity.KEY_THEME;

import android.content.Context;

import com.example.themecolor.PreferenceDelegator.PreferenceDelegator;
import com.example.themecolor.item.ColorThemeItem;
import com.google.gson.Gson;

public class Conf {
    public static int appColor;
    public static String SET_THEME = "SET_THEME";
    public static String SET_THEME_OBJ = "SET_THEME_OBJ";

    public static class SuperActivity{
        static String KEY_THEME     = "SET_THEME";
        static String KEY_THEME_OBJ = "SET_THEME_OBJ";
    }

    public static void onCheckTheme(Context context) {
        PreferenceDelegator preferenceDelegator = PreferenceDelegator.getInstance(context);
        if(PreferenceDelegator.getInstance(context).contains(KEY_THEME)){
            if(preferenceDelegator.contains(SuperActivity.KEY_THEME_OBJ)){
                Gson gson = new Gson();
                String json = preferenceDelegator.get(SuperActivity.KEY_THEME_OBJ);
                ColorThemeItem itemWeAlertColor = gson.fromJson(json, ColorThemeItem.class);
                appColor = itemWeAlertColor.getColor();
            }
        }
    }
}
