package com.example.popularmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import com.example.popularmovies.model.UrlModel;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SingleMovie extends AppCompatActivity {

    final static String IMAGE_URL = "https://image.tmdb.org/t/p/w500";
    //define
    final static String MOVIE_KEY = "movie";
    final static String RELEASED_ON = "Released on: ";
    final static String RATING = "User Ratings: ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_movie);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent fromPrevActivity = getIntent();
        UrlModel movie = fromPrevActivity.getParcelableExtra(MOVIE_KEY);

        Picasso.with(this).load(IMAGE_URL + movie.getPoster_path()).into((ImageView) findViewById(R.id.iv_movie_poster));

        TextView plotTextView = (TextView) findViewById(R.id.tv_plot);
        plotTextView.setText(movie.getOverview());

        TextView titleTextView = (TextView) findViewById(R.id.tv_title);
        titleTextView.setText(movie.getOriginal_name());

        TextView releasedOnTextView = (TextView) findViewById(R.id.tv_release_date);
        String releasedOn = RELEASED_ON + movie.getRelease_date();
        releasedOnTextView.setText(releasedOn);

        TextView ratingTextView = (TextView) findViewById(R.id.tv_rating);
        String rating = RATING + movie.getRating();

        ratingTextView.setText(rating);

    }
}
