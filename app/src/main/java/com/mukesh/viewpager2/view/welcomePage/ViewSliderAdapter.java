package com.mukesh.viewpager2.view.welcomePage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewSliderAdapter extends RecyclerView.Adapter<ViewSliderAdapter.SliderViewHolder> {

    private int[] layouts;

    ViewSliderAdapter(int[] layouts) {
        this.layouts = layouts;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {


    }

    @Override
    public int getItemViewType(int position) {
        return layouts[position];
    }

    @Override
    public int getItemCount() {
        return layouts.length;
    }

    class SliderViewHolder extends RecyclerView.ViewHolder {


        SliderViewHolder(@NonNull View itemView) {
            super(itemView);


        }
    }
}
