package com.google.codelabs.mdc.java.emotivo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class OnboardingScreen5Fragment extends Fragment {
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ImageView ivNextButtonScreen5;
        TextView ivIntroText;
        String message1,message2;
        message1 = "...your information private and secure on your device.\n";
        message2 = "Our journey might take you through some ups and downs and really...";
        View view = inflater.inflate(R.layout.fragment_onboarding_screen5, container, false);
        if(view!=null){
            ivIntroText = view.findViewById(R.id.iv_intro_text_screen5);
            ivIntroText.setText(message1 +message2);
            // next button
            ivNextButtonScreen5 = view.findViewById(R.id.iv_next_button_screen5);
            ivNextButtonScreen5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // ((NavigationHost)getActivity()).navigateTo(new IntroSlider1Fragment(),true);
                    ((NavigationHost)getActivity()).navigateTo(new OnboardingScreen6Fragment(),true);

                }
            });
        }

        return view;
    }
}
