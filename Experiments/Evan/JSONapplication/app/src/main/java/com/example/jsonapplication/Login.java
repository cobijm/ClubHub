package com.example.jsonapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private Context mContext;
    private String mJSONURLString = "http://cs309-pp-4.misc.iastate.edu:8080/usersid";
    private String postmanTest = "https://0ea88006-bc29-40d9-8155-873d2ed83f3c.mock.pstmn.io/registration";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button oButton = (Button) findViewById(R.id.btnLogin);
        oButton.setOnClickListener(this);

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
                                    JSONArray array = response.getJSONArray("student");

                                    //Change upper bound of for loop to array.length() to print all values
                                    for (int i = 0; i < array.length(); i++) {
                                        // Get current json object
                                        JSONObject student = array.getJSONObject(i);

                                        // Get the current student (json object) data
                                        String netid = student.getString("netid");
                                        String password = student.getString("password");

                                        //Toast.makeText(getApplicationContext(), netid + password, Toast.LENGTH_LONG).show();
                                        boolean checked = false;

                                        if(netid.equals(netIDInput) && password.equals(passInput)){
                                            checked = true;
                                            Bundle extra = new Bundle();
                                            String user = netIDInput;
                                            extra.putSerializable("user", user);

                                            Intent j = new Intent(getApplicationContext(), LoginSuccess.class);
                                            j.putExtra("extra", extra);
                                            startActivity(j);

//                                            startActivity(new Intent(getApplicationContext(), LoginSuccess.class));

                                        }

                                        else{
                                            if(checked == false){
                                                Toast.makeText(getApplicationContext(), "Login Failed ", Toast.LENGTH_LONG).show();
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
//                // Add JsonObjectRequest to the RequestQueue
//                requestQueue.add(jsonObjectRequest);
//                String url = "https://0ea88006-bc29-40d9-8155-873d2ed83f3c.mock.pstmn.io/registration";
//                StringRequest postRequest = new StringRequest(Request.Method.POST, url,
//                        new Response.Listener<String>()
//                        {
//                            @Override
//                            public void onResponse(String response) {
//                                // response
//                                Log.d("Response", response);
//                            }
//                        },
//                        new Response.ErrorListener()
//                        {
//                            @Override
//                            public void onErrorResponse(VolleyError error) {
//                                // error
//                                //Log.d("Error.Response", error);
//                            }
//                        }
//                ) {
//                    @Override
//                    protected Map<String, String> getParams()
//                    {
//                        Map<String, String>  params = new HashMap<String, String>();
//                        params.put("id", IDInput);
//                        params.put("name", nameInput);
//                        params.put("description", descriptionInput);
//
//                        return params;
//                    }
//                };
//                queue.add(postRequest);

                requestQueue.add(jsonObjectRequest);
                break;

        }

    }

}
