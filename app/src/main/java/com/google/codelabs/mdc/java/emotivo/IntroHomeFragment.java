package com.google.codelabs.mdc.java.emotivo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class IntroHomeFragment extends Fragment {
    ImageView mascotHappyImageView;
    public IntroHomeFragment(){

    }

    public static Fragment newInstance() {
        return new IntroHomeFragment();
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_intro_home, container, false);

        // Snippet from "Navigate to the next Fragment" section goes here.
        if(view!=null){
            mascotHappyImageView = view.findViewById(R.id.iv_intro_screen);
        }
        return view;
    }
}
