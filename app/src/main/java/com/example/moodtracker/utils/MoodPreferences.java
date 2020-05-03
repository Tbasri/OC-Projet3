package com.example.moodtracker.utils;

import android.content.SharedPreferences;

import com.example.moodtracker.MyApp;
import com.example.moodtracker.models.SaveMood;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MoodPreferences {       //fonction des enregistrer

    static Gson gson = new Gson();

    public static List<SaveMood> getMoods() {                              // recupere la list de save mood sauvegarder dans le telephone
        SharedPreferences sharedPreferences = MyApp.sharedPreferences;

        String json = sharedPreferences.getString("Mood", null);

        List<SaveMood> saveMood = new ArrayList<>();

        if (json != null) {
            saveMood = gson.fromJson(json, new TypeToken<List<SaveMood>>() {
            }.getType());
        }
        return saveMood;
    }

    public static int getMoodIndexForDate(Date date) {           // recupere l'index du mood lier date grace a une boucle
        List<SaveMood> list = getMoods();

        int index = -1;

        for (int i = 0; i < list.size(); i++) {
            SaveMood mood = list.get(i);

            String today = new SimpleDateFormat("yyyyMMdd").format(date);

            if (mood.getDate().equals(today)) {
                index = i;
            }
        }
        return index;
    }

    public static SaveMood getMoodForDate(Date date) {      //recupere la index du mood lier a la date sinon normal mood par default
        int index = getMoodIndexForDate(date);
        if (index != -1) {
            return getMoods().get(index);
        }
        return null;
    }

    public static int getMoodFragmentIndexForDate(Date date) {               //recupere le mood lier a la date
        SaveMood dateMood = getMoodForDate(date);
        if (dateMood == null) {
            return 5;
        } else {
            return dateMood.getMoodPosition();
        }
    }

    public static String getMoodCommentForDate(Date date) {           //recupere le commentaire lier a la date
        SaveMood dateMood = getMoodForDate(date);
        if (dateMood == null) {
            return null;
        } else {
            return dateMood.getComment();
        }
    }

    public static void changeTodayMood(SaveMood saveMood) {          // Changer l'humeur d'aujourd'hui
        SaveMood newMood = saveMood;
        int listindex = MoodPreferences.getMoodIndexForDate(new Date());

        List<SaveMood> list = MoodPreferences.getMoods();
        if (saveMood == null) {
            newMood = new SaveMood(new SimpleDateFormat("yyyyMMdd").format(new Date()),"",2);
            list.add(newMood);
        } else if (listindex == -1) {

            list.add(newMood);
        } else {
            newMood.setMoodPosition(newMood.getMoodPosition() );
            list.set(listindex, newMood);
        }

        MyApp.sharedPreferences
                .edit()
                .putString("Mood", gson.toJson(list))
                .apply();
    }
}