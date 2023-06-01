package com.example.depremapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.app.Activity;


public class araFragment extends Fragment {


    public araFragment() {
        // Required empty public constructor
    }

    public static araFragment newInstance(String param1, String param2) {
        araFragment fragment = new araFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_ara, container, false);
        ImageButton acilButton =(ImageButton) view.findViewById(R.id.acilButton);
        acilButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:112"));
                startActivity(i);
            }

      });
        ImageButton afadButton =(ImageButton) view.findViewById(R.id.afadButton);
        afadButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:122"));
                startActivity(i);
            }

        });
        ImageButton forestButton =(ImageButton) view.findViewById(R.id.forestButton);
        forestButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:177"));
                startActivity(i);
            }

        });
        return view;

    }
}














