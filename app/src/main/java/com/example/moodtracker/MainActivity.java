package com.example.moodtracker;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String PREFS = "PREFS";
    SharedPreferences sharedPreferences;

    private void refreshFragment(View view) {
        switch (getCurrentMood().index) {
            case 0:
                changeFragment(view, new VerySadMoodFragment());
                break;
            case 1:
                changeFragment(view, new SadMoodFragment());
                break;
            case 3:
                changeFragment(view, new GoodMoodFragment());
                break;
            case 4:
                changeFragment(view, new VeryGoodMoodFragment());
                break;
            default:
                changeFragment(view, new NormalMoodFragment());
                break;
        }
    }

    Gson gson = new Gson();

    private List<SaveMood> getMoods() {
        SharedPreferences sharedPreferences = getSharedPreferences("PREFS", Context.MODE_PRIVATE);

        String json = sharedPreferences.getString("Mood", null);

        List<SaveMood> saveMood = new ArrayList<>();

        if (json != null) {
            saveMood = gson.fromJson(json, new TypeToken<List<SaveMood>>() {
            }.getType());
        }

        return saveMood;
    }

    private int getCurrentMoodIndex() {
        List<SaveMood> saveMood = getMoods();

        int index = -1;

        for (int i = 0; i < saveMood.size(); i++) {
            if (saveMood.get(i).date.equals(new SimpleDateFormat("yyyyMMdd").format(new Date()))) {
                index = i;

            }
        }

        return index;

    }

    private SaveMood getCurrentMood() {
        int index = getCurrentMoodIndex();
        if (index != -1) {
            return getMoods().get(index);
        }

        SaveMood mood = new SaveMood(new SimpleDateFormat("yyyyMMdd").format(new Date()),2) ;

        return mood;
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
                Log.e("DEBUG", "OnSwipeTop");
                SaveMood newMood = getCurrentMood();

                List<SaveMood> list = getMoods();
                if (newMood == null) {
                    newMood = new SaveMood(new SimpleDateFormat("yyyyMMdd").format(new Date()), 2);
                    list.add(newMood);
                } else {
                    newMood.index = newMood.index - 1;
                    list.set(getCurrentMoodIndex(), newMood);
                }

                sharedPreferences
                        .edit()
                        .putString("Mood", gson.toJson(list))
                        .apply();

                refreshFragment(view);
            }

            public void onSwipeBottom() {
                Log.e("DEBUG", "onSwipeBottom");

                SaveMood newMood = getCurrentMood();

                List<SaveMood> list = getMoods();
                if (newMood == null) {
                    newMood = new SaveMood(new SimpleDateFormat("yyyyMMdd").format(new Date()), 2);
                    list.add(newMood);
                } else {
                    newMood.index = newMood.index + 1;
                    list.set(getCurrentMoodIndex(), newMood);
                }

                sharedPreferences
                        .edit()
                        .putString("Mood", gson.toJson(list))
                        .apply();

                refreshFragment(view);
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










































