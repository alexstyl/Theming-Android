package com.alexstyl.themingandroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Class that persists and loads theme related Preferences
 */
public class ThemePreferences {

    private static final String KEY_SELECTED_THEME = "KEY_SELECTED_THEME";
    private static final String DEFAULT_THEME = AppTheme.DARK.themeName();

    private final SharedPreferences preferences;

    public ThemePreferences(Context context) {
        this.preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public AppTheme getSelectedTheme() {
        String themeName = preferences.getString(KEY_SELECTED_THEME, DEFAULT_THEME);
        return AppTheme.withName(themeName);
    }

    public void persistSelectedTheme(AppTheme appTheme) {
        preferences
                .edit()
                .putString(KEY_SELECTED_THEME, appTheme.themeName())
                .apply();
    }
}
