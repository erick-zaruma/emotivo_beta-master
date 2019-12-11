package com.google.codelabs.mdc.java.emotivo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class IntroActivity2Fragment extends Fragment {
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Button btnCreateAccount;
        View view = inflater.inflate(R.layout.fragment_intro_activity2, container, false);
        if (view != null) {
            btnCreateAccount=view.findViewById(R.id.btn_create_account);
            btnCreateAccount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((NavigationHost)getActivity()).navigateTo(new AccountCreationFragment(),false);
                }
            });
        }

        return view;
    }
}
