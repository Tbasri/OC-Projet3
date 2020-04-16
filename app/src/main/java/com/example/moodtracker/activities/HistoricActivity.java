package com.example.moodtracker.activities;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
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

  /*  private void getDeviceMetrics(){
        //Get Device Width and Height
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowmanager = (WindowManager) getApplicationContext().getSystemService(getApplicationContext().WINDOW_SERVICE);
        windowmanager.getDefaultDisplay().getMetrics(displayMetrics);
        deviceWidth = displayMetrics.widthPixels;
    }
    //Define FrameLayout metrics with device metrics * size of mood
    final double [] viewSizeMultiplier = {0.25, 0.4, 0.6, 0.8, 1};
    getDeviceMetrics();
    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
            (int) (deviceWidth*viewSizeMultiplier),
            (int) deviceHeight/9);

    private static String getDensityName(Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        if () {
            return "";
        }
        if () {
            return "";
        }
        if () {
            return "";
        }
        if () {
            return "";
        }
        if (density >= 1.0) {
            return "mdpi";
        }
        return "ldpi";
    }
    DisplayMetrics metrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(metrics);

switch(metrics.densityDpi) {
        case DisplayMetrics.DENSITY_LOW:
            break;

        case DisplayMetrics.DENSITY_MEDIUM:
            break;

        case DisplayMetrics.DENSITY_HIGH:
            break;
    }

    private int widthPixels(int moodIndex) {

        int widthPixels;

        switch (metrics.widthPixels){

            case 0:

                widthPixels = DisplayMetrics/1;
            case 1:

                widthPixels = DisplayMetrics/2;

            case 2:

                widthPixels = DisplayMetrics/3;

            case 3:

                widthPixels = DisplayMetrics/4;
        }


    }

    private  int widthofmood(int moodIndex){

        int widthofmood;

        switch (moodIndex) {
            case 0:
                widthofmood = ;
                break;

            case 1:
                widthofmood = ;
                break;

            case 2:
                widthofmood= ;
                break;

            case 3:
                widthofmood = ;
                break;

            case 4:
                widthofmood =
                ;
                break;

            default:
                widthofmood = ;
                break;

        }



    }

*/


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
        setContentView(R.layout.activity_historique);


        //obtient un calendrier utilisant le fuseau horaire actuel
        Calendar cal = Calendar.getInstance();
        //renvoie un objet ressemblant à la date qui est représentée par la valeur d'heure de ce calendrier
        // Récupérer la vue et afficher la bonne couleur rendre visible ou non le commentaire
        //recupere le commentraire du jour pour l'assigner a todaycomment
        //recupere le mood lier a la date et l'attribue a today mood index
        // recupere la couleur du mood pour ensuite l'afficher la couleur sur le background du xml
        //Rend visible le logo du commentaire si il y a des une note ou invisible si il y a rien noté

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
         int width = metrics.widthPixels;


        cal.add(Calendar.DATE, -1);
        Date yersterday = cal.getTime();
        int yersterdayMoodIndex = MoodPreferences.getMoodFragmentIndexForDate(yersterday);
        findViewById(R.id.ViewDayMood7).setBackgroundResource(moodColor(yersterdayMoodIndex));
     //    findViewById(R.id.ViewDayMood7).getLayoutParams().width = findViewById(R.id.ViewDayMood7).getLayoutParams().width/2;
     //  int oldwidth = (R.id.ViewDayMood7).getLayoutParams().width;
     //  params.width = viewDayMood1View.getLayoutParams().width/2;
        final String yesterdayComment = MoodPreferences.getMoodCommentForDate(yersterday);
        ImageView comment7 = findViewById(R.id.commentary7);
        if (yesterdayComment == null) {
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