package com.example.allears;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private SongAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        EditText searchEditText = findViewById(R.id.searchEditText);
        RecyclerView songsRecyclerView = findViewById(R.id.songsRecyclerView);
        Button aiButton = findViewById(R.id.aiButton);

        songsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Song> songList = new ArrayList<>();
        songList.add(new Song("Li Beirut", "Fairouz", R.drawable.li_beirut));
        songList.add(new Song("Your Best American Girl", "Mitski", R.drawable.your_best_american_girl));
        songList.add(new Song("Paper Bag", "Fiona Apple", R.drawable.paper_bag));
        songList.add(new Song("Black No. 1", "Type O Negative", R.drawable.blacknone));
        songList.add(new Song("Was ich liebe", "Rammstein", R.drawable.was_ich_liebe));
        songList.add(new Song("Wish You Were Here", "Pink Floyd", R.drawable.wish_u_were_here));
        songList.add(new Song("Stairway to Heaven", "Led Zeppelin", R.drawable.stairway_to_heaven));
        songList.add(new Song("Orion", "Metallica", R.drawable.orion));
        songList.add(new Song("A Forest", "The Cure", R.drawable.a_forest));
        songList.add(new Song("Where Is My Mind?", "Pixies", R.drawable.where_is_my_mind));
        // will add more songs later

        adapter = new SongAdapter(this, songList);
        songsRecyclerView.setAdapter(adapter);

        // search functionality
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // nothing
            }
        });

        aiButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, AIRecommendationsActivity.class);
            startActivity(intent);
        });
    }
}
