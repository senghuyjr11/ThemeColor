package com.example.themecolor.item;

public class ColorThemeItem {
    private int id;
    private int color;
    private int theme;
    private String colorName;
    private boolean isSelected;

    public ColorThemeItem(int id, int color, int theme, boolean isSelected, String colorName) {
        this.id         = id;
        this.color      = color;
        this.theme      = theme;
        this.isSelected = isSelected;
        this.colorName  =   colorName;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getTheme() {
        return theme;
    }

    public String getColorName() {
        return colorName;
    }

}
