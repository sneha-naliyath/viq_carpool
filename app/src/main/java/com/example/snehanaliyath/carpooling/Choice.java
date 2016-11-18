package com.example.snehanaliyath.carpooling;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Choice extends AppCompatActivity  implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button5 = (Button) findViewById(R.id.button5);

        button3.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.button3: Intent intent = new Intent(this, OfferRide.class);
                startActivity(intent);
                break;
            case R.id.button5: Intent intent1 = new Intent(this, FindRide.class);
                startActivity(intent1);
                break;

        }
    }
}
