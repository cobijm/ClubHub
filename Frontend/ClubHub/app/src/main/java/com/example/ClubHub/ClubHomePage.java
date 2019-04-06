package com.example.ClubHub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
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
        domainName = getIntent().getStringExtra("clubDomain");
        clubStatus = getIntent().getStringExtra("clubStatus");

        Button mButton = (Button)findViewById(R.id.mapsLocation);
        Button jButton = (Button)findViewById(R.id.joinButton);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapLocation = new Intent(ClubHomePage.this,MapsActivity.class);
                mapLocation.putExtra("clubName", clubName);
                startActivity(mapLocation);
            }
        });

//        jButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });


        TextView myTxt = (TextView) findViewById(R.id.clubName);
        myTxt.setText(clubName);

        //TextView myTxt2 = (TextView)findViewById(R.id.domain);
        //myTxt2.setText(domainName);

        TextView myTxt2 =(TextView)findViewById(R.id.domain);
        myTxt2.setClickable(true);
        myTxt2.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='http://www." + domainName + "'> "+ domainName + " </a>";
        myTxt2.setText(Html.fromHtml(text));

        TextView myTxt3 = (TextView)findViewById(R.id.status);
        myTxt3.setText(clubStatus);
    }

}
