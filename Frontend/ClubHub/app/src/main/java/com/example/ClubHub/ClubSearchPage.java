package com.example.ClubHub;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
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

/**
 * Shows a list that can be filtered in-place with a SearchView in non-iconified mode.
 */
public class ClubSearchPage extends Activity implements SearchView.OnQueryTextListener {

    private SearchView mSearchView;
    private ListView mListView;
    private String mJSONURLString = "http://cs309-pp-4.misc.iastate.edu:8080/clubtable";
    private final String[] mStrings = { "Google", "Apple", "Samsung", "Sony", "LG", "HTC" };

    //String[] clubNameArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);

        setContentView(R.layout.activity_club_search_page);

        fetchClubs();

        mSearchView = (SearchView) findViewById(R.id.search_view);
        mListView = (ListView) findViewById(R.id.list_view);
        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrings));
        mListView.setTextFilterEnabled(true);
        setupSearchView();
    }

    /*
    private void fetchClubs(){
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
                                JSONObject user = array.getJSONObject(i);

                                // Get the current club (json object) data
                                String clubID = user.getString("clubID");
                                String clubName = user.getString("clubName");

                            }

                            clubNameArray = innerClubNameArray;

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
    }
    */


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
