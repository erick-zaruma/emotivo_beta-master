package com.google.codelabs.mdc.java.emotivo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.codelabs.mdc.java.emotivo.authoring.MenuFragment;
import com.google.codelabs.mdc.java.emotivo.pickmeup.PickMeUpFragment;

public class MainMenuFragment1_1 extends Fragment {
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ImageButton writingButton;
        ImageButton mindfulnessButton;
        ImageButton shopButton;
        ImageButton sunButton;
        View view = inflater.inflate(R.layout.fragment_main_menu_1_1, container, false);
        if(view!=null){
            writingButton = view.findViewById(R.id.ibWritingButton);
            writingButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   ((NavigationHost)getActivity()).navigateTo(new MenuFragment(),true);
                }
            });

            mindfulnessButton = view.findViewById(R.id.ibMindfulnessButton);
            mindfulnessButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((NavigationHost)getActivity()).navigateTo(new MindfulnessMenuFragment(),true);
                    //((NavigationHost)getActivity()).navigateTo(new AccountCreationFragment(),true);
                }
            });

            shopButton = view.findViewById(R.id.ibShopButton);
            shopButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // ((NavigationHost)getActivity()).navigateTo(new OnboardingScreen3_1Fragment(),true);
                    ((NavigationHost)getActivity()).navigateTo(new AccountCreationFragment(),true);
                }
            });

            sunButton = view.findViewById(R.id.ibSunButton);
            sunButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((NavigationHost)getActivity()).navigateTo(new PickMeUpFragment(),true);

                }
            });
        }

        return view;
    }
}
