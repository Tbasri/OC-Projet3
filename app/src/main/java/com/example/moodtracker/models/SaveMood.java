package com.example.moodtracker.models;

public class SaveMood {

    public String date;
    public int fragmentIndex;
    public String comment;

    //Constructeur

    public SaveMood(String date, int fragmentIndex, String comment) {
        this.date = date;
        this.fragmentIndex = fragmentIndex;
        this.comment = comment;
    }}

