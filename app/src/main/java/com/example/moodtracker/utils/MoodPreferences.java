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

//fonction des enregistrer
public class MoodPreferences {

    static Gson gson = new Gson();

    // recupere la list de save mood sauvegarder dans le telephone
    public static List<SaveMood> getMoods() {
        SharedPreferences sharedPreferences = MyApp.sharedPreferences;

        String json = sharedPreferences.getString("Mood", null);

        List<SaveMood> saveMood = new ArrayList<>();

        if (json != null) {
            saveMood = gson.fromJson(json, new TypeToken<List<SaveMood>>() {
            }.getType());
        }

        //  public static String getMoodIndexForComment(Comment comment) {

        //     String json = sharedPreferences.getString();

        //     List<SaveMood> saveMood = new ArrayList<>();

        //       if (json != null) {
        //          saveMood = gson.fromJson(json, new TypeToken<List<SaveMood>>() {
        //         }.getType());
        //      }


        return saveMood;
    }

    // recupere l'index du mood lier date grace a une boucle
    public static int getMoodIndexForDate(Date date) {
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

    //recupere la index du mood lier a la date sinon normalmood par default
    public static SaveMood getMoodForDate(Date date) {
        int index = getMoodIndexForDate(date);
        if (index != -1) {
            return getMoods().get(index);
        }

        return null;
    }

    //recupere le mood lier a la date
    public static int getMoodFragmentIndexForDate(Date date) {
        SaveMood dateMood = getMoodForDate(date);
        if (dateMood == null) {
            return 2;
        } else {
            return dateMood.getFragmentIndex();
        }
    }

    //recupere le commentaire lier a la date
    public static String getMoodCommentForDate(Date date) {
        SaveMood dateMood = getMoodForDate(date);
        if (dateMood == null) {
            return "";
        } else {
            return dateMood.getComment();
        }
    }

    // Changer l'humeur d'aujourd'hui
    public static void changeTodayMood(SaveMood saveMood) {
        SaveMood newMood = saveMood;
        int listindex = MoodPreferences.getMoodIndexForDate(new Date());

        List<SaveMood> list = MoodPreferences.getMoods();
        if (saveMood == null) {
            newMood = new SaveMood(new SimpleDateFormat("yyyyMMdd").format(new Date()), 2, "");
            list.add(newMood);
        } else if (listindex == -1) {

            list.add(newMood);
        } else {
            newMood.setFragmentIndex(newMood.getFragmentIndex() - 1);
            list.set(listindex, newMood);
        }

        MyApp.sharedPreferences
                .edit()
                .putString("Mood", gson.toJson(list))
                .apply();
    }
    // cree une methode public static pour donnée les jours ecouler entre aujourdhuit et la date du mood


    //permet de calculer le nombre de jours écoulés entre 2 date.
    //date2 doit être postérieur à date1
    public static long getDiffDays(Date date1, Date date2) {
        long diffMilliseconds = date2.getTime() - date1.getTime();
        return TimeUnit.DAYS.convert(diffMilliseconds, TimeUnit.MILLISECONDS);
    }

}

