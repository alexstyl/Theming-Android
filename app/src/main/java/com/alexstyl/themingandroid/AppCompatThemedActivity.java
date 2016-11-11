package com.alexstyl.themingandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Subclass of {@link AppCompatActivity} that allows you to apply a custom theme to it.
 */
public class AppCompatThemedActivity extends AppCompatActivity {

    private ThemePreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = new ThemePreferences(this);
        applyPreviouslySelectedTheme();
    }

    private void applyPreviouslySelectedTheme() {
        AppTheme theme = preferences.getSelectedTheme();
        setTheme(theme.resId());
    }

    /**
     * Persists the passing theme and restarts the activity transitioning to the new theme
     *
     * @param theme The theme to be applied
     */
    protected final void applyTheme(AppTheme theme) {
        preferences.persistSelectedTheme(theme);
        restartActivity();
        int enterAnimation = android.R.anim.fade_in;
        int exitAnimation = android.R.anim.fade_out;
        overridePendingTransition(enterAnimation, exitAnimation);
    }

    private void restartActivity() {
        final Intent intent = getIntent();
        intent.removeCategory(Intent.CATEGORY_LAUNCHER);
        finish();
        startActivity(intent);
    }

}
