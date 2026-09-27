package com.macroblank.app;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private ScrollView profileScroll;
    private ImageView artistPhoto;
    private TextView artistName;
    private TextView artistGenre;
    private TextView artistBio;
    private TextView artistCareer;

    public ProfileFragment() {
        super(R.layout.fragment_profile);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        profileScroll = view.findViewById(R.id.profileScroll);
        artistPhoto = view.findViewById(R.id.artistPhoto);
        artistName = view.findViewById(R.id.artistName);
        artistGenre = view.findViewById(R.id.artistGenre);
        artistBio = view.findViewById(R.id.artistBio);
        artistCareer = view.findViewById(R.id.artistCareer);
    }
}