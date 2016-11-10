package com.example.snehanaliyath.carpooling;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;

import java.util.Calendar;

public class OfferRide extends AppCompatActivity implements View.OnClickListener{
    static EditText DateEdit,TimeEdit;
    ImageButton datebutton,clockbutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_ride);
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        Button button4 =(Button) findViewById(R.id.button4);

        EditText source = (EditText) findViewById(R.id.source);
        Intent intents = getIntent();
        String e1 = intents.getStringExtra("e1");
        String e1copy = e1;
        source.setText(e1copy);

        EditText destination = (EditText) findViewById(R.id.destination);
        Intent intentd = getIntent();
        String e2 = intentd.getStringExtra("e2");
        String e2copy = e2;
        destination.setText(e2copy);

        DateEdit = (EditText) findViewById(R.id.datebox);
        TimeEdit =(EditText) findViewById(R.id.clockbox);
        DateEdit.setInputType(InputType.TYPE_NULL);
        TimeEdit.setInputType(InputType.TYPE_NULL);

        datebutton = (ImageButton) findViewById(R.id.datebutton);
        clockbutton = (ImageButton) findViewById(R.id.clockbutton);



        datebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showonDatePickerDialog(v);
            }
        });
        clockbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeEdit.setText(" ");
                showonTimePickerDialog(view);
            }
        });

        button4.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        imageButton4.setOnClickListener(this);
    }
    //FOR DATE DIALOG
    public void showonDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePicker();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePicker extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(android.widget.DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            DateEdit.setText(day + "/" + (month + 1) + "/" + year);
        }
    }

    //FOR TIME DIALOG
    public void showonTimePickerDialog(View v) {
        DialogFragment newFragment = new Timepicker();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public static class Timepicker extends DialogFragment implements
            TimePickerDialog.OnTimeSetListener {

        SimpleDateFormat format ;
        java.sql.Time timeValue;
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
            try {
                String dtStart = String.valueOf(hourOfDay) + ":" + String.valueOf(minute);
                format = new SimpleDateFormat("KK:mm");
                String status="AM";

                if(hourOfDay > 12) {
                    status = "PM";
                }
                timeValue = new java.sql.Time(format.parse(dtStart).getTime());
                //TimeEdit.setText(String.valueOf(timeValue));

                TimeEdit.setText( String.valueOf(timeValue)+" "+status);
            } catch (Exception ex) {
                TimeEdit.setText(ex.getMessage().toString());
            }
        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.imageButton2: Intent intent = new Intent(this, MapsActivitysrc.class);
                startActivity(intent);
                break;
            case R.id.imageButton4: Intent intent1 = new Intent(this, MapsActivitydes.class);
                startActivity(intent1);
                break;
            case R.id.button4: Intent intent2= new Intent(this,PoolList.class);
                startActivity(intent2);
                break;

        }
    }

}
