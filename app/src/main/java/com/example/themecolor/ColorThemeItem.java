package com.example.themecolor;

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
    public ColorThemeItem(int id, int color, int theme, boolean isSelected) {
        this.id         = id;
        this.color      = color;
        this.theme      = theme;
        this.isSelected = isSelected;
        this.colorName  =   colorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setTheme(int theme) {
        this.theme = theme;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
