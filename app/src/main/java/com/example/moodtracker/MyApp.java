package com.example.moodtracker;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.facebook.stetho.Stetho;

public class MyApp extends Application {

    public static SharedPreferences sharedPreferences;

    // Appelé au lancement de l'application
    public void onCreate() {
        super.onCreate();
        MyApp.sharedPreferences = getSharedPreferences("PREFS", Context.MODE_PRIVATE);
        Stetho.initializeWithDefaults(this);
    }
}