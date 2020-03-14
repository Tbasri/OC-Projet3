package com.example.moodtracker.models;

public class SaveMood {

    private String date;
    private String comment;
    private int moodPosition;

    //Constructeur


    public SaveMood(String date, String comment, int moodPosition) {
        this.date = date;
        this.comment = comment;
        this.moodPosition = moodPosition;

        //this.colorIndex = colorIndex;
    }

    public String getDate() {
        return date;
    }

    public String getComment() {
        return (comment);
    }

    public int getMoodPosition() {
        return moodPosition;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setComment(String comment) { this.comment = comment;}

    public void setMoodPosition(int moodPosition) { this.moodPosition = moodPosition; }
}

// setdate et set comment a coder et mood position
// comprendre la fonctionnaliter de colorIndex pk?
//}

