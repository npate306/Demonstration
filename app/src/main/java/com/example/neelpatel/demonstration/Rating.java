package com.example.neelpatel.demonstration;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

/**
 * Created by Neel Patel on 11/25/2017.
 */

public class Rating extends Activity{

    private EditText movieName;
    private EditText rating;
    private Button save;
    private FirebaseDatabase database;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate);
        database = FirebaseDatabase.getInstance();
        movieName = (EditText) findViewById(R.id.editText5);
        rating = (EditText) findViewById(R.id.editText6);
        save = (Button) findViewById(R.id.button10);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String TITLE = movieName.getText().toString();
                final String userRating = rating.getText().toString() + "/10";
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String userName = user.getUid();
                DatabaseReference myRef = database.getReference(TITLE + "/" + userName);
                myRef.setValue(userRating);
                Toast.makeText(Rating.this, "Saved!", Toast.LENGTH_SHORT).show();
                movieName.setText("");
                rating.setText("");
            }
        });
    }
}
