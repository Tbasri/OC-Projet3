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
    ImageView comment2;
    ImageView comment3;
    ImageView comment4;
    ImageView comment5;
    ImageView comment6;
    ImageView comment7;


    public void displayToast(Date commentDate) {
        final String commentTxt = MoodPreferences.getMoodCommentForDate(commentDate);
        Toast.makeText(HistoricActivity.this, commentTxt, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);


        //obtient un calendrier utilisant le fuseau horaire actuel
        Calendar cal = Calendar.getInstance();
        //renvoie un objet ressemblant à la date qui est représentée par la valeur d'heure de ce calendrier
        // Récupérer la vue et afficher la bonne couleur rendre visible ou non le commentaire
        //recupere le commentraire du jour pour l'assigner a todaycomment
        //recupere le mood lier a la date et l'attribue a today mood index
        // recupere la couleur du mood pour ensuite l'afficher la couleur sur le background du xml
        //Rend visible le logo du commentaire si il y a des une note ou invisible si il y a rien noté

     //   DisplayMetrics dm = new DisplayMetrics();
      //  getWindowManager().getDefaultDisplay().getMetrics(dm);
      //  int with = dm.widthPixels;

        comment7 = findViewById(R.id.commentary7);
        cal.add(Calendar.DATE, -1);
        final Date yersterday = cal.getTime();
        int yersterdayMoodIndex = MoodPreferences.getMoodFragmentIndexForDate(yersterday);
        findViewById(R.id.ViewDayMood7).setBackgroundResource(moodColor(yersterdayMoodIndex));
        String yesterdayComment = MoodPreferences.getMoodCommentForDate(yersterday);
        if (yesterdayComment == null) {
            comment7.setVisibility(View.INVISIBLE);
        } else {
            comment7.setVisibility(View.VISIBLE);
        }
        comment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayToast(yersterday);

            }
        });

     //   getWindowManager().getDefaultDisplay().getMetrics(dm);
      //  int width = dm.widthPixels;

        comment2 = findViewById(R.id.commentary2);
        cal.add(Calendar.DATE, -1);
        final Date dayMinus2 = cal.getTime();
        int dayMinus2MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus2);
        findViewById(R.id.ViewDayMood6).setBackgroundResource(moodColor(dayMinus2MoodIndex));
        String dayMinus2Comment = MoodPreferences.getMoodCommentForDate(dayMinus2);
        if (dayMinus2Comment == null) {
            comment6.setVisibility(View.INVISIBLE);
        } else {
            comment6.setVisibility(View.VISIBLE);
        }
        comment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayToast(dayMinus2);

            }
        });
        comment2 = findViewById(R.id.commentary2);
        cal.add(Calendar.DATE, -1);
        final Date dayMinus3 = cal.getTime();
        int dayMinus3MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus3);
        findViewById(R.id.ViewDayMood5).setBackgroundResource(moodColor(dayMinus3MoodIndex));
        String dayMinus3Comment = MoodPreferences.getMoodCommentForDate(dayMinus3);
        if (dayMinus3Comment == null) {
            comment5.setVisibility(View.INVISIBLE);
        } else {
            comment5.setVisibility(View.VISIBLE);
        }
        comment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayToast(dayMinus3);

            }
        });
        comment2 = findViewById(R.id.commentary2);
        cal.add(Calendar.DATE, -1);
        final Date dayMinus4 = cal.getTime();
        int dayMinus4MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus4);
        findViewById(R.id.ViewDayMood4).setBackgroundResource(moodColor(dayMinus4MoodIndex));
        String dayMinus4Comment = MoodPreferences.getMoodCommentForDate(dayMinus4);
        if (dayMinus4Comment == null) {
            comment4.setVisibility(View.INVISIBLE);
        } else {
            comment4.setVisibility(View.VISIBLE);
        }
        comment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayToast(dayMinus4);

            }
        });
        comment2 = findViewById(R.id.commentary2);
        cal.add(Calendar.DATE, -1);
        final Date dayMinus5 = cal.getTime();
        int dayMinus5MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus5);
        findViewById(R.id.ViewDayMood3).setBackgroundResource(moodColor(dayMinus5MoodIndex));
        String dayMinus5Comment = MoodPreferences.getMoodCommentForDate(dayMinus5);
        if (dayMinus5Comment == null) {
            comment3.setVisibility(View.INVISIBLE);
        } else {
            comment3.setVisibility(View.VISIBLE);
            Toast.makeText(HistoricActivity.this, "", Toast.LENGTH_LONG).show();
        }
        comment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayToast(dayMinus5);

            }
        });
        comment2 = findViewById(R.id.commentary2);
        cal.add(Calendar.DATE, -1);
         final Date dayMinus6 = cal.getTime();
         int dayMinus6MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus6);
         findViewById(R.id.ViewDayMood2).setBackgroundResource(moodColor(dayMinus6MoodIndex));
         String dayMinus6Comment = MoodPreferences.getMoodCommentForDate(dayMinus6);
        if (dayMinus6Comment == null) {
            comment2.setVisibility(View.INVISIBLE);
        } else {
            comment2.setVisibility(View.VISIBLE);

        }
        comment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayToast(dayMinus6);

            }
        });

        comment1 = findViewById(R.id.commentary1);
        cal.add(Calendar.DATE, -1);
        final Date dayMinus7 = cal.getTime();
        int dayMinus7MoodIndex = MoodPreferences.getMoodFragmentIndexForDate(dayMinus7);
        findViewById(R.id.ViewDayMood1).setBackgroundResource(moodColor(dayMinus7MoodIndex));
        final String dayMinus7Comment = MoodPreferences.getMoodCommentForDate(dayMinus7);

        if (dayMinus7Comment == null) {
            comment1.setVisibility(View.INVISIBLE);
        } else {
            comment1.setVisibility(View.VISIBLE);
        }

        comment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayToast(dayMinus7);

            }
        });
    }
}