package com.example.submissionexpert1.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.submissionexpert1.R;
import com.example.submissionexpert1.recyclerview.MainList;
import com.example.submissionexpert1.recyclerview.Movie;

public class Details extends AppCompatActivity {
    private TextView name, description;
    private ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        name = findViewById(R.id.detail_name);
        description = findViewById(R.id.detail_description);
        photo = findViewById(R.id.detail_photo);

        Movie movies = getIntent().getParcelableExtra(MainList.SELECTED_MOVIES);

        name.setText(movies.getName());
        description.setText(movies.getDescription());
        photo.setImageResource(movies.getPhoto());

        setTitle(movies.getName());
    }
}
