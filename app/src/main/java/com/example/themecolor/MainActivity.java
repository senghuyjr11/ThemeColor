package com.example.themecolor;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themecolor.PreferenceDelegator.PreferenceDelegator;
import com.example.themecolor.adapter.ColorThemeAdapter;
import com.example.themecolor.conf.Conf;
import com.example.themecolor.databinding.ActivityMainBinding;
import com.example.themecolor.item.ColorThemeItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    RecyclerView recyclerColorTheme;
    List<ColorThemeItem> colorThemeItemList;
    ColorThemeAdapter colorThemeAdapter;
    public static boolean is_setting_change = false;
    public static boolean is_lang_change = false;
    public static boolean is_main_recreate = false;
    public static boolean is_home_clickable = false;
    PreferenceDelegator preferenceDelegator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        preferenceDelegator = PreferenceDelegator.getInstance(this);
        if(preferenceDelegator.contains(Conf.SET_THEME)){
            setTheme(preferenceDelegator.getInt(Conf.SET_THEME));
        }else {
            setTheme(R.style.color_FFD83E);
        }
        super.onCreate(savedInstanceState);
        overridePendingTransition(0, R.anim.fade_out_fast);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initView();
        initColor();
    }

    private void initView() {
        recyclerColorTheme = binding.recyclerColorTheme;
    }

    private void initColor(){
        colorThemeItemList = new ArrayList<>();
        colorThemeItemList.add(new ColorThemeItem(1,R.color.color_FFD83E, R.style.color_FFD83E,false, getString(R.string.color_theme_1)));
        colorThemeItemList.add(new ColorThemeItem(1,R.color.color_D8D4FF, R.style.color_D8D4FF,false, getString(R.string.color_theme_2)));
        colorThemeItemList.add(new ColorThemeItem(1,R.color.color_FF9B8B, R.style.color_FF9B8B,false, getString(R.string.color_theme_3)));
        colorThemeItemList.add(new ColorThemeItem(1,R.color.color_BED9C7, R.style.color_BED9C7,false, getString(R.string.color_theme_4)));
        colorThemeItemList.add(new ColorThemeItem(1,R.color.color_AFDBE7, R.style.color_AFDBE7,false, getString(R.string.color_theme_5)));
        colorThemeAdapter = new ColorThemeAdapter();
        colorThemeAdapter.setThemeItemList(colorThemeItemList);

        // set recyclerview to be horizontal
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerColorTheme.setLayoutManager(manager);
        recyclerColorTheme.setAdapter(colorThemeAdapter);
    }
}