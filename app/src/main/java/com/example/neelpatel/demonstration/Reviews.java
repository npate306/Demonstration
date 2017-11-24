package com.example.neelpatel.demonstration;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * Created by Neel Patel on 11/24/2017.
 */

public class Reviews extends Activity{

    private static String URL = "https://api.themoviedb.org/3/search/movie?" +
            "api_key=" + API_KEY.KEY + "&query=";
    private RecyclerView apiRating;
    private Button getReviews;
    private EditText movie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviews);
        apiRating = (RecyclerView) findViewById(R.id.apiRating);
        apiRating.setLayoutManager(new LinearLayoutManager(this));
        getReviews = (Button) findViewById(R.id.button8);
        movie = (EditText) findViewById(R.id.editText4);
        getReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String movieName = movie.getText().toString();
                URL = URL + movieName;
                ReviewsTask reviewsTask = new ReviewsTask();
                reviewsTask.execute(URL);
            }
        });
    }

    class ReviewsTask extends AsyncTask<String, Integer, Movies> {

        private final String TAG = "Failure";

        /**
         * GET request to obtain data from url
         * @param params - whatever url user passes in
         * @return - Movies object that contains data
         */
        @Override
        protected Movies doInBackground(String... params) {
            try {
                java.net.URL url = new URL(params[0]);
                URLConnection connection = url.openConnection();
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader
                        (inputStream, Charset.forName("UTF-8"));
                Gson gson = new Gson();
                Movies movies = gson.fromJson(inputStreamReader, Movies.class);
                return movies;
            } catch (Exception e) {
                Log.e(TAG, "Did not work");
            }
            return null;
        }

        /**
         * Sets adapter for recycler view
         * @param movies - object with alll the information
         */
        @Override
        protected void onPostExecute(Movies movies) {
            if (movies == null) {
                return;
            }
            ApiRatingAdapter adapter = new ApiRatingAdapter(movies.getResults(),
                    R.layout.reviewsadapter);
            apiRating.setAdapter(adapter);
        }
    }
}
