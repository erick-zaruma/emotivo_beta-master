package com.google.codelabs.mdc.java.emotivo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class IntroSlider1Fragment extends Fragment {

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        MaterialButton beginButton;
        View view = inflater.inflate(R.layout.fragment_intro_slider1, container, false);
        if(view!=null){
            beginButton=view.findViewById(R.id.btn_begin);

            beginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((NavigationHost)getActivity()).navigateTo(new IntroQuestion2Fragment(),false);
                }
            });

        }

        return view;
    }
}
