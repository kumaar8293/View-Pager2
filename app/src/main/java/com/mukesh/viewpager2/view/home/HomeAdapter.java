package com.mukesh.viewpager2.view.home;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mukesh.viewpager2.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHoder> {
    private List<String> name;
    private CustomItemClickListener itemClickListener;
    private static final String TAG = "HomeAdapter";

    HomeAdapter(List<String> name, CustomItemClickListener itemClickListener) {
        this.name = name;
        this.itemClickListener = itemClickListener;
        Log.d(TAG, "HomeAdapter: size " + name.size());
    }

    @NonNull
    @Override
    public HomeViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.d(TAG, "onCreateViewHolder: ");
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_single_row, parent, false);

        return new HomeViewHoder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHoder holder, int position) {

        Log.d(TAG, "onBindViewHolder: " + position);
        holder.button.setText(name.get(position)+" "+position);
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    class HomeViewHoder extends RecyclerView.ViewHolder {

        Button button;

        HomeViewHoder(@NonNull View itemView) {
            super(itemView);

            Log.d(TAG, "HomeViewHoder: ");
            button = itemView.findViewById(R.id.button);
            button.setOnClickListener(view -> {
                if (itemClickListener != null && getAdapterPosition() != RecyclerView.NO_POSITION) {

                    itemClickListener.onItemClick(getAdapterPosition());
                }
            });
        }
    }

    interface CustomItemClickListener {
        void onItemClick(int posiiton);
    }
}
