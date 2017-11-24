package com.example.neelpatel.demonstration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Neel Patel on 11/9/2017.
 */

public class HomePage extends Activity {

    private Button signOut;
    private Button search;
    private Button watchTopMovies;
    private Button reviews;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        search = (Button) findViewById(R.id.button4);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this, Search.class));
            }
        });
        watchTopMovies = (Button) findViewById(R.id.button7);
        watchTopMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this, PopularMovies.class));
            }
        });
        reviews = (Button) findViewById(R.id.button6);
        reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePage.this, Reviews.class));
            }
        });
        signOut = (Button) findViewById(R.id.button9);
        mAuth = FirebaseAuth.getInstance();
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(HomePage.this, MainActivity.class));
            }
        });
    }
}