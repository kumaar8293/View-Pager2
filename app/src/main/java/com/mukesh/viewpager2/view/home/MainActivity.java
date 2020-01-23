package com.mukesh.viewpager2.view.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mukesh.viewpager2.R;
import com.mukesh.viewpager2.databinding.ActivityMainBinding;
import com.mukesh.viewpager2.view.fragments.FragmentViewPagerActivity;
import com.mukesh.viewpager2.view.welcomePage.ViewsSliderActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeAdapter.CustomItemClickListener {

    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        prepareData();
    }

    private void prepareData() {
        List<String> buttonName = new ArrayList<>();
        buttonName.add("Fragment View (TabLayout)");
        buttonName.add(getString(R.string.change_orientation));
        buttonName.add(getString(R.string.anti_clock_spin));
        buttonName.add(getString(R.string.clock_spin));
        buttonName.add(getString(R.string.cube_in_depth));
        buttonName.add(getString(R.string.cube_in_rotate));
        buttonName.add(getString(R.string.cube_in_scaling));
        buttonName.add(getString(R.string.cube_out_depth));
        buttonName.add(getString(R.string.cube_out_rotate));
        buttonName.add(getString(R.string.depth_page));
        buttonName.add(getString(R.string.depth));
        buttonName.add(getString(R.string.fade_out));
        buttonName.add(getString(R.string.fan));
        buttonName.add(getString(R.string.fidget_spin));
        buttonName.add(getString(R.string.gate));
        buttonName.add(getString(R.string.hinge));
        buttonName.add(getString(R.string.horizontal_flip));
        buttonName.add(getString(R.string.pop));
        buttonName.add(getString(R.string.simple_transformation));
        buttonName.add(getString(R.string.spinner_transformation));
        buttonName.add(getString(R.string.toss_transformation));
        buttonName.add(getString(R.string.vertical_flip));
        buttonName.add(getString(R.string.vertical_shut));
        buttonName.add(getString(R.string.zoom_out));

        HomeAdapter adapter = new HomeAdapter(buttonName, this);
//        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int posiiton) {

        if (posiiton == 0) {
            startActivity(new Intent(MainActivity.this, FragmentViewPagerActivity.class));

        } else {

            Intent intent = new Intent(MainActivity.this, ViewsSliderActivity.class);
            intent.putExtra(ViewsSliderActivity.CLICKED_POSITION, posiiton);
            startActivity(intent);
        }
    }
}
