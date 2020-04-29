package com.example.moodtracker.activities;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.moodtracker.R;
import com.example.moodtracker.fragments.MoodFragment;
import com.example.moodtracker.models.Alarm;
import com.example.moodtracker.models.SaveMood;
import com.example.moodtracker.utils.MoodPreferences;
import com.example.moodtracker.utils.OnSwipetouchListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {   //ressource des differents fragment Mood pour les switch
    private int currentPosition = 2;


    // Appelé quand l'écran démarrage
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View view = findViewById(R.id.fragment);         // Appel la vue du fragment

        changeFragment(view, MoodFragment.newInstance(currentPosition));
        view.setOnTouchListener(new OnSwipetouchListener(MainActivity.this) {

            public void onSwipeTop() {                         //fonction lors du switch vers le haut
                // message afficher lors de l'action
                Log.e("DEBUG", "OnSwipeTop");

                int todayMoodFragmentIndex = currentPosition;                               //recupere l'index du mood du jour et le commentaire du jour
                String todayMoodComment = MoodPreferences.getMoodCommentForDate(new Date());

                //enregistre le mood sous la forme simple date format avec le mood plus le commentaires
                SaveMood newMood = new SaveMood(new SimpleDateFormat("yyyyMMdd").format(new Date()), todayMoodComment, todayMoodFragmentIndex);
                MoodPreferences.changeTodayMood(newMood);

                if (currentPosition > 0) {
                    currentPosition--;
                    changeFragment(view, MoodFragment.newInstance(currentPosition));
                }

            }

            //fonction lors du switch vers le bas
            public void onSwipeBottom() {

                Log.e("DEBUG", "onSwipeBottom");

                //recupere l'index du mood du jour et le commentaire du jour
                int todayMoodFragmentIndex = currentPosition;
                String todayMoodComment = MoodPreferences.getMoodCommentForDate(new Date());

                //enregistre le mood sous la forme simple date format avec le mood plus le commentaires
                SaveMood newMood = new SaveMood(new SimpleDateFormat("yyyyMMdd").format(new Date()), todayMoodComment, todayMoodFragmentIndex);
                MoodPreferences.changeTodayMood(newMood);

                if (currentPosition < 4) {
                    currentPosition++;
                    changeFragment(view, MoodFragment.newInstance(currentPosition));
                }
            }

        });

        public void alarmWork() {


            AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Intent myIntent;
            PendingIntent alarmIntent ;

            myIntent = new Intent(MainActivity.this, Alarm.class);
         //   am.setInexactRepeating(AlarmManager.RTC_WAKEUP,Calendar.getInstance(),AlarmManager.INTERVAL_DAY,alarmIntent);

        }


      //  Calendar calendar = Calendar.getInstance();
       // calendar.setTimeInMillis(System.currentTimeMillis());
        //calendar.set(Calendar.HOUR_OF_DAY, 00);




        ImageView buttonCommentaire = findViewById(R.id.imageView_main_comment);  //afficher une une fentre de dialogue lors du clique sur l'image commentaire a la page d'acceuille
        buttonCommentaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showComment();
            }
        });

        ImageView buttonHistory = findViewById(R.id.imageView_main_history);      // affiche la page de l'historique lors du clique sur l'image historique
        buttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startHistory();
            }
        });
    }

    public void changeFragment(View view, Fragment fragment) {                        //permet de changer de fragement
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(view.getId(), fragment);
        transaction.commit();
    }

    // petite fenetre showcomment composé d'un endroit pour pouvoir laiser un commentaire et valider ou annuler
    protected void showComment() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final EditText edittext = new EditText(this);
        alert.setMessage(getString(R.string.comment));
        alert.setTitle("Day Mood");

        alert.setView(edittext);

        alert.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String myComment = edittext.getText().toString();
                int todayMoodFragmentIndex = currentPosition;


                String dateMood =new SimpleDateFormat("yyyyMMdd").format(new Date());
                SaveMood newMood = new SaveMood(dateMood,myComment,todayMoodFragmentIndex  );
                MoodPreferences.changeTodayMood(newMood);

            }
        });

        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });

        alert.show();
    }

    // fonction qui permet d'ouvrir la classe History dan

    public void startHistory() {
        Intent intent = new Intent(this, HistoricActivity.class);
        startActivity(intent);
    }


}










































