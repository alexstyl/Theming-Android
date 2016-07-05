package com.alexstyl.themingandroid;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.util.TypedValue;

/**
 * Helper class that provides easy access to the colors of the passing Context's theme
 */
public final class AttributeExtractor {

    private static final int[] PRIMARY_DARK = new int[]{R.attr.colorPrimaryDark};
    private static final int[] PRIMARY = new int[]{R.attr.colorPrimary};
    private static final int[] ACCENT = new int[]{R.attr.colorAccent};

    /**
     * Extracts the colorPrimary color attribute of the passing Context's theme
     */
    @ColorInt
    public int extractPrimaryColorFrom(Context context) {
        return extractIntAttribute(context, PRIMARY);
    }

    /**
     * Extracts the colorPrimaryDark color attribute of the passing Context's theme
     */
    @ColorInt
    public int extractPrimaryDarkColorFrom(Context context) {
        return extractIntAttribute(context, PRIMARY_DARK);
    }

    /**
     * Extracts the colorAccent color attribute of the passing Context's theme
     */
    @ColorInt
    public int extractAccentColorFrom(Context context) {
        return extractIntAttribute(context, ACCENT);
    }

    /**
     * Extracts the drawable of the passing Context's theme
     */
    @ColorInt
    private int extractIntAttribute(Context context, int[] attribute) {
        TypedValue typedValue = new TypedValue();
        TypedArray a = context.obtainStyledAttributes(typedValue.data, attribute);
        int color = a.getColor(0, 0);
        a.recycle();
        return color;
    }

    public Drawable extractDrawable(Context context, @AttrRes int drawableAttributeId) {
        TypedValue typedValue = new TypedValue();
        TypedArray a = context.obtainStyledAttributes(typedValue.data, new int[]{drawableAttributeId});
        Drawable drawable = a.getDrawable(0);
        a.recycle();
        return drawable;
    }
}
