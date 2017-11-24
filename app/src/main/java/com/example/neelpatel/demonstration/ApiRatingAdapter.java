package com.example.neelpatel.demonstration;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Neel Patel on 11/24/2017.
 */

public class ApiRatingAdapter extends RecyclerView.Adapter<ApiRatingAdapter.ResultMovieViewHolder> {

    private List<Result> movies;
    private int rowLayout;

    public static class ResultMovieViewHolder extends RecyclerView.ViewHolder {
        TextView movieTitle;
        TextView rating;

        public ResultMovieViewHolder(View v) {
            super(v);
            movieTitle = (TextView) v.findViewById(R.id.textView9);
            rating = (TextView) v.findViewById(R.id.textView3);
        }
    }

    public ApiRatingAdapter(List<Result> movies, int rowLayout) {
        this.movies = movies;
        this.rowLayout = rowLayout;
    }

    @Override
    public ApiRatingAdapter.ResultMovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                                      int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ApiRatingAdapter.ResultMovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ResultMovieViewHolder holder, int position) {
        holder.movieTitle.setText("Title: " + movies.get(position).getTitle());
        holder.rating.setText("Rating: " + movies.get(position).getVoteAverage() + "/10");
    }


    @Override
    public int getItemCount() {
        return movies.size();
    }
}