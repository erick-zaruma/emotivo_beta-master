package com.google.codelabs.mdc.java.emotivo.authoring;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.codelabs.mdc.java.emotivo.NavigationHost;
import com.google.codelabs.mdc.java.emotivo.R;

public class VirtueFaultMenuFragment extends Fragment {
    private ImageButton VirtueButton;
    private ImageButton FaultButton;
    private ImageButton BackButton;

    public static Fragment newInstance() { return new VirtueFaultMenuFragment();
    }

    public View onCreateView(
                @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_virtue_fault_menu, container, false);
            if (view != null) {
            VirtueButton = view.findViewById(R.id.VirtueButton);
            FaultButton = view.findViewById(R.id.FaultButton);
            BackButton = view.findViewById(R.id.BackButton);

            RelativeLayout root = view.findViewById(R.id.root);

            VirtueButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((NavigationHost)getActivity()).navigateTo(new VirtueListFragment("virtueWriting"),true);
                }
            });

            FaultButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((NavigationHost)getActivity()).navigateTo(new FaultListFragment("faultWriting"),true);
                }
            });

            BackButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((NavigationHost)getActivity()).navigateTo(new MenuFragment(),true);
                }
            });
        }
        return view;
    }
}
