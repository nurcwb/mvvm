package com.example.estudoandroid.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.estudoandroid.R;
import com.example.estudoandroid.databinding.ActivityNewBinding;
import com.example.estudoandroid.utils.Constans;

public class NewActivity extends AppCompatActivity {

    private ActivityNewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_new);

        binding.btnVoltar.setEnabled(false);

        binding.etMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.btnVoltar.setEnabled(s.length() > 0 ? true : false);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        binding.btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra(Constans.NEW_ACTIVITY_INFO, binding.etMessage.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        });

    }
}