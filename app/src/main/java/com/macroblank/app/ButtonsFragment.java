package com.macroblank.app;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ButtonsFragment extends Fragment {

    private static final String BANDCAMP_URL = "https://barbercut.bandcamp.com";
    private static final String INSTAGRAM_URL = "https://www.instagram.com/macroblankmusic/";

    private Button bandcampButton;
    private Button instagramButton;

    public ButtonsFragment() {
        super(R.layout.fragment_buttons);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bandcampButton = view.findViewById(R.id.bandcampButton);
        instagramButton = view.findViewById(R.id.instagramButton);

        bandcampButton.setOnClickListener(v -> onBandcampClick());
        instagramButton.setOnClickListener(v -> onInstagramClick());
    }

    private void onBandcampClick() {
        openUrl(BANDCAMP_URL);
    }

    private void onInstagramClick() {
        openUrl(INSTAGRAM_URL);
    }

    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(requireContext(), "No hay una aplicación para abrir el enlace", Toast.LENGTH_SHORT).show();
        }
    }
}