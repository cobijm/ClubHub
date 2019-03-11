package com.example.ClubHub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ClubHomePage extends AppCompatActivity {

    private String clubName;
    private String domainName;
    private String clubStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_home_page);

        clubName = getIntent().getStringExtra("clubName");
        domainName = getIntent().getStringExtra("domain");

        Button mButton = (Button)findViewById(R.id.mapsLocation);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapLocation = new Intent(ClubHomePage.this,MapsActivity.class);
                mapLocation.putExtra("clubName", clubName);
                startActivity(mapLocation);
            }
        });


        TextView myTxt = (TextView) findViewById(R.id.clubName);
        myTxt.setText(clubName);

    }

}
