package com.google.codelabs.mdc.java.emotivo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class OnboardingScreen3Fragment extends Fragment {
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ImageView ivNextButton;

        View view = inflater.inflate(R.layout.fragment_onboarding_screen3, container, false);

        if(view!=null){
           // ImageView ivNameTag = view.findViewById(R.id.iv_name_tag);
            //ivNameTag.setImageDrawable(getResources().getDrawable(R.layout.layer_shiba_name_tag));
            ivNextButton = view.findViewById(R.id.iv_next_button);
            ivNextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((NavigationHost)getActivity()).navigateTo(new OnboardingScreen3_1Fragment(),true);
                    //((NavigationHost)getActivity()).navigateTo(new Screen15Fragment(),true);
                }
            });
        }

        return view;
    }
}
