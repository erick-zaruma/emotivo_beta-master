package com.google.codelabs.mdc.java.emotivo.authoring;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.google.codelabs.mdc.java.emotivo.R;

public class Banner extends View {

    private final Drawable logo;

    public Banner(Context context) {
        super(context);
        logo = context.getResources().getDrawable(R.drawable.rewardscreen);
        setBackgroundDrawable(logo);
    }

    public Banner(Context context, AttributeSet attrs) {
        super(context, attrs);
        logo = context.getResources().getDrawable(R.drawable.rewardscreen);
        setBackgroundDrawable(logo);
    }

    public Banner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        logo = context.getResources().getDrawable(R.drawable.rewardscreen);
        setBackgroundDrawable(logo);
    }

    @Override protected void onMeasure(int widthMeasureSpec,
                                       int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = width * logo.getIntrinsicHeight() / logo.getIntrinsicWidth();
        setMeasuredDimension(width, height);
    }
}