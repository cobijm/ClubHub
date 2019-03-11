package com.example.ClubHub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Login extends AppCompatActivity implements View.OnClickListener{


    private String mJSONURLString = "http://cs309-pp-4.misc.iastate.edu:8080/usersid";
    private boolean exists = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button oButton = (Button) findViewById(R.id.btnLogin);
        oButton.setOnClickListener(this);

        Button pButton = (Button) findViewById(R.id.forgotPasswordButton);
        pButton.setOnClickListener(this);

    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnLogin:
                RequestQueue queue = Volley.newRequestQueue(this);  // this = context

                EditText netIDEdit = (EditText)findViewById(R.id.loginText);
                final String netIDInput = netIDEdit.getText().toString();

                EditText passEdit = (EditText)findViewById(R.id.passText);
                final String passInput = passEdit.getText().toString();


                //Initialize a new RequestQueue instance
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mJSONURLString, null,
                         new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                // Do something with response
                                try {
                                    // Get JSON object
                                    JSONArray array = response.getJSONArray("user");

                                    //Change upper bound of for loop to array.length() to print all values
                                    for (int i = 0; i < array.length(); i++) {

                                        // Get current json object
                                        JSONObject user = array.getJSONObject(i);

                                        // Get the current student (json object) data
                                        String netid = user.getString("netid");
                                        String password = user.getString("password");
                                        String studentID = user.getString("id");

                                        if(netid.equals(netIDInput) && password.equals(passInput)){
                                            Bundle extra = new Bundle();
                                            String userID = netIDInput;

                                            String userIDNumber = studentID;
                                            extra.putSerializable("user", userID);
                                            extra.putSerializable("IDNumber", userIDNumber);

                                            Log.d("Got here", "yes");



                                            Intent j = new Intent(getApplicationContext(), LoginSuccess.class);
                                            j.putExtra("extra", extra);
                                            startActivity(j);
                                            finish();
                                            exists = true;


                                        }

                                    }

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

                requestQueue.add(jsonObjectRequest);
                break;

            case R.id.forgotPasswordButton:
                startActivity(new Intent(Login.this, ForgotPassword.class));
                break;
        }

    }

}
