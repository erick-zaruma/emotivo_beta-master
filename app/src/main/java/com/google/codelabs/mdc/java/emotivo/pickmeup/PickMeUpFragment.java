package com.google.codelabs.mdc.java.emotivo.pickmeup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.codelabs.mdc.java.emotivo.MainMenuFragment1_1;
import com.google.codelabs.mdc.java.emotivo.NavigationHost;
import com.google.codelabs.mdc.java.emotivo.R;
import com.google.codelabs.mdc.java.emotivo.authoring.PeriodListFragment;
import com.google.codelabs.mdc.java.emotivo.common.TutorialShiba;

import java.util.ArrayList;
import java.util.Arrays;

public class PickMeUpFragment extends Fragment {
    private ImageButton pmu_backbutton;
    private ImageButton mot_button;
    private ImageButton powerButton;

    public static Fragment newInstance() { return new PickMeUpFragment();
    }

    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pmu_motivational, container, false);
        if (view != null) {
            mot_button = view.findViewById(R.id.mot_button);
            //pmu_backbutton = view.findViewById(R.id.pmu_backbutton);
            //          powerButton = view.findViewById(R.id.future_intro);
    /*        RelativeLayout root = view.findViewById(R.id.root);
            new TutorialShiba(getContext(), root, new ArrayList<>(Arrays.asList(
                    "Welcome to the self-growth module. Each of the books above is a guided" +
                            "writing exercise. Let's start with the past writing...")));
           */
            mot_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((NavigationHost)getActivity()).navigateTo(new MotivationalQuoteFragment(),true);
                }
            });
         /*   pmu_backbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((NavigationHost)getActivity()).navigateTo(new MainMenuFragment1_1(),true);
                }
            }); */

        }
        return view;
    }
}
