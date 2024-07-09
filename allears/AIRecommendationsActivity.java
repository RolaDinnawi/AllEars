package com.example.allears;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AIRecommendationsActivity extends AppCompatActivity {

    private EditText moodEditText;
    private Button generateButton;
    private RecyclerView recommendationsRecyclerView;
    private SongAdapter adapter;
    private List<Song> songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_recommendations);

        moodEditText = findViewById(R.id.moodEditText);
        generateButton = findViewById(R.id.generateButton);
        recommendationsRecyclerView = findViewById(R.id.recommendationsRecyclerView);

        songList = new ArrayList<>();
        adapter = new SongAdapter(this, songList);
        recommendationsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        recommendationsRecyclerView.setAdapter(adapter);

        generateButton.setOnClickListener(v -> {
            String mood = moodEditText.getText().toString();
            generateRecommendations(mood);
        });
    }
    // will be replaced with AI model later
    private void generateRecommendations(String mood) {
        int previousSize = songList.size();
        songList.clear();

        if (mood.equalsIgnoreCase("happy")) {
            songList.add(new Song("Good Days", "SZA", R.drawable.sza));
            songList.add(new Song("Here Comes the Sun", "The Beatles", R.drawable.the_beatles));
            songList.add(new Song("Let's Dance", "David Bowie", R.drawable.lets_dance));

        } else if (mood.equalsIgnoreCase("sad")) {
            songList.add(new Song("I Bet On Losing Dogs", "Mitski", R.drawable.your_best_american_girl));
            songList.add(new Song("Waiting Room", "Phoebe Bridgers", R.drawable.waiting_room));
            songList.add(new Song("Forget Her", "Jeff Buckley", R.drawable.forget_her));

        } else {
            songList.add(new Song("Sunday", "The Cranberries", R.drawable.cranberries));
            songList.add(new Song("Marooned", "Pink Floyd", R.drawable.marooned));
            songList.add(new Song("Show Me How", "Men I Trust", R.drawable.show_me_how));

        }

        adapter.notifyItemRangeInserted(previousSize, songList.size() - previousSize);
    }
}
