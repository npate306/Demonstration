package com.example.neelpatel.demonstration;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Neel Patel on 11/25/2017.
 */

public class UserRatingAdapter extends RecyclerView.Adapter<UserRatingAdapter.UserRatingViewHolder>{

    private ArrayList<String> ratings;
    private int rowLayout;

    public static class UserRatingViewHolder extends RecyclerView.ViewHolder {
        TextView rating;

        public UserRatingViewHolder(View v) {
            super(v);
            rating = (TextView) v.findViewById(R.id.textView15);
        }
    }

    public UserRatingAdapter(ArrayList<String> ratings, int rowLayout) {
        this.ratings = ratings;
        this.rowLayout = rowLayout;
    }

    @Override
    public UserRatingAdapter.UserRatingViewHolder onCreateViewHolder(ViewGroup parent,
                                                                     int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new UserRatingAdapter.UserRatingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserRatingViewHolder holder, int position) {
        holder.rating.setText(ratings.get(position));
    }

    @Override
    public int getItemCount() {
        return ratings.size();
    }
}