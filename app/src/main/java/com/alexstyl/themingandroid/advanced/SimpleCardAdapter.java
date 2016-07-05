package com.alexstyl.themingandroid.advanced;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public class SimpleCardAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private static final int NUMBER_OF_CARDS = 10;

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CardViewHolder.createForGroup(parent);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        // we are not doing any special binding. everything exists in the viewholder
    }

    @Override
    public int getItemCount() {
        return NUMBER_OF_CARDS;
    }
}
