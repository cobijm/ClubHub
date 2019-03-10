package com.example.ClubHub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

                EditText idEdit = (EditText)findViewById(R.id.registrationID);
                final String idInput = idEdit.getText().toString();

                EditText netIDEdit = (EditText)findViewById(R.id.registrationNetID);
                final String netIDinput = netIDEdit.getText().toString();

                EditText firstNameEdit = (EditText)findViewById(R.id.registrationFirstName);
                final String firstNameInput = firstNameEdit.getText().toString();

                EditText lastNameEdit = (EditText)findViewById(R.id.registrationLastName);
                final String lastNameInput = lastNameEdit.getText().toString();

                EditText classificationEdit = (EditText)findViewById(R.id.registrationClassification);
                final String classificationInput = classificationEdit.getText().toString();

                EditText phoneNumberEdit = (EditText)findViewById(R.id.registrationPhoneNumber);
                final String phoneNumberInput = phoneNumberEdit.getText().toString();

                EditText majorEdit = (EditText)findViewById(R.id.registrationMajor);
                final String majorInput = majorEdit.getText().toString();

                EditText passwordEdit = (EditText)findViewById(R.id.registrationPassword);
                final String passwordInput = passwordEdit.getText().toString();

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mJSONURLString, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                int alreadyTaken = 0;
                                // Do something with response
                                try {
                                    // Get JSON object
                                    JSONArray array = response.getJSONArray("user");

                                    //Change upper bound of for loop to array.length() to print all values
                                    for (int i = 0; i < array.length(); i++) {
                                        // Get current json object
                                        JSONObject currentStudent = array.getJSONObject(i);

                                        // Get the current student (json object) data
                                        String id = currentStudent.getString("id");
                                        String netid = currentStudent.getString("netid");
                                        String firstName = currentStudent.getString("firstName");
                                        String lastName = currentStudent.getString("lastName");
                                        String classification = currentStudent.getString("classification");
                                        String phoneNumber = currentStudent.getString("phoneNumber");
                                        String major = currentStudent.getString("major");
                                        String password = currentStudent.getString("password");

                                        if(netid.equals(netIDinput)){
                                            Toast.makeText(getApplicationContext(), "NetID Already Registered", Toast.LENGTH_LONG).show();
                                            alreadyTaken = 1;
                                        }
                                    }
                                    if(alreadyTaken == 0) {
                                        postData();
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
                // Add JsonObjectRequest to the RequestQueue
                queue.add(jsonObjectRequest);

                break;
        }
    }

    public void postData(){
        RequestQueue queue = Volley.newRequestQueue(this);

        EditText idEdit = (EditText)findViewById(R.id.registrationID);
        final String idInput = idEdit.getText().toString();

        EditText netIDEdit = (EditText)findViewById(R.id.registrationNetID);
        final String netIDinput = netIDEdit.getText().toString();

        EditText firstNameEdit = (EditText)findViewById(R.id.registrationFirstName);
        final String firstNameInput = firstNameEdit.getText().toString();

        EditText lastNameEdit = (EditText)findViewById(R.id.registrationLastName);
        final String lastNameInput = lastNameEdit.getText().toString();

        EditText classificationEdit = (EditText)findViewById(R.id.registrationClassification);
        final String classificationInput = classificationEdit.getText().toString();

        EditText phoneNumberEdit = (EditText)findViewById(R.id.registrationPhoneNumber);
        final String phoneNumberInput = phoneNumberEdit.getText().toString();

        EditText majorEdit = (EditText)findViewById(R.id.registrationMajor);
        final String majorInput = majorEdit.getText().toString();

        EditText passwordEdit = (EditText)findViewById(R.id.registrationPassword);
        final String passwordInput = passwordEdit.getText().toString();

        Map<String, String> params = new HashMap();
        params.put("id", idInput);
        params.put("netid", netIDinput);
        params.put("firstName", firstNameInput);
        params.put("lastName", lastNameInput);
        params.put("classification", classificationInput);
        params.put("phoneNumber", phoneNumberInput);
        params.put("major", majorInput);
        params.put("password", passwordInput);

        JSONObject parameters = new JSONObject(params);

        String url = "http://cs309-pp-4.misc.iastate.edu:8080/usersid";
        //String url = "https://0ea88006-bc29-40d9-8155-873d2ed83f3c.mock.pstmn.io/registration";
        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, url, parameters,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // response
                        //Log.d("Response", response);
                        //Toast.makeText(getApplicationContext(), "Volley success " + response, Toast.LENGTH_LONG).show();
                        startActivity(new Intent(Registration.this, LoginSuccess.class));
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        //Log.d("Error.Response", error);
                        //Toast.makeText(getApplicationContext(), "Volley error " + error.getMessage(), Toast.LENGTH_LONG).show();
                        startActivity(new Intent(Registration.this, LoginSuccess.class));
                    }
                }
        );
        queue.add(postRequest);
    }

}
