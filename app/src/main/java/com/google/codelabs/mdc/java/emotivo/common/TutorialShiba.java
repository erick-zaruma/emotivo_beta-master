package com.google.codelabs.mdc.java.emotivo.common;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.google.codelabs.mdc.java.emotivo.R;

import java.util.ArrayList;

public class TutorialShiba {

    private final Drawable shiba;
    private final ImageButton imageButton;
    private final TextView textView;
    private final ArrayList<String> textFields;
    private int textFieldPointer = 0;

    public TutorialShiba(Context context, RelativeLayout relativeLayout, ArrayList<String> textFields) {
        this.textFields = textFields;
        shiba = context.getResources().getDrawable(R.drawable.advisorshiba);
        imageButton = new ImageButton(context);
        imageButton.setId(View.generateViewId());
        imageButton.setBackground(shiba);
        imageButton.setLayoutParams(
                new RelativeLayout.LayoutParams(
                        ConstraintLayout.LayoutParams.WRAP_CONTENT,
                        ConstraintLayout.LayoutParams.WRAP_CONTENT
                )
        );
        RelativeLayout.LayoutParams imageButtonParams = (RelativeLayout.LayoutParams) imageButton.getLayoutParams();
        imageButtonParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        imageButtonParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);

        textView = new TextView(context);
        if (textFields.size() != 0) textView.setText(textFields.get(0));
        textView.setTextSize(16);
        textView.setLayoutParams(
                new RelativeLayout.LayoutParams(
                        ConstraintLayout.LayoutParams.WRAP_CONTENT,
                        ConstraintLayout.LayoutParams.WRAP_CONTENT
                )
        );
        RelativeLayout.LayoutParams textViewParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        textViewParams.addRule(RelativeLayout.ALIGN_TOP, imageButton.getId());
        textViewParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        textViewParams.setMargins(400, 50, 80, 0);

        imageButton.setOnClickListener((View view) -> {
            textFieldPointer += 1;
            if (textFieldPointer >= textFields.size()) {
                imageButton.setVisibility(View.GONE);
                textView.setVisibility(View.GONE);
                return;
            }
            textView.setText(textFields.get(textFieldPointer));
        });

        imageButton.setElevation(1000f);
        textView.setElevation(1000f);
        relativeLayout.addView(imageButton);
        relativeLayout.addView(textView);

    }
}
