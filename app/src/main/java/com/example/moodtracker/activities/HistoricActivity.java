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

// fonction qui permet de retourner la taille en fonction de leur mood
    private int widthOfMood(int moodIndex) {

        int widthOfMood;
        // creation de la d'un objet de type DisplayMetrics
        DisplayMetrics metrics = new DisplayMetrics();
        // utilisation du windows manager pour recuperer les dimensions de l'ecran qui est mis dans l'objet metrics
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenwidth = metrics.widthPixels;

        switch (moodIndex) {
            case 0:
                widthOfMood = (int) ( screenwidth * 0.2);
                break;

            case 1:
                widthOfMood = (int) ( screenwidth * 0.4);
                break;

            case 2:
                widthOfMood = (int) ( screenwidth * 0.6);
                break;

            case 3:
                widthOfMood = (int) ( screenwidth * 0.8);
                break;

            case 4:
                widthOfMood = (int)  screenwidth ;
                break;

            default:
                widthOfMood = (int) ( screenwidth * 0.2);
                break;

        }
        return widthOfMood;
    }

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Calendar cal = Calendar.getInstance();                                                     //obtient un calendrier utilisant le fuseau horaire actuel

        cal.add(Calendar.DATE, -1);                                                       //renvoie un objet ressemblant à la date qui est représentée par la valeur d'heure de ce calendrier
        Date dayMinus1 = cal.getTime();
        int dayMinus1MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus1);          //recupere le mood lier a la date et l'attribue a dayMinus1MoodIndex
        findViewById(R.id.ViewDayMood7).setBackgroundResource(moodColor(dayMinus1MoodIndex));     // recupere la couleur du mood pour ensuite l'afficher la couleur sur le background du xml
        findViewById(R.id.ViewDayMood7).getLayoutParams().width = widthOfMood(dayMinus1MoodIndex);
        final String yesterdayComment = MoodPreferences.getMoodCommentForDate(dayMinus1);         //recupere le commentraire du jour pour l'assigner a todaycomment
        ImageView comment7 = findViewById(R.id.commentary7);
        if (yesterdayComment == null) {                                                           //Rend visible le logo du commentaire si il y a des une note ou invisible si il y a rien noté
            comment7.setVisibility(View.INVISIBLE);
        } else {
            comment7.setVisibility(View.VISIBLE);
            comment7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), yesterdayComment, Toast.LENGTH_SHORT).show();
                }
            });
        }

        cal.add(Calendar.DATE, -1);
        Date dayMinus2 = cal.getTime();
        int dayMinus2MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus2);
        findViewById(R.id.ViewDayMood6).setBackgroundResource(moodColor(dayMinus2MoodIndex));
        findViewById(R.id.ViewDayMood6).getLayoutParams().width = widthOfMood(dayMinus2MoodIndex);
        final String dayMinus2Comment = MoodPreferences.getMoodCommentForDate(dayMinus2);
        ImageView comment6 = findViewById(R.id.commentary6);
        if (dayMinus2Comment == null) {
            comment6.setVisibility(View.INVISIBLE);
        } else {
            comment6.setVisibility(View.VISIBLE);
            comment6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), dayMinus2Comment, Toast.LENGTH_SHORT).show();
                }
            });
        }

        cal.add(Calendar.DATE, -1);
        Date dayMinus3 = cal.getTime();
        int dayMinus3MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus3);
        findViewById(R.id.ViewDayMood5).setBackgroundResource(moodColor(dayMinus3MoodIndex));
        findViewById(R.id.ViewDayMood5).getLayoutParams().width = widthOfMood(dayMinus3MoodIndex);
        final String dayMinus3Comment = MoodPreferences.getMoodCommentForDate(dayMinus3);
        ImageView comment5 = findViewById(R.id.commentary5);
        if (dayMinus3Comment == null) {
            comment5.setVisibility(View.INVISIBLE);
        } else {
            comment5.setVisibility(View.VISIBLE);
            comment5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), dayMinus3Comment, Toast.LENGTH_SHORT).show();
                }
            });
        }

        cal.add(Calendar.DATE, -1);
        Date dayMinus4 = cal.getTime();
        int dayMinus4MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus4);
        findViewById(R.id.ViewDayMood4).setBackgroundResource(moodColor(dayMinus4MoodIndex));
        findViewById(R.id.ViewDayMood4).getLayoutParams().width = widthOfMood(dayMinus4MoodIndex);
        final String dayMinus4Comment = MoodPreferences.getMoodCommentForDate(dayMinus4);
        ImageView comment4 = findViewById(R.id.commentary4);
        if (dayMinus4Comment == null) {
            comment4.setVisibility(View.INVISIBLE);
        } else {
            comment4.setVisibility(View.VISIBLE);
            comment4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), dayMinus4Comment, Toast.LENGTH_SHORT).show();
                }
            });
        }

        cal.add(Calendar.DATE, -1);
        Date dayMinus5 = cal.getTime();
        int dayMinus5MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus5);
        findViewById(R.id.ViewDayMood3).setBackgroundResource(moodColor(dayMinus5MoodIndex));
        findViewById(R.id.ViewDayMood3).getLayoutParams().width = widthOfMood(dayMinus5MoodIndex);
        final String dayMinus5Comment = MoodPreferences.getMoodCommentForDate(dayMinus5);
        ImageView comment3 = findViewById(R.id.commentary3);
        if (dayMinus5Comment == null) {
            comment3.setVisibility(View.INVISIBLE);
        } else {
            comment3.setVisibility(View.VISIBLE);
            comment3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), dayMinus5Comment, Toast.LENGTH_SHORT).show();
                }
            });
        }

        cal.add(Calendar.DATE, -1);
        Date dayMinus6 = cal.getTime();
        int dayMinus6MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus6);
        findViewById(R.id.ViewDayMood2).setBackgroundResource(moodColor(dayMinus6MoodIndex));
        findViewById(R.id.ViewDayMood2).getLayoutParams().width = widthOfMood(dayMinus6MoodIndex);
        final String dayMinus6Comment = MoodPreferences.getMoodCommentForDate(dayMinus6);
        ImageView comment2 = findViewById(R.id.commentary2);
        if (dayMinus6Comment == null) {
            comment2.setVisibility(View.INVISIBLE);
        } else {
            comment2.setVisibility(View.VISIBLE);
            comment2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), dayMinus6Comment, Toast.LENGTH_SHORT).show();
                }
            });
        }

        cal.add(Calendar.DATE, -1);
        Date dayMinus7 = cal.getTime();
        int dayMinus7MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus7);
        findViewById(R.id.ViewDayMood1).setBackgroundResource(moodColor(dayMinus7MoodIndex));
        findViewById(R.id.ViewDayMood1).getLayoutParams().width = widthOfMood(dayMinus7MoodIndex);
        final String dayMinus7Comment = MoodPreferences.getMoodCommentForDate(dayMinus7);
        ImageView comment1 = findViewById(R.id.commentary1);
        if (dayMinus7Comment == null) {
            comment1.setVisibility(View.INVISIBLE);
        } else {
            comment1.setVisibility(View.VISIBLE);
        }
        comment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), dayMinus7Comment, Toast.LENGTH_SHORT).show();
            }
        });
    }
}