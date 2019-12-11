package com.google.codelabs.mdc.java.emotivo.authoring;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.codelabs.mdc.java.emotivo.R;

public class RewardPageFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_authoring_reward_page, container, false);
        if (view == null) {
            return null;
        }
        RelativeLayout root = view.findViewById(R.id.root);
        Banner background = new Banner(getContext());
        background.setZ(-1);
        root.addView(background);
        return view;
    }
}
