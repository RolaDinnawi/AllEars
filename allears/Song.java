package com.example.allears;

public class Song {
    private String name;
    private String artist;
    private int imageResourceId;

    public Song(String name, String artist, int imageResourceId) {
        this.name = name;
        this.artist = artist;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
