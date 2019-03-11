package com.example.ClubHub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class ClubTagSearch extends AppCompatActivity implements View.OnClickListener {
    final ArrayList<String> availibleTags = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_tag_search);

        availibleTags.add("social");
        availibleTags.add("sport");
        availibleTags.add("drinking");
        availibleTags.add("academic");
        availibleTags.add("engineering");
        availibleTags.add("computers");
        availibleTags.add("cars");
        availibleTags.add("adult");
        availibleTags.add("fun");
        availibleTags.add("mips");
        availibleTags.add("fish");
        availibleTags.add("outdoors");
        availibleTags.add("sleep");


        //Button to search by the given tag
        Button nButton = (Button) findViewById(R.id.tagSearchButton);
        nButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText tagEdit = (EditText)findViewById(R.id.tagSearchInput);
        final String tagInput = tagEdit.getText().toString();

        String sendTag = "";
        switch (v.getId()) {

            case R.id.tagSearchButton:
                //mTextView.setText("Text Changed");
                if (tagInput.equals("all") || tagInput.equals("All")) {
                    //Put in logic to not search by tag
                    sendTag = "all";
                    Intent mapLocation = new Intent(ClubTagSearch.this, ClubSearchPage.class);
                    mapLocation.putExtra("tag", sendTag);
                    startActivity(mapLocation);
                }
                else if(availibleTags.contains(tagInput)){
                    sendTag = tagInput;
                    Intent mapLocation = new Intent(ClubTagSearch.this, ClubSearchPage.class);
                    mapLocation.putExtra("tag", sendTag);
                    startActivity(mapLocation);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Tag not available", Toast.LENGTH_LONG).show();
                }
                startActivity(new Intent(ClubTagSearch.this, ClubSearchPage.class));
                break;
        }
    }
}
