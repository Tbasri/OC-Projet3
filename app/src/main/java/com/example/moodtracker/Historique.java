package com.example.moodtracker;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Historique extends AppCompatActivity {

    private String preferenceList;

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Type listType = new TypeToken<ArrayList<SaveMood>>(){}.getType();
        List<SaveMood> yourClassList = new Gson().fromJson(preferenceList, listType);


        setContentView(R.layout.activity_historique);


    }
*/


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);
        mRecyclerView = (RecyclerView) findViewById(R.id.ViewDayMood);

        mRecyclerView.setHasFixedSize(true);


        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        mAdapter = new HistoryAdapter(new ArrayList<SaveMood>()); // recupérer list de save mood deserealiser
        mRecyclerView.setAdapter(mAdapter);
    }
}
