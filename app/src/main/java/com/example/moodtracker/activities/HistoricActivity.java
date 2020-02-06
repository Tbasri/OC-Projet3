package com.example.moodtracker.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;


import com.example.moodtracker.R;
import com.example.moodtracker.models.SaveMood;
import com.example.moodtracker.utils.MoodPreferences;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

// Ecran qui affiche l'historique des humeurs

public class HistoricActivity extends AppCompatActivity {


    // Afficher couleur

    private int moodColor(int moodIndex) {

        int moodColor;

        switch (moodIndex) {

            case 0:
                moodColor = (R.color.ic_tres_mauvaise_humeur);
                break;

            case 1:
                moodColor = (R.color.ic_mauvaise_humeur);
                break;

            case 2:
                moodColor = (R.color.ic_humeur_normal);
                break;

            case 3:
                moodColor = (R.color.ic_launcher_background);
                break;

            case 4:
                moodColor = (R.color.ic_launcher_background);
                break;

            default:
                moodColor = (R.color.ic_humeur_normal);
                break;

        }
        return moodColor;
    }

    ImageView imageView1;
    ImageView commentaryOk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);


        // Le layout de l'activité est activityHistory(xml)
        setContentView(R.layout.activity_historique);

        // on recupère la vue dans dont l'identidiant et history ln qui correspond au xml history activité
        LinearLayout parentView = findViewById(R.id.historyLl);


        // on recupere l'historique et on le charge dans la variable savemoods (qui est une liste)
        List<SaveMood> saveMoods = MoodPreferences.getMoods();



        commentaryOk = findViewById(R.id.imageView_main_comment);
        imageView1 = findViewById(R.id.commentary1);



        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();

        // Récupérer la vue et afficher la bonne couleur rendre visible ou non le commentaire

        String todayComment = MoodPreferences.getMoodCommentForDate(today);
        int todayMoodIndex = MoodPreferences.getMoodFragmentIndexForDate(today);
        findViewById(R.id.mood_day1).setBackgroundResource(moodColor(todayMoodIndex));
        if (todayComment == null) {
            findViewById(R.id.commentary1).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.commentary1).setVisibility(View.VISIBLE);
        }

        cal.add(Calendar.DATE, -1);
        Date yesterday = cal.getTime();
        int yesterdayMoodIndex = MoodPreferences.getMoodFragmentIndexForDate(yesterday);
        findViewById(R.id.ViewDayMood2).setBackgroundResource(moodColor(yesterdayMoodIndex));
        if (todayComment == null) {
            findViewById(R.id.commentary2).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.commentary2).setVisibility(View.VISIBLE);
        }

        cal.add(Calendar.DATE, -2);
        Date dayMinus2 = cal.getTime();
        int dayMinus2MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus2);
        findViewById(R.id.ViewDayMood3).setBackgroundResource(moodColor(dayMinus2MoodIndex));
        if (todayComment == null) {
            findViewById(R.id.commentary3).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.commentary3).setVisibility(View.VISIBLE);
        }

        cal.add(Calendar.DATE, -3);
        Date dayMinus3 = cal.getTime();
        int dayMinus3MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus3);
        findViewById(R.id.ViewDayMood4).setBackgroundResource(moodColor(dayMinus3MoodIndex));
        if (todayComment == null) {
            findViewById(R.id.commentary4).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.commentary4).setVisibility(View.VISIBLE);
        }

        cal.add(Calendar.DATE, -4);
        Date dayMinus4 = cal.getTime();
        int dayMinus4MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus4);
        findViewById(R.id.ViewDayMood5).setBackgroundResource(moodColor(dayMinus4MoodIndex));
        if (todayComment == null) {
            findViewById(R.id.commentary5).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.commentary5).setVisibility(View.VISIBLE);
        }

        cal.add(Calendar.DATE, -5);
        Date dayMinus5 = cal.getTime();
        int dayMinus5MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus5);
        findViewById(R.id.ViewDayMood6).setBackgroundResource(moodColor(dayMinus5MoodIndex));
        if (todayComment == null) {
            findViewById(R.id.commentary6).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.commentary6).setVisibility(View.VISIBLE);
        }
    }




}
