package com.google.codelabs.mdc.java.emotivo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class Screen16Fragment extends Fragment {

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ImageButton nextButton;
        View view = inflater.inflate(R.layout.fragment_screen16, container, false);
        if(view!=null){
            nextButton = view.findViewById(R.id.nextButton_screen16);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // ((NavigationHost)getActivity()).navigateTo(new OnboardingScreen3_1Fragment(),true);
                    ((NavigationHost)getActivity()).navigateTo(new MainMenuFragment1_1(),false);
                }
            });
        }

        return view;
    }
}
