package com.jam.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.jam.demo.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    MyViewModel myViewModel;
    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myViewModel = new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(), this)).get(MyViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);
    }
}
