package com.google.codelabs.mdc.java.emotivo.pickmeup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.codelabs.mdc.java.emotivo.MainMenuFragment1_1;
import com.google.codelabs.mdc.java.emotivo.NavigationHost;
import com.google.codelabs.mdc.java.emotivo.R;
import com.google.codelabs.mdc.java.emotivo.authoring.PeriodListFragment;
import com.google.codelabs.mdc.java.emotivo.common.TutorialShiba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MotivationalQuoteFragment extends Fragment {
    private ImageButton pmu_backbutton;
    private ImageButton meh_button;
    private ImageButton happy_button;
    private ImageButton wonder_button;
    private ImageButton reflection_button;
    private ImageButton cont_button;
    private TextView gen_quote;
    private ArrayList<String> quotes;

    public static Fragment newInstance() {
        return new MotivationalQuoteFragment();
    }

    public void fillQuotes() {
        quotes = new ArrayList<>();
        quotes.add("\"Tough times don't last, tough people do\"");
        quotes.add("\"Motivation is the art of getting people what you want them to do because they want to do it.\" -Dwight D. Eisenhower");
        quotes.add("\"Only I can change my life. No one can do it for me.\" -Carol Burnett");
        quotes.add("\"It does not matter how slowly you go, so long as you do not stop.\" -Confucius");
        quotes.add("\"You are not here merely to make a living. You are here in order to enable the world to live more amply" +
                    ", with greater vision, with a finer spirit of hope and achievement. You are here to enrich the world, " +
                    "and you impoverish yourself if you forget the errand\" - Woodrow Wislon");
        quotes.add("“The sun is a daily reminder that we too can rise again from the darkness, that we too can shine our own light.”  -Sara Ajna");
        quotes.add("\"Once you choose hope, anything is possible.\" — Christopher Reeve");
        quotes.add("“Just when the caterpillar thought the world was ending, he turned into a butterfly.” –Proverb");
        quotes.add("“The pessimist sees difficulty in every opportunity. The optimist sees opportunity in every difficulty.” – Winston Churchill");
        quotes.add("“Life is 10% what happens to you and 90% how you react to it.” - Charles R. Swindoll");
        quotes.add("“When I let go of what I am, I become what I might be.” — Lao Tzu");
    }

    public void generateQuote() {
        Random random = new Random();
        int quotesIndex = random.nextInt(quotes.size());
        String quote = quotes.get(quotesIndex);

        gen_quote.setText(quote);
    }

    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pmu_motivational_quotes, container, false);
        if (view != null) {
            cont_button = view.findViewById(R.id.cont_button);
            meh_button = view.findViewById(R.id.meh_button);
            happy_button = view.findViewById(R.id.happy_button);
            wonder_button = view.findViewById(R.id.wonder_button);
            reflection_button = view.findViewById(R.id.reflection_button);
            pmu_backbutton = view.findViewById(R.id.pmu_backbutton);
            gen_quote = view.findViewById(R.id.gen_quote);
/*
            RelativeLayout root = view.findViewById(R.id.root);
            new TutorialShiba(getContext(), root, new ArrayList<>(Arrays.asList(
                    "Welcome to the self-growth module. Each of the books above is a guided" +
                            "writing exercise. Let's start with the past writing...")));
   */
            fillQuotes();
            generateQuote();

            cont_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((NavigationHost)getActivity()).navigateTo(new MainMenuFragment1_1(),true);
                }
            });

            pmu_backbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((NavigationHost)getActivity()).navigateTo(new MainMenuFragment1_1(),true);
                }
            });

            meh_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    meh_button.setImageResource(R.drawable.mehbuttonclicked);
                    happy_button.setImageResource(R.drawable.happybutton);
                    wonder_button.setImageResource(R.drawable.surprisedbutton);
                }
            });

            happy_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    happy_button.setImageResource(R.drawable.happybuttonclicked);
                    meh_button.setImageResource(R.drawable.mehbutton);
                    wonder_button.setImageResource(R.drawable.surprisedbutton);
                }
            });

            wonder_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    wonder_button.setImageResource(R.drawable.surprisedbuttonclicked);
                    meh_button.setImageResource(R.drawable.mehbutton);
                    happy_button.setImageResource(R.drawable.happybutton);
                }
            });

        }
        return view;
    }
}
