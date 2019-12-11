package com.google.codelabs.mdc.java.emotivo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class OnboardingScreen4Fragment extends Fragment {

    public static Fragment newScreen4Instance() {
        return  new OnboardingScreen4Fragment();
    }

    String message;
    public void displayReceivedData(String msg) {
        this.message = msg;
    }

    public void StorePreferences(String name){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Name",name);
        editor.apply();
    }
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ImageView ivNextButtonScreen4;
        TextView ivIntroText;
        String message1,message2;
        message1 = "Nice to meet you ";
        message2 = "! \n I'm excited to start our journey together. Before we start I want you to " +
                "know that I keep all..";
        View view = inflater.inflate(R.layout.fragment_onboarding_screen4, container, false);
        if(view!=null){
            ivIntroText = view.findViewById(R.id.iv_intro_text);
            ivIntroText.setText(message1+ message +message2);
            // next button
            ivNextButtonScreen4 = view.findViewById(R.id.iv_next_button_screen4);
            ivNextButtonScreen4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    StorePreferences(message);
                    // ((NavigationHost)getActivity()).navigateTo(new IntroSlider1Fragment(),true);
                    ((NavigationHost)getActivity()).navigateTo(new OnboardingScreen5Fragment(),true);

                }
            });
        }

        return view;
    }
}
