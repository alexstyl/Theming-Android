package com.alexstyl.themingandroid.simple;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.alexstyl.themingandroid.AppTheme;
import com.alexstyl.themingandroid.AttributeExtractor;
import com.alexstyl.themingandroid.OnThemeSelectedListener;
import com.alexstyl.themingandroid.advanced.ThemeOptionViewHolder;

public class ThemePickerAdapter extends RecyclerView.Adapter<ThemeOptionViewHolder> {

    private final AppTheme[] themes = AppTheme.values();
    private final AttributeExtractor extractor;
    private final OnThemeSelectedListener onThemeSelectedListener;

    public ThemePickerAdapter(AttributeExtractor extractor, OnThemeSelectedListener onThemeSelectedListener) {
        this.extractor = extractor;
        this.onThemeSelectedListener = onThemeSelectedListener;
    }

    @Override
    public ThemeOptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ThemeOptionViewHolder.createFor(parent, extractor);
    }

    @Override
    public void onBindViewHolder(ThemeOptionViewHolder holder, int position) {
        AppTheme appTheme = themes[position];
        holder.bind(appTheme, onThemeSelectedListener);
    }

    @Override
    public int getItemCount() {
        return themes.length;
    }
}
