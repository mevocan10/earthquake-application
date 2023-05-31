package com.example.depremapp;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class sesFragment extends Fragment {
    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;

    public sesFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ses, container, false);
        ImageButton dudukButton = view.findViewById(R.id.duduk);
        dudukButton.setOnClickListener(v -> {
            if (isPlaying) {
                mediaPlayer.stop();
                mediaPlayer.reset();
                dudukButton.setImageResource(R.drawable.maviduduk);
            } else {
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.duduk);
                mediaPlayer.start();
                mediaPlayer.setLooping(true);
                dudukButton.setImageResource(R.drawable.maviduduk2);
            }
            isPlaying = !isPlaying;
        });
        return view;
    }
    @Override
    public void onDestroy() {
        if (isPlaying) {
            mediaPlayer.stop();
            mediaPlayer.reset();
        }
        super.onDestroy();
    }
}