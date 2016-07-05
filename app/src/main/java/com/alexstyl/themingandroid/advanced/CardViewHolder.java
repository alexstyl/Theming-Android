package com.alexstyl.themingandroid.advanced;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alexstyl.themingandroid.R;

public class CardViewHolder extends RecyclerView.ViewHolder {

    public static CardViewHolder createForGroup(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_card_item, parent, false);
        return new CardViewHolder(view);
    }

    public CardViewHolder(View itemView) {
        super(itemView);
    }
}
