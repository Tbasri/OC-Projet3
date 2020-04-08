package com.example.moodtracker.activities;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moodtracker.R;
import com.example.moodtracker.utils.MoodPreferences;

import java.util.Calendar;
import java.util.Date;

// Ecran qui affiche l'historique des humeurs
public class HistoricActivity extends AppCompatActivity {

    // Afficher couleur
//j'attribue un index de 0 à 4 sur chaque couleur

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
                moodColor = (R.color.ic_good_mood);
                break;

            case 4:
                moodColor = (R.color.ic_very_good_mood);
                break;

            default:
                moodColor = (R.color.default_color);
                break;

        }
        return moodColor;
    }

    ImageView comment1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);

        comment1 = (ImageView) findViewById(R.id.commentary1);


        //obtient un calendrier utilisant le fuseau horaire actuel
        Calendar cal = Calendar.getInstance();
        //renvoie un objet ressemblant à la date qui est représentée par la valeur d'heure de ce calendrier
        // Récupérer la vue et afficher la bonne couleur rendre visible ou non le commentaire
        //recupere le commentraire du jour pour l'assigner a todaycomment
        //recupere le mood lier a la date et l'attribue a today mood index
        // recupere la couleur du mood pour ensuite l'afficher la couleur sur le background du xml
        //Rend visible le logo du commentaire si il y a des une note ou invisible si il y a rien noté

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int with = dm.widthPixels;

        cal.add(Calendar.DATE, -1);
        Date yersterday = cal.getTime();

        int yersterdayMoodIndex = MoodPreferences.getMoodFragmentIndexForDate(yersterday);
        findViewById(R.id.ViewDayMood7).setBackgroundResource(moodColor(yersterdayMoodIndex));
        String yesterdayComment = MoodPreferences.getMoodCommentForDate(yersterday);
        if (yesterdayComment == null) {
            findViewById(R.id.commentary7).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.commentary7).setVisibility(View.VISIBLE);
        }

        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;


        cal.add(Calendar.DATE, -1);
        Date dayMinus2 = cal.getTime();
        int dayMinus2MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus2);
        findViewById(R.id.ViewDayMood6).setBackgroundResource(moodColor(dayMinus2MoodIndex));
        String dayMinus2Comment = MoodPreferences.getMoodCommentForDate(dayMinus2);
        if (dayMinus2Comment == null) {
            findViewById(R.id.commentary6).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.commentary6).setVisibility(View.VISIBLE);
        }

        cal.add(Calendar.DATE, -1);
        Date dayMinus3 = cal.getTime();
        int dayMinus3MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus3);
        findViewById(R.id.ViewDayMood5).setBackgroundResource(moodColor(dayMinus3MoodIndex));
        String dayMinus3Comment = MoodPreferences.getMoodCommentForDate(dayMinus3);
        if (dayMinus3Comment == null) {
            findViewById(R.id.commentary5).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.commentary5).setVisibility(View.VISIBLE);
        }

        cal.add(Calendar.DATE, -1);
        Date dayMinus4 = cal.getTime();
        int dayMinus4MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus4);
        findViewById(R.id.ViewDayMood4).setBackgroundResource(moodColor(dayMinus4MoodIndex));
        String dayMinus4Comment = MoodPreferences.getMoodCommentForDate(dayMinus4);
        if (dayMinus4Comment == null) {
            findViewById(R.id.commentary4).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.commentary4).setVisibility(View.VISIBLE);
        }

        cal.add(Calendar.DATE, -1);
        Date dayMinus5 = cal.getTime();
        int dayMinus5MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus5);
        findViewById(R.id.ViewDayMood3).setBackgroundResource(moodColor(dayMinus5MoodIndex));
        String dayMinus5Comment = MoodPreferences.getMoodCommentForDate(dayMinus5);
        if (dayMinus5Comment == null) {
            findViewById(R.id.commentary3).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.commentary3).setVisibility(View.VISIBLE);
        }

        cal.add(Calendar.DATE, -1);
        Date dayMinus6 = cal.getTime();
        int dayMinus6MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus6);
        findViewById(R.id.ViewDayMood2).setBackgroundResource(moodColor(dayMinus6MoodIndex));
        String dayMinus6Comment = MoodPreferences.getMoodCommentForDate(dayMinus6);
        if (dayMinus6Comment == null) {
            findViewById(R.id.commentary2).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.commentary2).setVisibility(View.VISIBLE);
        }
        cal.add(Calendar.DATE, -1);
        Date dayMinus7 = cal.getTime();
        int dayMinus7MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus7);
        findViewById(R.id.ViewDayMood1).setBackgroundResource(moodColor(dayMinus7MoodIndex));
        final String dayMinus7Comment = MoodPreferences.getMoodCommentForDate(dayMinus7);
        if (dayMinus7Comment == null) {
            findViewById(R.id.commentary1).setVisibility(View.INVISIBLE);
        } else {
            findViewById(R.id.commentary1).setVisibility(View.VISIBLE);
        }
        comment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dayMinus7Comment == null) {
                    Toast.makeText(HistoricActivity.this, "no comment save", Toast.LENGTH_SHORT).show();
                }
            }
        });

// faire marcher la fonction visible invisible pour le commentaire dasn historicActivity

//layout "hier" pas en place a arranger ( enregistrement des mood dans historique decaler à reverifier) peut etre liée
//}
    }}