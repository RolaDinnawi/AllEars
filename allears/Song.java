package com.example.allears;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {
    private String name;
    private String artist;
    private int imageResourceId;

    public Song(String name, String artist, int imageResourceId) {
        this.name = name;
        this.artist = artist;
        this.imageResourceId = imageResourceId;
    }

    protected Song(Parcel in) {
        name = in.readString();
        artist = in.readString();
        imageResourceId = in.readInt();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(artist);
        dest.writeInt(imageResourceId);
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
