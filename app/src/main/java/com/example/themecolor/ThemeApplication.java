package com.example.themecolor;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import androidx.annotation.NonNull;

import com.example.themecolor.PreferenceDelegator.PreferenceDelegator;
import com.example.themecolor.conf.Conf;

public class ThemeApplication extends Application {

    PreferenceDelegator preferenceDelegator;

    @Override
    public void onCreate() {
        super.onCreate();
        preferenceDelegator = PreferenceDelegator.getInstance(this);
        if(preferenceDelegator.contains(Conf.SET_THEME)){
            setTheme(preferenceDelegator.getInt(Conf.SET_THEME));
        }else {
            setTheme(R.style.color_FFD83E);
        }
    }

}
