package com.macroblank.app;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WebFragment extends Fragment {

    private EditText urlInput;
    private Button loadButton;
    private ProgressBar webLoading;
    private WebView webView;

    public WebFragment() {
        super(R.layout.fragment_web);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        urlInput = view.findViewById(R.id.urlInput);
        loadButton = view.findViewById(R.id.loadButton);
        webLoading = view.findViewById(R.id.webLoading);
        webView = view.findViewById(R.id.webView);

        configureWebView();
        loadButton.setOnClickListener(v -> onLoadClick());
        urlInput.setOnEditorActionListener(this::onUrlEditorAction);
    }

    private void configureWebView() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                onPageProgress(newProgress);
            }
        });
    }

    private void onLoadClick() {
        String url = urlInput.getText().toString().trim();
        if (url.isEmpty()) {
            urlInput.setError("Ingresa una URL");
            return;
        }
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
            urlInput.setText(url);
        }
        hideKeyboard();
        webView.loadUrl(url);
    }

    private boolean onUrlEditorAction(TextView view, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_GO) {
            onLoadClick();
            return true;
        }
        return false;
    }

    private void onPageProgress(int progress) {
        webLoading.setProgress(progress);
        webLoading.setVisibility(progress < 100 ? View.VISIBLE : View.GONE);
    }

    private void hideKeyboard() {
        InputMethodManager imm =
                (InputMethodManager) requireContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(urlInput.getWindowToken(), 0);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        webView.stopLoading();
    }
}