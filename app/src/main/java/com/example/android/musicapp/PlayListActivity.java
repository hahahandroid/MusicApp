package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class PlayListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);

        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Michael Jackson", "Billie Jean", "5:12"));
        songs.add(new Song("Madonna", "Like a Prayer", "5:42"));
        songs.add(new Song("Britney Spears", "Baby One More Time", "3:56"));
        songs.add(new Song("Adele", "Rolling in the Deep", "3:53"));
        songs.add(new Song("Journey", "Don’t Stop Believing", "4:11"));
        songs.add(new Song("Beyoncé", "Single Ladies (Put a Ring on It)", "3:13"));
        songs.add(new Song("Justin Bieber", "Sorry", "3:20"));
        songs.add(new Song("Whitney Houston", "I Wanna Dance With Somebody", "4:51"));

        ArrayAdapter<Song> itemsAdapter = new SongAdapter(this, songs);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mainActivityIntent = new Intent(PlayListActivity.this, MainActivity.class);

                Song song = (Song) parent.getAdapter().getItem(position);
                mainActivityIntent.putExtra("artist", song.getArtist());
                mainActivityIntent.putExtra("song", song.getSong());

                startActivity(mainActivityIntent);
            }
        });

    }
}

