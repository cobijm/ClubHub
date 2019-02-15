package com.example.jsonapplication;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mButton = (Button) findViewById(R.id.JSONget);
        mButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.JSONget:
                TextView txtView = (TextView) findViewById(R.id.success);
                String message = "Test";
                //Do action
                txtView.setText(message);
        }
    }

}

