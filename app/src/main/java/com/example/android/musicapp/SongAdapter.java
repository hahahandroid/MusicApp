package com.example.android.musicapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kate on 18/05/18.
 */
public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(Activity context, ArrayList<Song> songList) {
        super(context, 0, songList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_item, parent, false);
        }

        Song currentSong = getItem(position);

        TextView artist = listItemView.findViewById(R.id.artist);
        artist.setText(currentSong.getArtist());

        TextView song = listItemView.findViewById(R.id.song);
        song.setText(currentSong.getSong());

        TextView duration = listItemView.findViewById(R.id.duration);
        duration.setText(currentSong.getDuration());

        return listItemView;
    }
}
