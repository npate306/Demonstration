package com.example.neelpatel.demonstration;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class TopMoviesAdapter extends RecyclerView.Adapter<TopMoviesAdapter.PopularMovieViewHolder> {

    private List<Result> movies;
    private int rowLayout;

    public static class PopularMovieViewHolder extends RecyclerView.ViewHolder {
        TextView movieTitle;
        TextView rating;
        TextView movieDescription;


        public PopularMovieViewHolder(View v) {
            super(v);
            movieTitle = (TextView) v.findViewById(R.id.textView7);
            movieDescription = (TextView) v.findViewById(R.id.textView6);
            rating = (TextView) v.findViewById(R.id.textView4);
        }
    }

    public TopMoviesAdapter(List<Result> movies, int rowLayout) {
        this.movies = movies;
        this.rowLayout = rowLayout;
    }

    @Override
    public TopMoviesAdapter.PopularMovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new PopularMovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(PopularMovieViewHolder holder, final int position) {
        holder.movieTitle.setText("Movie: " + movies.get(position).getTitle());
        holder.rating.setText("Rating: " + movies.get(position).getVoteAverage() + "/ 10");
        holder.movieDescription.setText("Overview: " + movies.get(position).getOverview());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}