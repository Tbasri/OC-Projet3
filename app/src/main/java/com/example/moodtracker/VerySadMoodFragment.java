package com.example.moodtracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class VerySadMoodFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentview = inflater.inflate(R.layout.very_sad_mood, container, false);

        fragmentview.findViewById(R.id.imageView);


        return fragmentview;
    }

    public int getY() {
        return 0;
    }

    public boolean getX() {
        return false;
    }

}
