package com.google.codelabs.mdc.java.emotivo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;


public class IntroQuestion2Fragment extends Fragment {
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MaterialButton submitButton;
        View view = inflater.inflate(R.layout.fragment_intro_question2, container, false);
        if (view != null) {
            submitButton=view.findViewById(R.id.btn_submit);

            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((NavigationHost)getActivity()).navigateTo(new IntroActivity1Fragment(),false);
                }
            });
        }
        // Snippet from "Navigate to the next Fragment" section goes here.
        return view;
    }
}
