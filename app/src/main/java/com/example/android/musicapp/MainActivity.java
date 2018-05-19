package com.example.android.musicapp;

import android.content.Intent;
import android.drm.DrmStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    boolean musicIsPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        String artistName = intent.getStringExtra("artist");
        String songName = intent.getStringExtra("song");
        if (artistName == null && songName == null) {
            artistName = getString(R.string.artist);
            songName = getString(R.string.song);
        }

        TextView artist = findViewById(R.id.artist);
        artist.setText(artistName);

        TextView song = findViewById(R.id.song);
        song.setText(songName);

        Button backToTheList = findViewById(R.id.backToTheList);
        backToTheList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playListIntent = new Intent(MainActivity.this, PlayListActivity.class);
                startActivity(playListIntent);
            }
        });

        Button play = findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button play = (Button) view;
                musicIsPlaying = !musicIsPlaying;
                if (musicIsPlaying) {
                    play.setText(R.string.pauseIcon);
                } else {
                    play.setText(R.string.playIcon);
                }
            }
        });

        Button previousButton = findViewById(R.id.previous);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, getText(R.string.toastPrevious), Toast.LENGTH_SHORT).show();
            }
        });

        Button nextButton = findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, getText(R.string.toastNext), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
