package com.example.popularmovies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.popularmovies.model.UrlModel;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MovieViewHolder> {

    private UrlModel[] movies;
    private MovieClickHandler movieClickHandler;

    interface MovieClickHandler {
        void onClick(UrlModel movie);
    }

    class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        //Home
        final static String IMAGE_URL = "https://image.tmdb.org/t/p/w780";

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_movie_poster);
            itemView.setOnClickListener(this);
        }

        void bind(UrlModel movie) {
            Picasso.with(super.itemView.getContext()).load(IMAGE_URL + movie.getPoster_path()).into(imageView);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            UrlModel display = movies[position];
            movieClickHandler.onClick(display);
        }
    }

    public ImageAdapter(UrlModel[] movies, MovieClickHandler movieClickHandler) {
        this.movies = movies;
        this.movieClickHandler = movieClickHandler;
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.grid_posters, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(movies[position]);
    }

    public void setMoviesArray(UrlModel[] movies) {
        this.movies = movies;
    }

    @Override
    public int getItemCount() {
        return movies == null ? 0 : movies.length;
    }
}
