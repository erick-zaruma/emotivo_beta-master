package com.google.codelabs.mdc.java.emotivo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class IntroQuestion1Fragment extends Fragment {
    //ImageView mascotHappyImageView;
   // ImageView mascotSadImageView;

    public IntroQuestion1Fragment(){

    }

    public static Fragment newInstance() {
        return  new IntroQuestion1Fragment();
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         /*
                Check if name is already stored then directly launch Main Menu
             */
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String name = preferences.getString("Name", "");
        if(name.equalsIgnoreCase("")) {
            //System.out.println("No matching name found");
            //StorePreferences();
        } else{ // name found
            ((NavigationHost)getActivity()).navigateTo(new MainMenuFragment1_1(),false);
        }


        // Inflate the layout for this fragment
        MaterialButton submitButton;
        View view = inflater.inflate(R.layout.fragment_intro_question1, container, false);
        if(view!=null){


            submitButton=view.findViewById(R.id.btn_submit);

            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // ((NavigationHost)getActivity()).navigateTo(new IntroSlider1Fragment(),true);
                    ((NavigationHost)getActivity()).navigateTo(new OnboardingScreen3Fragment(),true);
                }
            });
        }
        // Snippet from "Navigate to the next Fragment" section goes here.

        return view;
    }
}
