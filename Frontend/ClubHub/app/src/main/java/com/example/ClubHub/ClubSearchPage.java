package com.example.ClubHub;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.webkit.HttpAuthHandler;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
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

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Shows a list that can be filtered in-place with a SearchView in non-iconified mode.
 */
public class ClubSearchPage extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private SearchView mSearchView;
    private ListView mListView;
    private String mJSONURLString = "http://cs309-pp-4.misc.iastate.edu:8080/clubtable";
    private final String[] mStrings = { "Google", "Apple", "Samsung", "Sony", "LG", "HTC" };

    //public static String[] clubNameArray;
    //private String[] clubNameArray = new String[100];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);

        setContentView(R.layout.activity_club_search_page);

        final ArrayList<String> clubNameArrayList = new ArrayList<>();


        //Log.d("Test check", clubNameArray[0]);
        //Toast.makeText(getApplicationContext(), clubNameArray[0], Toast.LENGTH_LONG).show();

        mSearchView = (SearchView) findViewById(R.id.search_view);
        mListView = (ListView) findViewById(R.id.list_view);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, clubNameArrayList);
        mListView.setAdapter(adapter);

        RequestQueue queue = Volley.newRequestQueue(this);  // this = context

        //Initialize a new RequestQueue instance
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mJSONURLString, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Do something with response
                        try {
                            // Get JSON object
                            JSONArray array = response.getJSONArray("clubs");

                            String[] innerClubNameArray = new String[array.length()];

                            //Change upper bound of for loop to array.length() to print all values
                            for (int i = 0; i < array.length(); i++) {

                                // Get current json object
                                JSONObject club = array.getJSONObject(i);

                                // Get the current club (json object) data
                                String clubID = club.getString("clubID");
                                String clubName = club.getString("clubName");
                                //innerClubNameArray[i] = clubID;
                                //clubNameArray[i] = clubID;
                                clubNameArrayList.add(clubName);
                                adapter.notifyDataSetChanged();
                                mListView.setAdapter(adapter);
                                //Toast.makeText(getApplicationContext(), clubID, Toast.LENGTH_LONG).show();

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

        requestQueue.add(jsonObjectRequest);
        mListView.setTextFilterEnabled(true);
        setupSearchView();
    }

    private void setupSearchView() {
        mSearchView.setIconifiedByDefault(false);
        mSearchView.setOnQueryTextListener(this);
        mSearchView.setSubmitButtonEnabled(true);
        mSearchView.setQueryHint("Search Here");
    }

    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            mListView.clearTextFilter();
        } else {
            mListView.setFilterText(newText.toString());
        }
        return true;
    }

    public boolean onQueryTextSubmit(String query) {
        return false;
    }
}
