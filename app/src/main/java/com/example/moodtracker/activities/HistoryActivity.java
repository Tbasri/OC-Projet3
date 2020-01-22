package com.example.moodtracker.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moodtracker.R;
import com.example.moodtracker.models.SaveMood;
import com.example.moodtracker.utils.MoodPreferences;
import com.google.gson.Gson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

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

    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Le layout de l'activité est activityHistory(xml)
        setContentView(R.layout.activity_historique);
/*
        // on recupère la vue dans dont l'identidiant et history ln qui correspond au xml history activité
        LinearLayout parentView = findViewById(R.id.historyLl);

        //ici charger le layout history_row grace à un layout inflater
        //puis essayer de changer la couleur du linearlayout (background color)

        // on recupere l'historique et on le charge dans la variable savemoods (qui est une liste)
        List<SaveMood> saveMoods = MoodPreferences.getMoods();

            // on recupere l'index de savemoods et on la met dans la variable mood
            final SaveMood mood = saveMoods.get(i);

// Apply the changes - mConstraintLayout is reference to it's view
        //

        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();

        // Récupérer la vue et afficher la bonne couleur rendre visible ou non le commentaire

        String todayComment = MoodPreferences.getMoodCommentForDate(today);
        findViewById(R.id.mood_day1).setBackgroundResource(moodColor(todayMoodIndex));
        if (todayComment == null) {
            findViewById(R.id.commentary1).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.commentary1).setVisibility(View.VISIBLE);
        }

        cal.add(Calendar.DATE, -1);
        Date yesterday = cal.getTime();
        findViewById(R.id.ViewDayMood2).setBackgroundResource(moodColor(yesterdayMoodIndex));
        if (todayComment == null) {
            findViewById(R.id.commentary2).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.commentary2).setVisibility(View.VISIBLE);
        }

        cal.add(Calendar.DATE, -2);
        Date dayMinus2 = cal.getTime();
        findViewById(R.id.ViewDayMood3).setBackgroundResource(moodColor(dayMinus2MoodIndex));
        if (todayComment == null) {
            findViewById(R.id.commentary3).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.commentary3).setVisibility(View.VISIBLE);
        }

        cal.add(Calendar.DATE, -3);
        Date dayMinus3 = cal.getTime();
        findViewById(R.id.ViewDayMood4).setBackgroundResource(moodColor(dayMinus3MoodIndex));
        if (todayComment == null) {
            findViewById(R.id.commentary4).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.commentary4).setVisibility(View.VISIBLE);
        }

        cal.add(Calendar.DATE, -4);
        Date dayMinus4 = cal.getTime();
        findViewById(R.id.ViewDayMood5).setBackgroundResource(moodColor(dayMinus4MoodIndex));
        if (todayComment == null) {
            findViewById(R.id.commentary5).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.commentary5).setVisibility(View.VISIBLE);
        }

        cal.add(Calendar.DATE, -5);
        Date dayMinus5 = cal.getTime();
        findViewById(R.id.ViewDayMood6).setBackgroundResource(moodColor(dayMinus5MoodIndex));
        if (todayComment == null) {
            findViewById(R.id.commentary6).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.commentary6).setVisibility(View.VISIBLE);
        }*/
    }
/*      //on customize la vue

            //view.setBackgroundColor(Color.BLACK);
            int moodColor = getColorFromIndex(moodIndex);
            view.setBackgroundResource(moodColor);

            //permet le nombre de jour ecoulé
            TextView dateTxt = view.findViewById(R.id.dateTxt);
            //on donne le format de la date enregistré par les moods
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
            try {
                //on convertit la date initialement en String, en objet Date
                Date dateMood = df.parse(mood.getDate());
                //on calcule la différence entre la date du mood et aujourd'hui
                long diffDays = MoodPreferences.getDiffDays(dateMood, new Date());
                dateTxt.setText("il y a "+diffDays + " jours");
            }

            if (mood.getComment() != null && !mood.getComment().equals("")) {

                ImageView imgComment = view.findViewById(R.id.commentImg);
                imgComment.setVisibility(View.VISIBLE);
                imgComment.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Toast.makeText(HistoryActivity.this, mood.getComment(), Toast.LENGTH_LONG).show();
                    }
                });
            }

            LinearLayout.LayoutParams viewParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT, 1f);
            view.setLayoutParams(viewParam);

            // on ajoute cette vue dans le linearLayout de activity_history.xml
            parentView.addView(view);
        }
    }

    private int getColorFromIndex(int index) {
        switch (index) {
            case 0:
                return R.color.very_sad_color;
            case 1:
                return R.color.sad_color;
            case 2:
                return R.color.normal_color;
            case 3:
                return R.color.good_color;
            case 4:
                return R.color.very_good_color;
            default:
                return R.color.normal_color;
        }
    }*/
}