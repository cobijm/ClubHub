package com.example.ClubHub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class LoginSuccess extends AppCompatActivity {

    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        final String userName = fetchUser();
        text = (TextView)findViewById(R.id.textView3);
        String welcomeText = "Welcome back " + userName;
        text.setText(welcomeText);

        Bundle extra = getIntent().getBundleExtra("extra");
        final String userID = (String)extra.getSerializable("IDNumber");

        Button oButton = (Button) findViewById(R.id.homePageBTN);
        oButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent userHomePage = new Intent(LoginSuccess.this, UserHomePage.class);
                userHomePage.putExtra("IDNumber", userID);
                startActivity(userHomePage);

            }
        });

        Button pButton = (Button) findViewById(R.id.loggedInChat);
        pButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent LoggedInChat = new Intent(LoginSuccess.this, LoggedInChat.class);
                LoggedInChat.putExtra("userName", userName);
                startActivity(LoggedInChat);
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
