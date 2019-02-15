package com.example.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText LoginID;
    private EditText Password;
    private Button Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginID = (EditText)findViewById(R.id.loginText);
        Password = (EditText)findViewById(R.id.passText);
        Login = (Button)findViewById(R.id.btnLogin);


    }


    private void validate (String user, String pass){

        String username = LoginID.getText().toString();
        String password = Password.getText().toString();

        if((user == "team4") && (pass == "PP_4projectuser")) {
            Intent intent = new Intent(MainActivity.this, JSONRequestActivity.class);
            startActivity(intent);
        }

        if(username.isEmpty() && password.isEmpty()){
            Toast.makeText(this, "Please enter required information",Toast.LENGTH_SHORT);

        }

    }
}
