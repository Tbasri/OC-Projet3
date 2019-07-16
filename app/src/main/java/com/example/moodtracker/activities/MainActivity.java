package com.example.moodtracker.activities;

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
import com.example.moodtracker.models.SaveMood;
import com.example.moodtracker.utils.MoodPreferences;
import com.example.moodtracker.utils.OnSwipetouchListener;

import java.text.SimpleDateFormat;
import java.util.Date;

// Ecran principal de l'application
// Il permet de :
// • changer l'humeur du jour
// • démarrage du dialog pour changer le commentaire
// • démarrage de l'activité historique

//ressource des differents fragment Mood pour les switch
public class MainActivity extends AppCompatActivity {
    private int currentPosition = 2;

    // Appelé quand l'écran démarrage
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Appel la vue du fragment
        final View view = findViewById(R.id.fragment);

        changeFragment(view, MoodFragment.newInstance(currentPosition));
        view.setOnTouchListener(new OnSwipetouchListener(MainActivity.this) {

            //fonction lors du switch vers le haut
            public void onSwipeTop() {
                // message afficher lors de l'action
                Log.e("DEBUG", "OnSwipeTop");

                //recupere l'index du mood du jour et le commentaire du jour
                int todayMoodFragmentIndex = MoodPreferences.getMoodFragmentIndexForDate(new Date());
                String todayMoodComment = MoodPreferences.getMoodCommentForDate(new Date());

                //enregistre le mood sous la forme simple date format avec le mood plus le commentaires
                SaveMood newMood = new SaveMood(new SimpleDateFormat("yyyyMMdd").format(new Date()), todayMoodFragmentIndex - 1, todayMoodComment);

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
                int todayMoodFragmentIndex = MoodPreferences.getMoodFragmentIndexForDate(new Date());
                String todayMoodComment = MoodPreferences.getMoodCommentForDate(new Date());

                //enregistre le mood sous la forme simple date format avec le mood plus le commentaires
                SaveMood newMood = new SaveMood(new SimpleDateFormat("yyyyMMdd").format(new Date()), todayMoodFragmentIndex + 1, todayMoodComment);

                MoodPreferences.changeTodayMood(newMood);

                if (currentPosition < 4) {
                    currentPosition++;
                    changeFragment(view, MoodFragment.newInstance(currentPosition));
                }
            }

        });

        //afficher une une fentre de gialogue lors du clique sur l'image commentaire a la page d'acceuille
        ImageView buttonCommentaire = findViewById(R.id.imageView_main_comment);
        buttonCommentaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showComment();
            }
        });

        // affiche la page de l'historique lors du clique sur l'image historique
        ImageView buttonHistory = findViewById(R.id.imageView_main_history);
        buttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startHistory();
            }
        });
    }

    //permet de chager de fragement
    public void changeFragment(View view, Fragment fragment) {
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

                int todayMoodFragmentIndex = MoodPreferences.getMoodFragmentIndexForDate(new Date());

                SaveMood newMood = new SaveMood(new SimpleDateFormat("yyyyMMdd").format(new Date()), todayMoodFragmentIndex, myComment);

                MoodPreferences.changeTodayMood(newMood);

            }
        });

        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });

        alert.show();
    }

    // fonction qui permet d'ouvrir la classe History dans

    public void startHistory() {
        Intent intent = new Intent(this, HistoricActivity.class);
        startActivity(intent);
    }


}










































