package com.example.estudoandroid.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public abstract class ViewHolderDefault extends RecyclerView.ViewHolder {
    public ViewHolderDefault(@NonNull @NotNull View itemView) {
        super(itemView);
    }

}
