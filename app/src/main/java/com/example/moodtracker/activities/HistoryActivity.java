package com.example.moodtracker.activities;

import android.graphics.Color;
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
import java.util.Date;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Le layoutde l'activité est activityHistory(xml)
        setContentView(R.layout.activity_history);

        // on recupère la vue dans dont l'identidiant et history ln qui correspond au xml history activité
        LinearLayout parentView = findViewById(R.id.historyLl);

        //ici charger le layout history_row grace à un layout inflater
        //puis essayer de changer la couleur du linearlayout (background color)

        // on recupere l'historique et on le charge dans la variable savemoods (qui est une liste)
        List<SaveMood> saveMoods = MoodPreferences.getMoods();

        // on parcourt savemood a l'aide de la boucle
        for (int i = 0; i < saveMoods.size(); i++) {


            // on recupere l'index de savemoods et on la met dans la variable mood
            final SaveMood mood = saveMoods.get(i);

            // on charge le layout d'une barre dans une vue Java
            LayoutInflater inflater = LayoutInflater.from(this);

            // view corespond a une barre dans le layout qui contient l'historique d'une journée
            // la methode inflate permet de charger l' xml en java
            View view = inflater.inflate(R.layout.history_row, null);

            //on customize la vue

            //view.setBackgroundColor(Color.BLACK);
            int moodIndex = mood.getFragmentIndex();
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
            } catch (ParseException e) {
                Log.e("HistoryActivity", "parse error: "+e);
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
    }
}
