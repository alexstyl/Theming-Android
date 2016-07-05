package com.alexstyl.themingandroid.advanced;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.alexstyl.themingandroid.AppCompatThemedActivity;
import com.alexstyl.themingandroid.AppTheme;
import com.alexstyl.themingandroid.AttributeExtractor;
import com.alexstyl.themingandroid.R;
import com.alexstyl.themingandroid.simple.OnThemeSelectedListener;
import com.alexstyl.themingandroid.simple.ThemePickerAdapter;

public class AdvancedExampleActivity extends AppCompatThemedActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AttributeExtractor extractor = new AttributeExtractor();
        Drawable upDrawable = extractor.extractDrawable(this, R.attr.actionUp);
        toolbar.setNavigationIcon(upDrawable);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new SimpleCardAdapter());

        RecyclerView themesList = (RecyclerView) findViewById(R.id.themes_list);
        themesList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        themesList.setAdapter(new ThemePickerAdapter(extractor, onThemeSelectedListener));

        setTitle(R.string.Advanced_Example);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = getParentActivityIntent();
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private final OnThemeSelectedListener onThemeSelectedListener = new OnThemeSelectedListener() {
        @Override
        public void onThemeSelected(AppTheme theme) {
            applyTheme(theme);
        }
    };
}
