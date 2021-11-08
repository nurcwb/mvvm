package com.example.estudoandroid.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.estudoandroid.databinding.LayoutViewholderBinding;
import com.example.estudoandroid.vo.ProfessionVo;

import java.util.List;

public class ProfessionAdapter extends RecyclerView.Adapter<ProfessionViewHolder> {

    List<ProfessionVo> professions;
    private IShowProfessionDetails click;
    int lastChecked = -1;

    public ProfessionAdapter(List<ProfessionVo> professions, IShowProfessionDetails click) {
        this.professions = professions;

        this.click = click;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ProfessionViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        LayoutViewholderBinding binding = LayoutViewholderBinding.inflate(layoutInflater, parent, false);
        return new ProfessionViewHolder(binding, lastChecked, professions);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ProfessionViewHolder holder, int position) {
        holder.set(professions.get(position), position, click);
    }

    @Override
    public int getItemCount() {
        return professions.size();
    }

}
