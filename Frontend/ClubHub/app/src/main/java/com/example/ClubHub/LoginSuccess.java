package com.example.ClubHub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class LoginSuccess extends AppCompatActivity {

    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        String fetched = fetchUser();
        text = (TextView)findViewById(R.id.textView3);
        fetched = "Welcome back " + fetched;
        text.setText(fetched);

        Bundle extra = getIntent().getBundleExtra("extra");
        final String userID = (String)extra.getSerializable("IDNumber");

        Button oButton = (Button) findViewById(R.id.homePageBTN);
        Button sButton = (Button) findViewById(R.id.searchClubBtn);

        oButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent userHomePage = new Intent(LoginSuccess.this, UserHomePage.class);
                userHomePage.putExtra("IDNumber", userID);
                startActivity(userHomePage);

            }
        });

        // FIX THIS MAYBE??
        sButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchPage = new Intent(LoginSuccess.this, ClubSearchPage.class);
                searchPage.putExtra("IDNumber", userID);
                startActivity(searchPage);
            }
        });

    }

    public String fetchUser(){

        Bundle extra = getIntent().getBundleExtra("extra");
        String s = "";
        if(extra != null){
            s = (String)extra.getSerializable("user");
            Log.d("Fetched user: ", s);
            return s;
        }
        else{
            Log.d("No user detected", s);
            return "";
        }
    }

}
