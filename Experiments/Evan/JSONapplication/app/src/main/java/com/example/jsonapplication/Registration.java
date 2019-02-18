package com.example.jsonapplication;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private String mJSONURLString = "http://cs309-pp-4.misc.iastate.edu:8080/usersid";
    private String postmanTest = "https://0ea88006-bc29-40d9-8155-873d2ed83f3c.mock.pstmn.io/registration";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
        //Button to go to the registration page
        Button oButton = (Button) findViewById(R.id.buttonRegister);
        oButton.setOnClickListener(this);




    }



    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.buttonRegister:
                RequestQueue queue = Volley.newRequestQueue(this);  // this = context

                EditText IDEdit = (EditText)findViewById(R.id.textID);
                final String IDInput = IDEdit.getText().toString();

                EditText nameEdit = (EditText)findViewById(R.id.textName);
                final String nameInput = nameEdit.getText().toString();

                EditText descriptionEdit = (EditText)findViewById(R.id.textDescription);
                final String descriptionInput = nameEdit.getText().toString();

                String url = "https://0ea88006-bc29-40d9-8155-873d2ed83f3c.mock.pstmn.io/registration";
                StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                // response
                                Log.d("Response", response);
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // error
                                //Log.d("Error.Response", error);
                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<String, String>();
                        params.put("id", IDInput);
                        params.put("name", nameInput);
                        params.put("description", descriptionInput);

                        return params;
                    }
                };
                queue.add(postRequest);

                startActivity(new Intent(Registration.this, RegistrationSuccess.class));
                break;

        }

    }
}
