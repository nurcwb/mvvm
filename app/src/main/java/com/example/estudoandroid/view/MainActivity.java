package com.example.estudoandroid.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.estudoandroid.R;
import com.example.estudoandroid.adapter.IShowProfessionDetails;
import com.example.estudoandroid.adapter.ProfessionAdapter;
import com.example.estudoandroid.databinding.ActivityMainBinding;
import com.example.estudoandroid.utils.Constans;
import com.example.estudoandroid.viewmodel.MainActivityViewModel;
import com.example.estudoandroid.vo.ProfessionVo;

import java.util.List;

public class MainActivity extends BaseActivity implements IShowProfessionDetails {
    private ActivityMainBinding binding;
    private ProfessionAdapter professionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final MainActivityViewModel viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel.error.observe(this, aBoolean -> {
            hideLoading();
            if (aBoolean) {
                viewModel.getList();
            }
        });

        viewModel.listMutableLiveData.observe(this, professionVos -> setAdapter(professionVos));

        showLoading();
        viewModel.requestList();
    }

    private void setAdapter(List<ProfessionVo> professionVos) {
        professionAdapter = new ProfessionAdapter(professionVos, this);
        binding.rv.setLayoutManager(new LinearLayoutManager(this));
        binding.rv.setAdapter(professionAdapter);
    }

    @Override
    public void click(int id) {
        Intent intent = new Intent(this, ProfessionDetailsActivity.class).putExtra(Constans.ID_PROFESSION, id);
        startActivity(intent);
    }
}