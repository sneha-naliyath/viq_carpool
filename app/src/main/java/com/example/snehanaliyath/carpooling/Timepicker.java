package com.example.snehanaliyath.carpooling;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Locale;

import static com.example.snehanaliyath.carpooling.OfferRide.TimeEdit;

/**
 * Created by sneha.naliyath on 09-11-2016.
 */

public  class Timepicker extends DialogFragment implements
        TimePickerDialog.OnTimeSetListener {

    SimpleDateFormat format ;
    java.sql.Time timeValue;
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);



        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // Do something with the time chosen by the user

        try {
            String dtStart = String.valueOf(hourOfDay) + ":" + String.valueOf(minute);
            format = new SimpleDateFormat("h:mm a");

            timeValue = new java.sql.Time(format.parse(dtStart).getTime());
            //TimeEdit.setText(String.valueOf(timeValue));
            String amPm = hourOfDay % 12 + ":" + minute + " " + ((hourOfDay >= 12) ? "PM" : "AM");
            TimeEdit.setText( String.valueOf(timeValue));
        } catch (Exception ex) {
            TimeEdit.setText(ex.getMessage().toString());
        }


        /*String status="AM";
        int time_12_hr_format;
        if(hourOfDay > 12)
        {
            status="PM";
            time_12_hr_format = hourOfDay-12;
        }
        else
        {
            time_12_hr_format = hourOfDay;
        }
        TimeEdit.setText(TimeEdit.getText() + " " + time_12_hr_format + ":" + minute+" " + status);*/
    }
}
