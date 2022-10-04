package com.example.themecolor.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themecolor.item.ColorThemeItem;
import com.example.themecolor.MainActivity;
import com.example.themecolor.PreferenceDelegator.PreferenceDelegator;
import com.example.themecolor.R;
import com.example.themecolor.conf.Conf;
import com.example.themecolor.utils.UtilsGson;
import com.example.themecolor.utils.UtilsSize;

import java.util.List;

public class ColorThemeAdapter extends RecyclerView.Adapter<ColorThemeAdapter.MyColorThemeViewHolder> {

    private List<ColorThemeItem> themeItemList;
    private int roundRadius;
    private static boolean is_theme_click = false;
    private int pos;
    private Context mContext;

    public void setThemeItemList(List<ColorThemeItem> themeItemList){
        this.themeItemList  = themeItemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyColorThemeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater     = LayoutInflater.from(parent.getContext());
        this.mContext = parent.getContext();
        View view                   = inflater.inflate(R.layout.item_color_theme, parent, false);
        return new MyColorThemeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyColorThemeViewHolder myColorThemeViewHolder, int position) {
        int absPosition = myColorThemeViewHolder.getAdapterPosition();
        myColorThemeViewHolder.colorTheme.getLayoutParams().width = UtilsSize.getThemeColorWidth((Activity) mContext, false);
        myColorThemeViewHolder.colorTheme.getLayoutParams().height = UtilsSize.getThemeColorHeight((Activity) mContext, false);
        final ColorThemeItem colorThemeItem   = themeItemList.get(absPosition);
        myColorThemeViewHolder.colorName.setText(colorThemeItem.getColorName());
        createShape(myColorThemeViewHolder.colorTheme, colorThemeItem.getColor());

        try {
            if (colorThemeItem.getColor() == Conf.appColor){
                pos = absPosition;
                is_theme_click = false;
                myColorThemeViewHolder.colorName.setTextColor(Color.BLACK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        myColorThemeViewHolder.colorTheme.setOnClickListener(view -> {
            is_theme_click = pos == absPosition;
            if (!is_theme_click) {
                MainActivity.is_main_recreate = true;
                MainActivity.is_home_clickable = true;
                PreferenceDelegator.getInstance(mContext).put("SET_THEME", colorThemeItem.getTheme());
                PreferenceDelegator.getInstance(mContext).put("SET_THEME_OBJ", UtilsGson.objectToGson(colorThemeItem));
                recreateActivitySmoothly();
            }
        });
    }

    private void createShape(LinearLayout view, int color){
        roundRadius = 30;
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadius(roundRadius);
        shape.setColor(ContextCompat.getColor(mContext,color));
        view.setBackground(shape);
    }

    private void recreateActivitySmoothly() {
        MainActivity.is_setting_change = true;
        MainActivity.is_lang_change = true;
        Intent intentSetting = new Intent(mContext, MainActivity.class);
        mContext.startActivity(intentSetting);
        MainActivity.is_home_clickable = true;
        if (mContext instanceof Activity) ((Activity)mContext).finish();
    }

    @Override
    public int getItemCount() {
        return themeItemList.size();
    }

    public class MyColorThemeViewHolder extends RecyclerView.ViewHolder{

        LinearLayout colorTheme;
        TextView colorName;

        public MyColorThemeViewHolder(@NonNull View itemView) {
            super(itemView);
            colorTheme           =   itemView.findViewById(R.id.color_theme);
            colorName            =   itemView.findViewById(R.id.tv_color_name_item);
        }
    }

}
