package com.example.ClubHub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 *
 */
public class ClubTagSearch extends AppCompatActivity implements View.OnClickListener {
    /**
     *
     */
    final ArrayList<String> availableTags = new ArrayList<String>();


    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_tag_search);

        availableTags.add("social");
        availableTags.add("sport");
        availableTags.add("drinking");
        availableTags.add("academic");
        availableTags.add("engineering");
        availableTags.add("computers");
        availableTags.add("cars");
        availableTags.add("adult");
        availableTags.add("fun");
        availableTags.add("mips");
        availableTags.add("fish");
        availableTags.add("outdoors");
        availableTags.add("sleep");


        //Button to search by the given tag
        Button nButton = (Button) findViewById(R.id.tagSearchButton);
        nButton.setOnClickListener(this);
    }

    /**
     *
     * @param v
     */
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
                    Intent searchPage = new Intent(ClubTagSearch.this, ClubSearchPage.class);
                    searchPage.putExtra("tag", sendTag);
                    //Toast.makeText(getApplicationContext(), sendTag, Toast.LENGTH_LONG).show();
                    startActivity(searchPage);
                }
                else if(availableTags.contains(tagInput)){
                    sendTag = tagInput;
                    Intent searchPage = new Intent(ClubTagSearch.this, ClubSearchPage.class);
                    searchPage.putExtra("tag", sendTag);
                    //Toast.makeText(getApplicationContext(), sendTag, Toast.LENGTH_LONG).show();
                    startActivity(searchPage);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Tag not available", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
