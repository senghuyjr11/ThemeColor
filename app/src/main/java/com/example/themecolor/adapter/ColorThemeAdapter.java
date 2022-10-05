package com.example.themecolor.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themecolor.MainActivity;
import com.example.themecolor.PreferenceDelegator.PreferenceDelegator;
import com.example.themecolor.conf.Conf;
import com.example.themecolor.databinding.ItemColorThemeBinding;
import com.example.themecolor.item.ColorThemeItem;
import com.example.themecolor.utils.UtilsGson;
import com.example.themecolor.utils.UtilsSize;

import java.util.List;

public class ColorThemeAdapter extends RecyclerView.Adapter<ColorThemeAdapter.MyColorThemeViewHolder> {

    private List<ColorThemeItem> themeItemList;
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
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return new MyColorThemeViewHolder(ItemColorThemeBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyColorThemeViewHolder holder, int position) {
        int absPosition = holder.getAdapterPosition();
        holder.setBinding(themeItemList.get(position));
        final ColorThemeItem colorThemeItem = themeItemList.get(absPosition);

        try {
            if (colorThemeItem.getColor() == Conf.appColor){
                pos = absPosition;
                is_theme_click = false;
                holder.binding.tvColorNameItem.setTextColor(Color.BLACK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.binding.colorTheme.setOnClickListener(view -> {
            is_theme_click = pos == absPosition;
            if (!is_theme_click) {
                PreferenceDelegator.getInstance(mContext).put("SET_THEME", colorThemeItem.getTheme());
                PreferenceDelegator.getInstance(mContext).put("SET_THEME_OBJ", UtilsGson.objectToGson(colorThemeItem));
                recreateActivitySmoothly();
            }
        });
    }

    private void createShape(LinearLayout view, int color){
        GradientDrawable shape = new GradientDrawable() ;
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadius(30);
        shape.setColor(ContextCompat.getColor(mContext,color));
        view.setBackground(shape);
    }

    private void recreateActivitySmoothly() {
        Intent intentSetting = new Intent(mContext, MainActivity.class);
        mContext.startActivity(intentSetting);
        if (mContext instanceof Activity) ((Activity)mContext).finish();
    }

    @Override
    public int getItemCount() {
        return themeItemList.size();
    }

    public class MyColorThemeViewHolder extends RecyclerView.ViewHolder{

        private final ItemColorThemeBinding binding;

        public MyColorThemeViewHolder(@NonNull ItemColorThemeBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void setBinding(ColorThemeItem item){
            if(item == null) return;
            binding.colorTheme.getLayoutParams().width = UtilsSize.getThemeColorWidth((Activity) binding.getRoot().getContext());
            binding.colorTheme.getLayoutParams().height = UtilsSize.getThemeColorHeight((Activity) binding.getRoot().getContext(), false);
            binding.tvColorNameItem.setText(item.getColorName());
            createShape(binding.colorTheme, item.getColor());
        }
    }

}
