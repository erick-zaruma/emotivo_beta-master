package com.google.codelabs.mdc.java.emotivo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class OnboardingScreen9Fragment extends Fragment {
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        MaterialButton materialButton;
        View view = inflater.inflate(R.layout.fragment_onboarding_screen9, container, false);
        if(view!=null){
            materialButton = view.findViewById(R.id.btn_continue_screen9);
            materialButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ((NavigationHost)getActivity()).navigateTo(new OnboardingScreen10Fragment(),true);

                }
            });
        }

        return view;
    }
}
