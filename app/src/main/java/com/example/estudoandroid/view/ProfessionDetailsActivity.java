package com.example.estudoandroid.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.estudoandroid.R;
import com.example.estudoandroid.databinding.ActivityProfessionDetailsBinding;
import com.example.estudoandroid.utils.Constans;
import com.example.estudoandroid.viewmodel.ProfessionDetailsViewModel;

public class ProfessionDetailsActivity extends BaseActivity {
    private ActivityProfessionDetailsBinding binding;
    private int id;
    private ProfessionDetailsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profession_details);
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ProfessionDetailsViewModel.class);

        if (getIntent().hasExtra(Constans.ID_PROFESSION)) {
            id = getIntent().getIntExtra(Constans.ID_PROFESSION, -1);
        }

        viewModel.liveData.observe(this, data -> {
            hideLoading();
            binding.setData(data);
        });

        if (id != -1) {
            showLoading();
            viewModel.getDetails(id);
        }
    }
}