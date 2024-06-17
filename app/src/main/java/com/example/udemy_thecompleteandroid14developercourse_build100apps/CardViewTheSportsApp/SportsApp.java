package com.example.udemy_thecompleteandroid14developercourse_build100apps.CardViewTheSportsApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;

import java.util.ArrayList;
import java.util.List;

public class SportsApp extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Sport> sportslist;
    private SportAdapter sportAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_app);

        recyclerView = findViewById(R.id.sportsRecyclerView);
        sportslist = new ArrayList<>();

        Sport s1 = new Sport("Football", R.drawable.football);
        Sport s2 = new Sport("Basketball", R.drawable.basketball);
        Sport s3 = new Sport("VolleyBall", R.drawable.volley);
        Sport s4 = new Sport("Tennis", R.drawable.tennis);
        Sport s5 = new Sport("Ping Pong", R.drawable.ping);

        sportslist.add(s1);
        sportslist.add(s2);
        sportslist.add(s3);
        sportslist.add(s4);
        sportslist.add(s5);

        sportAdapter = new SportAdapter(sportslist);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(sportAdapter);

    }
}