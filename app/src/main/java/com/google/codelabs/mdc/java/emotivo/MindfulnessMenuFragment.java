package com.google.codelabs.mdc.java.emotivo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class MindfulnessMenuFragment extends Fragment {
    private ImageButton practiceButton;
    private ImageButton discoverButton;

    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mindfulness_menu, container, false);
        if (view != null) {
            RelativeLayout root = view.findViewById(R.id.root);
            practiceButton = view.findViewById(R.id.practiceButton);
            discoverButton = view.findViewById(R.id.discoverButton);

            practiceButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   ((NavigationHost)getActivity()).navigateTo(new MindfulnessMeditation(),true);
                }
            });

            discoverButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                //    ((NavigationHost)getActivity()).navigateTo(new ,true);
                }
            });
        }
        return view;
    }
}
