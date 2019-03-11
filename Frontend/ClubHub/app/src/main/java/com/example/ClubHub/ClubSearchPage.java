package com.example.ClubHub;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.HttpAuthHandler;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

import java.util.ArrayList;


/**
 * Shows a list that can be filtered in-place with a SearchView in non-iconified mode.
 */
public class ClubSearchPage extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private SearchView mSearchView;
    private ListView mListView;
    private String mJSONURLString = "http://cs309-pp-4.misc.iastate.edu:8080/clubtable";
    //private final String[] mStrings = { "Google", "Apple", "Samsung", "Sony", "LG", "HTC" };
    final ArrayList<String> clubNameArrayList = new ArrayList<>();

    String clubDomain = "";
    String clubStatus = "";

    //public static String[] clubNameArray;
    //private String[] clubNameArray = new String[100];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);

        setContentView(R.layout.activity_club_search_page);


        //Toast.makeText(getApplicationContext(), clubNameArray[0], Toast.LENGTH_LONG).show();

        mSearchView = (SearchView) findViewById(R.id.search_view);
        mListView = (ListView) findViewById(R.id.list_view);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, clubNameArrayList);
        mListView.setAdapter(adapter);

        final String tagReceived = getIntent().getStringExtra("tag");

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

                            //Change upper bound of for loop to array.length() to print all values
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject club = array.getJSONObject(i);

                                // Get the current club (json object) data
                                clubDomain = club.getString("clubDomain");
                                clubStatus = club.getString("clubStatus");
                                String clubName = club.getString("clubName");

                                if(tagReceived.equals("all")){
                                    clubNameArrayList.add(clubName);
                                }
                                else{
                                    JSONArray clubTags = club.getJSONArray("clubTags");
                                    String[] tagsArr = new String[clubTags.length()];
                                    for (int j = 0; j < clubTags.length(); j++){
                                        tagsArr[j] = clubTags.getString(j);
                                    }
                                    for(int k = 0; k < tagsArr.length; k++){
                                        if(tagReceived.equals(tagsArr[k])){
                                            //Add the club name for any club with the given tags
                                            clubNameArrayList.add(clubName);
                                            adapter.notifyDataSetChanged();
                                            mListView.setAdapter(adapter);
                                        }
                                    }
                                }
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

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            Intent clubPage = new Intent(ClubSearchPage.this, ClubHomePage.class);
            //Intent clubPage = new Intent(ClubSearchPage.this, Login.class);
            clubPage.putExtra("clubName", clubNameArrayList.get(position));

            //Change below to get current domain and status
            clubPage.putExtra("clubDomain", clubDomain);
            clubPage.putExtra("clubStatus", clubStatus);
            startActivity(clubPage);
            }
        });
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
