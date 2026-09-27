package com.macroblank.app;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class VideoFragment extends Fragment {

    private static final String VIDEO_URL =
            "https://upload.wikimedia.org/wikipedia/commons/2/2e/100-_Free_80s_Drum_Samples_for_Vaporwave.webm";

    private FrameLayout videoFrame;
    private VideoView videoPlayer;
    private ProgressBar videoLoading;
    private TextView videoDescription;
    private MediaController mediaController;

    public VideoFragment() {
        super(R.layout.fragment_video);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        videoFrame = view.findViewById(R.id.videoFrame);
        videoPlayer = view.findViewById(R.id.videoPlayer);
        videoLoading = view.findViewById(R.id.videoLoading);
        videoDescription = view.findViewById(R.id.videoDescription);

        mediaController = new MediaController(requireContext());
        mediaController.setAnchorView(videoFrame);
        videoPlayer.setMediaController(mediaController);

        videoPlayer.setOnPreparedListener(this::onVideoPrepared);
        videoPlayer.setOnErrorListener(this::onVideoError);
        videoPlayer.setVideoURI(Uri.parse(VIDEO_URL));
    }

    private void onVideoPrepared(MediaPlayer player) {
        videoLoading.setVisibility(View.GONE);
        videoPlayer.start();
        mediaController.show();
    }

    private boolean onVideoError(MediaPlayer player, int what, int extra) {
        videoLoading.setVisibility(View.GONE);
        videoDescription.setText("No fue posible cargar el video. Verifica la conexión a internet.");
        return true;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (videoPlayer.isPlaying()) {
            videoPlayer.pause();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        videoPlayer.stopPlayback();
    }
}