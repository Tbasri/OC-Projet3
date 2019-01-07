package com.example.moodtracker;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Historique extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        Type listType = new TypeToken<ArrayList<SaveMood>>(){}.getType();
List<SaveMood> yourClassList = new Gson().fromJson(preferenceList, listType);
         */

        setContentView(R.layout.activity_historique);


    }
}
