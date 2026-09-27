package com.macroblank.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PhotoAdapter extends ArrayAdapter<Album> {

    public PhotoAdapter(@NonNull Context context, @NonNull List<Album> albums) {
        super(context, 0, albums);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
        }

        Album album = getItem(position);
        ImageView photoCover = row.findViewById(R.id.photoCover);
        TextView photoTitle = row.findViewById(R.id.photoTitle);

        if (album != null) {
            photoCover.setImageResource(album.getCoverRes());
            photoTitle.setText(album.getTitle());
        }

        return row;
    }
}