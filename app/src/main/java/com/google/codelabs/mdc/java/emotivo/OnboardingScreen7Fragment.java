package com.google.codelabs.mdc.java.emotivo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.codelabs.mdc.java.emotivo.utils.DataHolder;

public class OnboardingScreen7Fragment extends Fragment {
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ImageView ivNextButtonScreen7;
        TextView ivIntroText;
        String message1,message2;
        String name;

        name = DataHolder.getData();
        message1 = name+",are you ready to continue? I know you are!\n";
        message2 = "Can I send you updates and reminders of your progress via email?";
        View view = inflater.inflate(R.layout.fragment_onboarding_screen7, container, false);
        if(view!=null){
            ivIntroText = view.findViewById(R.id.iv_intro_text_screen7);
            ivIntroText.setText(message1 + message2);
            // next button
            ivNextButtonScreen7 = view.findViewById(R.id.iv_next_button_screen7);
            ivNextButtonScreen7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // ((NavigationHost)getActivity()).navigateTo(new IntroSlider1Fragment(),true);
                    ((NavigationHost)getActivity()).navigateTo(new OnboardingScreen8Fragment(),true);

                }
            });
        }

        return view;
    }
}
