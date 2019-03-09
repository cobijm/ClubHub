package com.example.ClubHub;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class LoginSuccess extends ListActivity {

    TextView text;
//
//    ArrayList<String> listItems = new ArrayList<String>();
//
//    ArrayAdapter<String> adapter;
//
//    int clickCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        String fetched = fetchUser();
        text = (TextView)findViewById(R.id.textView3);
        fetched = "Welcome back " + fetched;
        text.setText(fetched);
//        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listItems);
//        setListAdapter(adapter);



    }

    public String fetchUser(){

        Bundle extra = getIntent().getBundleExtra("extra");
        String s = "";
        if(extra != null){
            s = (String)extra.getSerializable("user");
            Log.d("Fetched user: ", s);
            return s;
        }
        else{
            Log.d("No user detected", s);
            return "";
        }
    }
//
//    public void addItems(View v){
//        listItems.add("Clicked: " + clickCounter++);
//        adapter.notifyDataSetChanged();
//    }


}
