package com.example.moodtracker.models;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.moodtracker.utils.MoodPreferences;


public class Alarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        MoodPreferences.changeTodayMood(null);

    }

}
