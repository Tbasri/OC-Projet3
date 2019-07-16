package com.example.moodtracker.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.moodtracker.R;

public class MoodFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    private int mPosition;


    public MoodFragment() {
        // Required empty public constructor
    }

    public static MoodFragment newInstance(int position) {
        MoodFragment fragment = new MoodFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(ARG_PARAM1);
        }
    }

    private int getLayout() {
        switch (mPosition) {
            case 0:
                return R.layout.very_sad_mood;
            case 1:
                return R.layout.sad_mood;
            case 2:
                return R.layout.normal_mood;
            case 3:
                return R.layout.good_mood;
            case 4:
                return R.layout.very_good_mood;
            default:
                return R.layout.normal_mood;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(getLayout(), container, false);
    }

}
