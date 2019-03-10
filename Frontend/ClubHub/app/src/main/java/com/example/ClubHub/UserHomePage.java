package com.example.ClubHub;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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


public class UserHomePage extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_page);

        final ArrayList<String> clubNames = new ArrayList<String>();
        final ListView listView = (ListView) findViewById(R.id.myList);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, clubNames);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://cs309-pp-4.misc.iastate.edu:8080/clubtable";

        JsonObjectRequest JSONRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray array = response.getJSONArray("clubs");
                    for (int i = 0; i < array.length(); i++) {

                        JSONObject object = array.getJSONObject(i);
                        String clubs = object.getString("clubName");

                        if(clubs != null) {
                            clubNames.add(clubs);
                        }

                    }

                    listView.setAdapter(arrayAdapter);
                    // Once we added the string to the array, we notify the arrayAdapter
                    arrayAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Volley error " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        queue.add(JSONRequest);
    }

}


