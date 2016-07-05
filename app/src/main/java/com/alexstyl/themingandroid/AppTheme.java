package com.alexstyl.themingandroid;

import android.support.annotation.StyleRes;

/**
 * Java representation of a Theme
 */
public enum AppTheme {
    DARK(R.style.Theme_Dark, "Dark"),
    RED(R.style.Theme_Red, "Red"),
    GREEN(R.style.Theme_Green, "Green"),
    BLUE(R.style.Theme_Blue, "Blue");

    @StyleRes
    private final int styleResId;
    private final String themeName;

    AppTheme(@StyleRes int styleResId, String themeName) {
        this.styleResId = styleResId;
        this.themeName = themeName;
    }

    @StyleRes
    public int resId() {
        return styleResId;
    }

    public String themeName() {
        return themeName;
    }

    public static AppTheme withName(String themeName) {
        for (AppTheme appTheme : values()) {
            if (appTheme.themeName().equals(themeName)) {
                return appTheme;
            }
        }
        throw new IllegalArgumentException("There is no theme called [" + themeName + "]");
    }
}
