package com.example.moodtracker;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
import java.util.List;

class HistoryAdapter extends RecyclerView.Adapter {

    List<SaveMood> saveMoodList;

    public HistoryAdapter(List<SaveMood> saveMoodList) {
        this.saveMoodList = saveMoodList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
