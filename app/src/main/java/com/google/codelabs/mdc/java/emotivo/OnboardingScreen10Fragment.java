package com.google.codelabs.mdc.java.emotivo;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

public class OnboardingScreen10Fragment extends Fragment {
    SlidingDotPagerAdapter slidingDotPagerAdapter;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_onboarding_screen10, container, false);
        if(view!=null){
            ViewPager mImageViewPager = view.findViewById(R.id.pager);
            slidingDotPagerAdapter = new SlidingDotPagerAdapter(getChildFragmentManager());
            mImageViewPager.setAdapter(slidingDotPagerAdapter);
            TabLayout tabLayout = view.findViewById(R.id.tabDots);
            tabLayout.setupWithViewPager(mImageViewPager, true);
        }

        return view;
    }
}
