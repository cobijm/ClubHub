package com.example.ClubHub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ClubHomePage extends AppCompatActivity {

    private String clubName;
    private String users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_home_page);

        clubName = getIntent().getStringExtra("clubName");
        TextView myTxt = (TextView) findViewById(R.id.clubName);
        myTxt.setText(clubName);
    }

}
