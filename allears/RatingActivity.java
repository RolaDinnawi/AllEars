package com.example.allears;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RatingActivity extends AppCompatActivity {

    private RatingBar songRatingBar;
    private EditText reviewEditText;
    private LinearLayout reviewsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        ImageView songImageView = findViewById(R.id.ratingSongImageView);
        TextView songTitleTextView = findViewById(R.id.ratingSongTitleTextView);
        TextView songArtistTextView = findViewById(R.id.ratingSongArtistTextView);
        songRatingBar = findViewById(R.id.songRatingBar);
        reviewEditText = findViewById(R.id.reviewEditText);
        Button submitReviewButton = findViewById(R.id.submitReviewButton);
        reviewsContainer = findViewById(R.id.reviewsContainer);

        String songTitle = getIntent().getStringExtra("SONG_TITLE");
        String songArtist = getIntent().getStringExtra("SONG_ARTIST");
        int songImage = getIntent().getIntExtra("SONG_IMAGE", R.drawable.ic_launcher_background);

        songImageView.setImageResource(songImage);
        songTitleTextView.setText(songTitle);
        songArtistTextView.setText(songArtist);

        submitReviewButton.setOnClickListener(v -> {
            String review = reviewEditText.getText().toString().trim();
            float rating = songRatingBar.getRating();

            if (!TextUtils.isEmpty(review)) {
                addReview(rating, review);
                reviewEditText.setText("");
                songRatingBar.setRating(0);
            }
        });
    }

    private void addReview(float rating, String review) {
        TextView reviewTextView = new TextView(this);
        reviewTextView.setText(String.format("Rating: %.1f\nReview: %s", rating, review));
        reviewTextView.setTextColor(getResources().getColor(R.color.white));
        reviewTextView.setPadding(0, 16, 0, 0);
        reviewsContainer.addView(reviewTextView);
    }
}
