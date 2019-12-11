package com.google.codelabs.mdc.java.emotivo.authoring;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.codelabs.mdc.java.emotivo.NavigationHost;
import com.google.codelabs.mdc.java.emotivo.R;
import com.google.codelabs.mdc.java.emotivo.common.TutorialShiba;

import java.util.ArrayList;
import java.util.Arrays;

public class VirtueListFragment extends Fragment {
    private final int NUM_EPOCHS = 6;
    private RelativeLayout layout;
    private String pathName;
    public VirtueListFragment(String pathName) {
        // make sure periodNameList and memoryNamePerPeriod list are the same size otherwise code will crash
        this.pathName = pathName;
    }

    private String getButtonName(int buttonNumber) {
        String name = "VIRTUE " + Integer.toString(buttonNumber);
        //pull from db
        return name;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_virtue_list, container, false);
        if (view == null) {
            return null;
        }

        layout = view.findViewById(R.id.root);
        int prevId = R.id.authorHeader2;
        for (int i = 1; i <= NUM_EPOCHS; i++) {
            //Add buttons for each memory fragment
            final Button btn = new Button(getContext());
            String btnName = getButtonName(i);
            int currId = View.generateViewId();

            btn.setText(btnName);
            btn.setId(currId);
            btn.setBackgroundColor(Color.parseColor("#F5F0BF"));
            btn.setLayoutParams(new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    200));
            RelativeLayout.LayoutParams params = ((RelativeLayout.LayoutParams) btn.getLayoutParams());
            params.addRule(RelativeLayout.BELOW, prevId);
            params.setMargins(0, 10, 0, 0);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((NavigationHost) getActivity()).navigateTo(new MemoryListFragment(pathName + "/" + btnName), true);
                }
            });

            prevId = currId;
            layout.addView(btn);
        }
        return view;
    }
}
