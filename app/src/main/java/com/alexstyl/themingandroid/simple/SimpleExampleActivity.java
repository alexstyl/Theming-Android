package com.alexstyl.themingandroid.simple;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.alexstyl.themingandroid.AppCompatThemedActivity;
import com.alexstyl.themingandroid.AppTheme;
import com.alexstyl.themingandroid.AttributeExtractor;
import com.alexstyl.themingandroid.R;
import com.alexstyl.themingandroid.advanced.AdvancedExampleActivity;

/**
 * A simple example of how to style your activity
 */
public class SimpleExampleActivity extends AppCompatThemedActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView themesList = (RecyclerView) findViewById(R.id.themes_list);
        setupThemesList(themesList);

        findViewById(R.id.simple_example_next).setOnClickListener(onNextExampleClickListener);

        setTitle(R.string.simple_example);
    }

    private void setupThemesList(RecyclerView themesList) {
        themesList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        AttributeExtractor extractor = new AttributeExtractor();
        ThemePickerAdapter adapter = new ThemePickerAdapter(extractor, onThemeSelectedListener);
        themesList.setAdapter(adapter);
    }

    private final OnThemeSelectedListener onThemeSelectedListener = new OnThemeSelectedListener() {
        @Override
        public void onThemeSelected(AppTheme theme) {
            applyTheme(theme);
        }
    };

    private final View.OnClickListener onNextExampleClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startAdvancedExample(v.getContext());
        }

        private void startAdvancedExample(Context context) {
            Intent intent = new Intent(context, AdvancedExampleActivity.class);
            startActivity(intent);
        }
    };

}
