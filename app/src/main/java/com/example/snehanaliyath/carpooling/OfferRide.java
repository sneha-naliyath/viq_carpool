package com.example.snehanaliyath.carpooling;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class OfferRide extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_ride);
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        Button button4 =(Button) findViewById(R.id.button4);

        button4.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        imageButton4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.imageButton2: Intent intent = new Intent(this, MapsActivity.class);
                startActivity(intent);
                break;
            case R.id.imageButton4: Intent intent1 = new Intent(this, MapsActivity.class);
                startActivity(intent1);
                break;
            case R.id.button4: Intent intent2= new Intent(this,PoolList.class);
                startActivity(intent2);
                break;

        }
    }


}
