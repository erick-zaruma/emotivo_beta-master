package com.google.codelabs.mdc.java.emotivo.authoring;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.google.codelabs.mdc.java.emotivo.NavigationHost;
import com.google.codelabs.mdc.java.emotivo.R;

import com.google.codelabs.mdc.java.emotivo.common.TutorialShiba;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuFragment extends Fragment {
    private ImageButton pastwriting;
    private ImageButton presentwriting;
    private ImageButton futurewriting;

    public static Fragment newInstance() { return new MenuFragment();
    }

    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_authoring_menu, container, false);
        if (view != null) {
            pastwriting = view.findViewById(R.id.pastwriting);
            presentwriting = view.findViewById(R.id.presentwriting);
  //          futurewriting = view.findViewById(R.id.future_intro);
            RelativeLayout root = view.findViewById(R.id.root);
            new TutorialShiba(getContext(), root, new ArrayList<>(Arrays.asList(
                    "Welcome to the self-growth module. Each of the books above is a guided" +
                            "writing exercise. Let's start with the past writing...")));
            pastwriting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((NavigationHost)getActivity()).navigateTo(new PeriodListFragment("pastWriting"),true);
                }
            });

            presentwriting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((NavigationHost)getActivity()).navigateTo(new VirtueFaultMenuFragment(),true);
                }
            });
        }
        return view;
    }
}
