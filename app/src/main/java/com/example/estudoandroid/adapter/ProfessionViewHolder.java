package com.example.estudoandroid.adapter;

import com.example.estudoandroid.databinding.LayoutViewholderBinding;
import com.example.estudoandroid.vo.ProfessionVo;

import java.util.List;

public class ProfessionViewHolder extends ViewHolderDefault {
    private LayoutViewholderBinding binding;
    private int lastChecked;
    private List<ProfessionVo> professions;
    private int position;


    public ProfessionViewHolder(LayoutViewholderBinding binding, int lastChecked, List<ProfessionVo> professions) {
        super(binding.getRoot());
        this.binding = binding;
        this.lastChecked = lastChecked;
        this.professions = professions;
    }

    public void set(final ProfessionVo profession, int positionP, final IShowProfessionDetails click) {
        position = positionP;
        binding.setProfession(profession);
        binding.cardView.setOnClickListener(v -> click.click(profession.getId()));
    }
}
