package com.example.moodtracker;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {

    private static final String PREFS = "PREFS";
    private static final String PREFS_MOOD = "PREFS_MoodFragment";
    SharedPreferences sharedPreferences;

    private void refreshFragment(View view) {
        switch (getCurrentMood()) {
            case 0:
                changeFragment(view, new VerySadMoodFragment());
                break;
            case 1:
                changeFragment(view, new SadMoodFragment());
                break;
            case 2:
                changeFragment(view, new NormalMoodFragment());
                break;
            case 3:
                changeFragment(view, new GoodMoodFragment());
                break;
            case 4:
                changeFragment(view, new VeryGoodMoodFragment());
                break;
        }
    }

    private int getCurrentMood() {
        return sharedPreferences.getInt(PREFS_MOOD, 2);
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(PREFS, MODE_PRIVATE);
        final View view = findViewById(R.id.fragment);

        refreshFragment(view);
        view.setOnTouchListener(new OnSwipetouchListener(MainActivity.this) {

            public void onSwipeTop() {

                if (getCurrentMood() > 0) {
                    sharedPreferences
                            .edit()
                            .putInt(PREFS_MOOD, getCurrentMood() - 1)
                            .apply();

// Stocker une liste de save mood sous forme de string en gson au lieu d'un int

                    refreshFragment(view);
                }
            }

            public void onSwipeBottom() {

                if (getCurrentMood() < 4) {
                    sharedPreferences
                            .edit()
                            .putInt(PREFS_MOOD, getCurrentMood() + 1)
                            .apply();

                    refreshFragment(view);
                }
            }

        });

        ImageView buttonCommentaire = findViewById(R.id.imageView_main_comment);
        buttonCommentaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showComment();
            }
        });

        ImageView buttonHistory = findViewById(R.id.imageView_main_history);
        buttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startHistory();
            }
        });
    }

    public void changeFragment(View view, Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(view.getId(), fragment);
        transaction.commit();
    }

    protected void showComment() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final EditText edittext = new EditText(this);
        alert.setMessage("Commentaire:");
        alert.setTitle("Day Mood");

        alert.setView(edittext);

        alert.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String myComment = edittext.getText().toString();
            }
        });

        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });

        alert.show();
    }

    public void startHistory() {
        Intent intent = new Intent(getApplicationContext(), Historique.class);
        startActivity(intent);
    }
}










































