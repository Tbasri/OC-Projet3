package com.example.moodtracker.models;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.moodtracker.utils.MoodPreferences;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Alarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        int listindex = MoodPreferences.getMoodIndexForDate(new Date());

       if (listindex < 0){
        MoodPreferences.changeTodayMood(new SaveMood(new SimpleDateFormat("yyyyMMdd").format(new Date()), null, 2));
    }

}}

