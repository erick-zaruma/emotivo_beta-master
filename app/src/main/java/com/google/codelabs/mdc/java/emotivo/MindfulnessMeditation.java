package com.google.codelabs.mdc.java.emotivo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class MindfulnessMeditation extends Fragment {
    private ImageButton playButton;
    private TextView timerDisplay;
    private Button time1;
    private Button time2;
    private Button time3;
    private Button time4;
    private Button time5;
    private Button time6;
    private ScrollView scrollView;

    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mindfulness_meditation, container, false);
        if (view != null) {
            RelativeLayout root = view.findViewById(R.id.root);
            //playButton = view.findViewById(R.id.playButton);
            scrollView = view.findViewById(R.id.scrollView);
            timerDisplay = view.findViewById(R.id.timerDisplay);
            time1 = view.findViewById(R.id.time1);
            time2 = view.findViewById(R.id.time2);
            time3 = view.findViewById(R.id.time3);
            time4 = view.findViewById(R.id.time4);
            time5 = view.findViewById(R.id.time5);
            time6 = view.findViewById(R.id.time6);

            time1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    timerDisplay.setText("1:00");
                }
            });

            time2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    timerDisplay.setText("2:00");
                }
            });

            time3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    timerDisplay.setText("5:00");
                }
            });

            time4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    timerDisplay.setText("10:00");
                }
            });

            time5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    timerDisplay.setText("15:00");
                }
            });

            time6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    timerDisplay.setText("30:00");
                }
            });
        }
        return view;
    }
}
