package com.example.neelpatel.demonstration;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
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
 * Created by Neel Patel on 11/11/2017.
 */

public class PopularMovies extends Activity {

    private static final String URL = "https://api.themoviedb.org/3/movie/popular?api_key=" +
            API_KEY.KEY + "&language=en-US&page=1";
    private RecyclerView recyclerView;
    private Button watch;
    private EditText movie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popularmovies);
        recyclerView = (RecyclerView) findViewById(R.id.popular);
        watch = (Button) findViewById(R.id.button12);
        movie = (EditText) findViewById(R.id.watch);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PopularMoviesTask popularMoviesTask = new PopularMoviesTask();
        popularMoviesTask.execute(URL);
        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String movieTitle = movie.getText().toString();
                Intent intent = new Intent(getApplicationContext(), WatchMovie.class);
                intent.putExtra("url", "http://putlockers.la/search-movies/" +
                        movieTitle + ".html");
                startActivity(intent);
            }
        });
    }

    class PopularMoviesTask extends AsyncTask<String, Integer, TopMovies> {

        private final String TAG = "Failure";

        /**
         * GET request to obtain data from url
         * @param params - whatever url user passes in
         * @return - Movies object that contains data
         */
        @Override
        protected TopMovies doInBackground(String... params) {
            try {
                java.net.URL url = new URL(params[0]);
                URLConnection connection = url.openConnection();
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader
                        (inputStream, Charset.forName("UTF-8"));
                Gson gson = new Gson();
                TopMovies movies = gson.fromJson(inputStreamReader, TopMovies.class);
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
        protected void onPostExecute(TopMovies movies) {
            if (movies == null) {
                return;
            }
            TopMoviesAdapter adapter = new TopMoviesAdapter(movies.getResults(), R.layout.topmoviesadapter);
            recyclerView.setAdapter(adapter);
        }
    }
}
