package com.example.android.musicapp;

/**
 * Created by kate on 18/05/18.
 */

public class Song {
    private String mArtist;
    private String mSong;
    private String mDuration;

    public Song(String artist, String song, String duration) {
        mArtist = artist;
        mSong = song;
        mDuration = duration;
    }

    public String getArtist() {
        return mArtist;
    }

    public String getSong() {
        return mSong;
    }

    public String getDuration() {
        return mDuration;
    }

}
