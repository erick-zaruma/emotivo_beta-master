package com.google.codelabs.mdc.java.emotivo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.codelabs.mdc.java.emotivo.utils.DataHolder;

import static com.google.codelabs.mdc.java.emotivo.MainActivity.screen4Fragment;

public class OnboardingScreen3_1Fragment extends Fragment {
    SendNameListener callback;

    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            callback = (SendNameListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        MaterialButton materialButtonContinue;
        TextInputEditText textInputEditText;

        View view = inflater.inflate(R.layout.fragment_onboarding_screen3_1, container, false);
        if(view!=null){
            materialButtonContinue = view.findViewById(R.id.btn_continue);
            textInputEditText = view.findViewById(R.id.et_name);

            materialButtonContinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // ((NavigationHost)getActivity()).navigateTo(new IntroSlider1Fragment(),true);
                    String name = new String(textInputEditText.getText().toString().trim());
                    DataHolder.setData(name);
                    callback.sendData(name);
                    ((NavigationHost)getActivity()).navigateTo(screen4Fragment,true);

                }
            });

        }

        return view;
    }
}
