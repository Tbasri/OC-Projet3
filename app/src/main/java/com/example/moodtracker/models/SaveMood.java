package com.example.moodtracker.models;

public class SaveMood {

    private String date;
    private int fragmentIndex;
    private String comment;
    private int moodPosition;

    //Constructeur

    public SaveMood(String date, int fragmentIndex, String comment) {
        this.date = date;
        this.fragmentIndex = fragmentIndex;
        this.comment = comment;
    //    this.colorIndex = colorIndex;
    }

    public String getDate() {
        return date;
    }

    public int getFragmentIndex() {
        return fragmentIndex;
    }

    public String getComment() {
        return comment;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFragmentIndex(int fragmentIndex) {
        this.fragmentIndex = fragmentIndex;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    //public void colorIndex(){
    //    return colorIndex ;
    }
//}

