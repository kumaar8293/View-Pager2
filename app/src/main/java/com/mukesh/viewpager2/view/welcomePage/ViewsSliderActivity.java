package com.mukesh.viewpager2.view.welcomePage;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.viewpager2.widget.ViewPager2;

import com.mukesh.viewpager2.R;
import com.mukesh.viewpager2.databinding.ActivityViewsSliderBinding;
import com.mukesh.viewpager2.utils.Utils;

import java.util.Objects;

public class ViewsSliderActivity extends AppCompatActivity {

    private ActivityViewsSliderBinding binding;
    private int[] layouts;
    public static String CLICKED_POSITION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewsSliderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
        setAnimation();
    }

    private void setAnimation() {

        Intent intent = getIntent();
        int position = intent.getIntExtra(CLICKED_POSITION, 0);
        if (position == 1) {
            binding.viewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        } else {
            binding.viewPager.setPageTransformer(Utils.getTransformer(position));

        }

    }

    private void initView() {
        // layouts of all welcome sliders
        // add few more layouts if you want
        layouts = new int[]{
                R.layout.slide_one,
                R.layout.slide_two,
                R.layout.slide_three,
                R.layout.slide_four};

        ViewSliderAdapter mAdapter = new ViewSliderAdapter(layouts);
        binding.viewPager.setAdapter(mAdapter);
        binding.viewPager.registerOnPageChangeCallback(pageChangeCallback);

        binding.btnSkip.setOnClickListener(v -> launchHomeScreen());

        binding.btnNext.setOnClickListener(v -> {

            // checking for last page
            // if last page home screen will be launched
            int current = getItem(+1);
            if (current < layouts.length) {
                // move to next screen
                binding.viewPager.setCurrentItem(current);
            } else {
                launchHomeScreen();
            }
        });
        // adding bottom dots
        addBottomDots(0);

    }

    /*
     * Adds bottom dots indicator
     * */
    private void addBottomDots(int currentPage) {
        TextView[] dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        binding.layoutDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            binding.layoutDots.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[currentPage].setTextColor(colorsActive[currentPage]);
            // binding.layoutDots.addView(dots[currentPage]);
        }


    }

    private int getItem(int i) {
        return binding.viewPager.getCurrentItem() + i;
    }

    private void launchHomeScreen() {
        Toast.makeText(this, "Call Home Page", Toast.LENGTH_LONG).show();
        finish();
    }


    /*
     * ViewPager page change listener
     */
    ViewPager2.OnPageChangeCallback pageChangeCallback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
                binding.btnNext.setText(getString(R.string.start));
                binding.btnSkip.setVisibility(View.GONE);
            } else {
                // still pages are left
                binding.btnNext.setText(getString(R.string.next));
                binding.btnSkip.setVisibility(View.VISIBLE);
            }
        }
    };

}
