package com.example.allears;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private final List<Song> songs;
    private final List<Song> songsFull;
    private final Context context;

    public SongAdapter(Context context, List<Song> songs) {
        this.context = context;
        this.songs = songs;
        this.songsFull = new ArrayList<>(songs);
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_song, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song song = songs.get(position);
        holder.songNameTextView.setText(song.getName());
        holder.artistNameTextView.setText(song.getArtist());
        holder.songImageView.setImageResource(song.getImageResourceId());

        // Handle item clicks
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, RatingActivity.class);
            intent.putExtra("SONG_TITLE", song.getName());
            intent.putExtra("SONG_ARTIST", song.getArtist());
            intent.putExtra("SONG_IMAGE", song.getImageResourceId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public void filter(String text) {
        songs.clear();
        if (text.isEmpty()) {
            songs.addAll(songsFull);
        } else {
            text = text.toLowerCase();
            for (Song song : songsFull) {
                if (song.getName().toLowerCase().contains(text) || song.getArtist().toLowerCase().contains(text)) {
                    songs.add(song);
                }
            }
        }
        notifyDataSetChanged();
    }

    public static class SongViewHolder extends RecyclerView.ViewHolder {
        ImageView songImageView;
        TextView songNameTextView;
        TextView artistNameTextView;

        public SongViewHolder(View itemView) {
            super(itemView);
            songImageView = itemView.findViewById(R.id.songImageView);
            songNameTextView = itemView.findViewById(R.id.songNameTextView);
            artistNameTextView = itemView.findViewById(R.id.artistNameTextView);
        }
    }
}
