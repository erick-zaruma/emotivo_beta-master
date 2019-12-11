package com.google.codelabs.mdc.java.emotivo;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class IntroActivity1Fragment extends Fragment {
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Button btnGetReward;
        View view = inflater.inflate(R.layout.fragment_intro_activity1, container, false);
        if (view != null) {
            btnGetReward=view.findViewById(R.id.btn_reward);
            // disable the button
            btnGetReward.setVisibility(View.GONE);
            // Load videp
            loadVideo(view,btnGetReward);
            // Button enabled
            btnGetReward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((NavigationHost)getActivity()).navigateTo(new IntroActivity2Fragment(),false);
                }
            });
        }
        // Snippet from "Navigate to the next Fragment" section goes here.
        return view;
    }
    private void loadVideo(View view, Button btnGetReward) {
        VideoView videoView = view.findViewById(R.id.videoView);
        //Button btnGetReward = view.findViewById(R.id.btn_reward);

        MediaController mediaController = new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        Uri video = Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(video);
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            public void onCompletion(MediaPlayer mp)
            {
                // Do whatever u need to do here
                // enable button
                btnGetReward.setVisibility(View.VISIBLE);
            }
        });
    }
}
