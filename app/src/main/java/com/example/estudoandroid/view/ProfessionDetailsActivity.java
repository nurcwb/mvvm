package com.example.estudoandroid.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;

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
    private Float alpha = 1.0f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profession_details);
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ProfessionDetailsViewModel.class);

        binding.btn.setOnClickListener(  v -> {
            binding.scrollView.fullScroll(View.FOCUS_DOWN);
            alpha = 1f;
            binding.tv.setVisibility(View.VISIBLE);
        });


        binding.scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (binding.scrollView != null) {
                    View view = binding.scrollView.getChildAt(binding.scrollView.getChildCount()-1);
                    int diff = (view.getBottom()+binding.scrollView.getPaddingBottom()-(binding.scrollView.getHeight()+binding.scrollView.getScrollY()));

                    binding.tv.setAlpha(alpha);
                    alpha -= .03f;

                    if(alpha == 0f){
                        alpha = 1f;
                        binding.tv.setVisibility(View.GONE);
                    }

                    Log.d("scroll", "down");
                    // if diff is zero, then the bottom has been reached
                    if (diff == 0) {
                    Log.d("scroll", "up");

                        // do stuff
                    }
                }
            }
        });

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