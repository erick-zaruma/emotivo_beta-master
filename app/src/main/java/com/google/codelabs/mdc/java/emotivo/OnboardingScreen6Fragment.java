package com.google.codelabs.mdc.java.emotivo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class OnboardingScreen6Fragment extends Fragment {
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ImageView ivNextButtonScreen6;
        TextView ivIntroText;
        String message1,message2;
        message1 = "...make you think hard. It's okay to be a little scared.\n";
        message2 = "However, you will learn much about yourself and grow as a person.";
        View view = inflater.inflate(R.layout.fragment_onboarding_screen6, container, false);
        if(view!=null){
            ivIntroText = view.findViewById(R.id.iv_intro_text_screen6);
            ivIntroText.setText(message1 +message2);
            // next button
            ivNextButtonScreen6 = view.findViewById(R.id.iv_next_button_screen6);
            ivNextButtonScreen6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // ((NavigationHost)getActivity()).navigateTo(new IntroSlider1Fragment(),true);
                    ((NavigationHost)getActivity()).navigateTo(new OnboardingScreen7Fragment(),true);

                }
            });
        }

        return view;
    }
}
