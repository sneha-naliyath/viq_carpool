package com.example.snehanaliyath.carpooling;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Choice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
    }
    public void offer(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, OfferRide.class);
           /* EditText editText = (EditText) findViewById(R.id.edi);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);*/
        startActivity(intent);

    }
}