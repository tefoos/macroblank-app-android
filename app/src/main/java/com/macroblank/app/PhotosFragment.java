package com.macroblank.app;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class PhotosFragment extends Fragment {

    private ListView photoList;
    private TextView selectedPhotoTitle;
    private TextView selectedPhotoDescription;
    private List<Album> albums;

    public PhotosFragment() {
        super(R.layout.fragment_photos);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        photoList = view.findViewById(R.id.photoList);
        selectedPhotoTitle = view.findViewById(R.id.selectedPhotoTitle);
        selectedPhotoDescription = view.findViewById(R.id.selectedPhotoDescription);

        albums = loadAlbums();
        photoList.setAdapter(new PhotoAdapter(requireContext(), albums));
        photoList.setOnItemClickListener((parent, itemView, position, id) -> onPhotoClick(albums.get(position)));
    }

    private List<Album> loadAlbums() {
        List<Album> list = new ArrayList<>();
        list.add(new Album("лучшие дни", "9 canciones. Sonido cálido y melancólico con pianos suaves y beats lentos.", R.drawable.album_1));
        list.add(new Album("美容師 COLLECTION", "12 canciones. Recopilación de barber beats con samples de jazz y soul ralentizados.", R.drawable.album_2));
        list.add(new Album("一生に一度", "7 canciones. Atmósferas nostálgicas con sintetizadores y bajos profundos.", R.drawable.album_3));
        list.add(new Album("記憶ONLINE", "8 canciones. Texturas digitales y samples de R&B con aire de internet antiguo.", R.drawable.album_4));
        list.add(new Album("能界蘭極境", "6 canciones. Sonido oscuro y envolvente con reverberación intensa.", R.drawable.album_5));
        list.add(new Album("VOID TV MIX 2", "1 mezcla continua. Sesión que enlaza varios temas en un solo recorrido sin pausas.", R.drawable.album_6));
        list.add(new Album("ODESSA", "9 canciones. Ritmos downtempo con guitarras limpias y ambiente relajado.", R.drawable.album_7));
        list.add(new Album("死のダンス", "7 canciones. Beats pesados y samples distorsionados de tono sombrío.", R.drawable.album_8));
        list.add(new Album("ファイナルロデオ", "10 canciones. Cierre enérgico con grooves funk y cortes rápidos.", R.drawable.album_9));
        return list;
    }
    private void onPhotoClick(Album album) {
        selectedPhotoTitle.setText(album.getTitle());
        selectedPhotoDescription.setText(album.getDescription());
    }
}