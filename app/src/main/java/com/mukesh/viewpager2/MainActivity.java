package com.mukesh.viewpager2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.mukesh.viewpager2.activity.ViewsSliderActivity;
import com.mukesh.viewpager2.databinding.ActivityMainBinding;
import com.mukesh.viewpager2.fragments.FragmentViewPagerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnViewsDemo.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ViewsSliderActivity.class)));

        binding.btnFragmentDemo.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, FragmentViewPagerActivity.class)));
    }
}
