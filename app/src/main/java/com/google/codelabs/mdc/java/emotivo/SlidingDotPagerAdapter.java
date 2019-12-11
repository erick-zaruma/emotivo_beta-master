package com.google.codelabs.mdc.java.emotivo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class SlidingDotPagerAdapter extends FragmentStatePagerAdapter {

    public SlidingDotPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new DemoObjectFragment();
        Bundle args = new Bundle();
        // Our object is just an integer :-P
        args.putInt("obj",position+1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }

    public static class DemoObjectFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_sliding_dot, container, false);
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            Bundle args = getArguments();
            Integer pos = args.getInt("obj");

            if(pos == 1){
                ImageView iv_view = view.findViewById(R.id.iv_sliding_dot);
                iv_view.setImageResource(R.drawable.alphascreen10);
            } else if(pos ==2){
                ImageView iv_view = view.findViewById(R.id.iv_sliding_dot);
                iv_view.setImageResource(R.drawable.alphascreen11);
            } else if(pos ==3){
                ImageView iv_view = view.findViewById(R.id.iv_sliding_dot);
                iv_view.setImageResource(R.drawable.alphascreen12);
            }else if(pos ==4){
                ImageView iv_view = view.findViewById(R.id.iv_sliding_dot);
                iv_view.setImageResource(R.drawable.alphascreen13);
            } else if(pos ==5){
                ImageView iv_view = view.findViewById(R.id.iv_sliding_dot);
                iv_view.setImageResource(R.drawable.alphascreen14);
                iv_view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // ((NavigationHost)getActivity()).navigateTo(new IntroSlider1Fragment(),true);
                        //System.out.println("Heloo");
                        ((NavigationHost)getActivity()).navigateTo(new Screen15Fragment(),true);

                    }
                });
            }


        }
    }
}
