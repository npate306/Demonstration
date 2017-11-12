package com.example.neelpatel.demonstration;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Neel Patel on 10/27/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MovieSearchViewHolder>{

    private List<Result> movies;
    private int rowLayout;

    /**
     * Class that has reference to adapter
     */
    public static class MovieSearchViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView adultMovie;
        TextView overView;

        public MovieSearchViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.textview12);
            adultMovie = (TextView) v.findViewById(R.id.text2);
            overView = (TextView) v.findViewById(R.id.text1);
        }
    }

    public Adapter(List<Result> movies, int rowLayout) {
        this.movies = movies;
        this.rowLayout = rowLayout;
    }

    /**
     *Inflates the layout so that it will actually appear on screen
     * @param parent - parent view for layout
     * @param viewType - what type of view
     * @return - viewholder needed for recyclerview
     */
    @Override
    public MovieSearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieSearchViewHolder(view);
    }

    /**
     * Initializes all of the data for the recyclerview a
     * @param holder - holder that holds all of the data together
     * @param position - where in list of movies we are at
     */
    @Override
    public void onBindViewHolder(final MovieSearchViewHolder holder, final int position) {
        holder.title.setText("Name: " + movies.get(position).getTitle());
        holder.adultMovie.setText("Is it an adult film: " + movies.get(position).getAdult());
        holder.overView.setText("Overview: " + movies.get(position).getOverview());
    }

    /**
     * Prevents reyclerview from returning only one item
     * @return - size of resturant list
     */
    @Override
    public int getItemCount() {
        return movies.size();
    }


}