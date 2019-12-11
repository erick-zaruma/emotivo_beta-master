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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.codelabs.mdc.java.emotivo.NavigationHost;
import com.google.codelabs.mdc.java.emotivo.R;
import com.google.codelabs.mdc.java.emotivo.common.TutorialShiba;

import java.util.ArrayList;
import java.util.Arrays;

public class MemoryListFragment extends Fragment {
    private final int NUM_MEMORIES = 6;
    private RelativeLayout layout;
    private String pathName;
    RelativeLayout.LayoutParams PARAMS;
    public MemoryListFragment(String pathName) {
        this.pathName = pathName;
        PARAMS = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

    }

    private String getButtonName(int buttonNumber) {
        String name = "Memory " + Integer.toString(buttonNumber);
        //pull from db
        return name;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_authoring_memory_list, container, false);
        if (view == null) {
            return null;
        }
        ((TextView)view.findViewById(R.id.pastwritingtitle)).setText(pathName.split("/")[1]);
        layout = view.findViewById(R.id.root);
        int prevId = R.id.authorheader3;
        for (int i = 1; i <= NUM_MEMORIES; i++) {
            final Button btn = new Button(getContext());
            String btnName = getButtonName(i);
            int currId = View.generateViewId();

            btn.setText(btnName);
            btn.setId(currId);
            btn.setBackgroundColor(Color.parseColor("#F5F0BF"));
            btn.setLayoutParams(new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    200));
            RelativeLayout.LayoutParams params = ((RelativeLayout.LayoutParams)btn.getLayoutParams());
            params.addRule(RelativeLayout.BELOW, prevId);
            params.setMargins(0,10,0,0);
            btn.setOnClickListener((View view1) -> {
                ((NavigationHost)getActivity()).navigateTo(new MemoryWritingFragment(pathName+"/"+btnName),true);
            });

            prevId = currId;
            layout.addView(btn);
        }

        new TutorialShiba(getContext(), layout, new ArrayList<>(Arrays.asList("Now within your epoch you can begin to write" +
                "stories from that time. Try to think about things you might still think about today. Anything that brings up" +
                " an emotion")));
        return view;
    }
}
