package com.macroblank.app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements OnMenuItemSelectedListener {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {
            replaceFragment(new ProfileFragment());
        }
    }

    @Override
    public void onMenuItemSelected(String option) {
        switch (option) {
            case "Profile":
                replaceFragment(new ProfileFragment());
                break;
            case "Photos":
                replaceFragment(new PhotosFragment());
                break;
        }
    }

    public void replaceFragment(Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.contentContainer, fragment)
                .commit();
    }
}