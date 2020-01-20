package com.example.submissionexpert1.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.submissionexpert1.R;
import com.example.submissionexpert1.detail.Details;

import java.util.ArrayList;

public class MainList extends AppCompatActivity {
    public static final String SELECTED_MOVIES = "selected movies";
    private RecyclerView recyclerView;
    private Adapter adapter;

    private ArrayList<Movie> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setAdapter();
    }

    private void setAdapter() {


        movies.add(new Movie(getResources().getString(R.string.title_aquaman), getResources().getString(R.string.desc_aquaman), R.drawable.aquaman));
        movies.add(new Movie(getResources().getString(R.string.title_avenger),getResources().getString(R.string.desc_avenger),R.drawable.avenger));
        movies.add(new Movie(getResources().getString(R.string.title_birdbox),getResources().getString(R.string.desc_birdbox),R.drawable.birdbbox));
        movies.add(new Movie(getResources().getString(R.string.title_creed),getResources().getString(R.string.desc_creed),R.drawable.creed));
        movies.add(new Movie(getResources().getString(R.string.title_deadpool2),getResources().getString(R.string.desc_deadpool),R.drawable.deadpool2));
        movies.add(new Movie(getResources().getString(R.string.title_httyd2),getResources().getString(R.string.desc_httyd),R.drawable.dragon));
        movies.add(new Movie(getResources().getString(R.string.title_robin),getResources().getString(R.string.desc_robin),R.drawable.robin));
        movies.add(new Movie(getResources().getString(R.string.title_spiderman),getResources().getString(R.string.desc_spiderman),R.drawable.spiderman));
        movies.add(new Movie(getResources().getString(R.string.title_star),getResources().getString(R.string.desc_star),R.drawable.star));
        movies.add(new Movie(getResources().getString(R.string.title_venom2),getResources().getString(R.string.desc_venom),R.drawable.venom));

        adapter = new Adapter(MainList.this, movies);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.SetOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void OnItemCLick(View view, int position, Movie movie) {
                Intent detail = new Intent(MainList.this, Details.class);
                detail.putExtra(MainList.SELECTED_MOVIES, movie);
                startActivity(detail);
            }
        });
    }

    private void findViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerMain);
    }
}
