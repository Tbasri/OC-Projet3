package com.example.moodtracker.models;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Alarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        System.out.println("okkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        Toast.makeText(context,"Enregistrement du mood par default",Toast.LENGTH_LONG).show();

    }
}
