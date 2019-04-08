package com.example.ClubHub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ClubHomePage extends AppCompatActivity {

    private boolean exists = false; // Variable to see if the user is already in the club
    private String clubName;
    private String domainName;
    private String clubStatus;
    private String clubIDpassedIn;
    private String userIDpassedIn;
    private String cJSONURLString = "http://cs309-pp-4.misc.iastate.edu:8080/clubtable";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_home_page);

        clubName = getIntent().getStringExtra("clubName");
        domainName = getIntent().getStringExtra("clubDomain");
        clubStatus = getIntent().getStringExtra("clubStatus");
        clubIDpassedIn = getIntent().getStringExtra("clubID");
        userIDpassedIn = getIntent().getStringExtra("userID");

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

//        IMPLEMENT THIS PROPERLY
        jButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

                // New JSON GET Request
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, cJSONURLString, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                // Do something with response

                                String clubID = "";
                                String clubName = "";
                                String clubDomain = "";
                                String clubStatus = "";
                                String [] clubMembers = {};
                                String[] clubTags = {};

                                int idFound = 0;

                                try {
                                    // Get JSON object
                                    JSONArray array = response.getJSONArray("clubs"); // From club table

                                    //Change upper bound of for loop to array.length() to print all values
                                    for (int i = 0; i < array.length(); i++) {

                                        // Get current json object
                                        JSONObject club = array.getJSONObject(i);

                                        String id = club.getString("clubID");
                                        String name = club.getString("clubName");
                                        String domain = club.getString("clubDomain");
                                        String status = club.getString("clubStatus");

                                        JSONArray memArr = club.getJSONArray("clubMembers");
                                        String [] members = new String[memArr.length()];
                                        for(int k = 0; k < memArr.length(); k++){
                                            members[k] = memArr.getString(k);
                                        }


                                        JSONArray tagArr = club.getJSONArray("clubTags");
                                        String [] tags = new String[tagArr.length()];
                                        for(int p = 0; p < tagArr.length(); p++){
                                            tags[p] = tagArr.getString(p);
                                        }

                                        if(id.equals(clubIDpassedIn)){
                                            idFound = 1;
                                            ArrayList<String> memList = new ArrayList<>(members.length);
                                            for(String j : members){
                                                memList.add(j);
                                            }

                                            memList.add(userIDpassedIn);

                                            clubID = id;
                                            clubName = name ;
                                            clubDomain = domain;
                                            clubStatus = status;
                                            clubMembers = (String[]) memList.toArray();
                                            clubTags = tags;
                                        }

                                        if(idFound == 1){
                                            postData(clubID, clubName, clubDomain, clubStatus, clubMembers, clubTags);
                                        }

                                    }

                                    // Toast if credentials are not in the server
                                    if (!exists) {
                                        Toast.makeText(getApplicationContext(), "Incorrect Credentials", Toast.LENGTH_LONG).show();

                                    }


                                } catch (JSONException e) {
                                    e.printStackTrace();

                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "Volley error " + error.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                );
                queue.add(jsonObjectRequest);

            }


            public void postData(String clubs, String name, String domain, String status, String[] mems, String[] tags) throws JSONException {
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

                //Map<String, String> params = new HashMap();
                JSONObject params = new JSONObject();
                params.put("clubID", clubs);
                params.put("clubName", name);
                params.put("clubDomain", domain);
                params.put("clubStatus", status);
                params.put("clubMembers", mems);
                params.put("clubTags", tags);

                String url = "http://cs309-pp-4.misc.iastate.edu:8080/clubtable";
                //String url = "https://0ea88006-bc29-40d9-8155-873d2ed83f3c.mock.pstmn.io/registration";
                JsonObjectRequest postRequestAddMember = new JsonObjectRequest(Request.Method.POST, url, params,
                        new Response.Listener<JSONObject>()
                        {
                            @Override
                            public void onResponse(JSONObject response) {
                                // response
                                Log.d("Response", response.toString());
                                Toast.makeText(getApplicationContext(), "Welcome to the" + clubName, Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // error
                                Log.d("Error.Response", error.toString());
                                Toast.makeText(getApplicationContext(), "Error joining the " + clubName, Toast.LENGTH_LONG).show();
                            }
                        }
                );
                queue.add(postRequestAddMember);
            }
        });





        TextView myTxt = (TextView) findViewById(R.id.clubName);
        myTxt.setText(clubName);

        TextView myTxt2 =(TextView)findViewById(R.id.domain);
        myTxt2.setClickable(true);
        myTxt2.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='http://www." + domainName + "'> "+ domainName + " </a>";
        myTxt2.setText(Html.fromHtml(text));

        TextView myTxt3 = (TextView)findViewById(R.id.status);
        myTxt3.setText(clubStatus);
    }

}
