package com.macroblank.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment {

    private static final String[] OPTIONS = {"Profile", "Photos", "Video", "Web", "Buttons"};
    private static final String[] LABELS = {"Perfil", "Fotos", "Video", "Web", "Botones"};

    private OnMenuItemSelectedListener listener;
    private ListView menuList;

    public MenuFragment() {
        super(R.layout.fragment_menu);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnMenuItemSelectedListener) {
            listener = (OnMenuItemSelectedListener) context;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        menuList = view.findViewById(R.id.menuList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_list_item_activated_1,
                LABELS
        );
        menuList.setAdapter(adapter);
        menuList.setItemChecked(0, true);
        menuList.setOnItemClickListener((parent, itemView, position, id) -> onOptionClick(OPTIONS[position]));
    }

    private void onOptionClick(String option) {
        if (listener != null) {
            listener.onMenuItemSelected(option);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}