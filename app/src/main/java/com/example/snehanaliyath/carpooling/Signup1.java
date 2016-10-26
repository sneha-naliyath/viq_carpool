package com.example.snehanaliyath.carpooling;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Signup1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        CheckboxGroup cg = new CheckboxGroup();
        Checkbox c1 = new Checkbox("A", false, cg);
        Checkbox c2 = new Checkbox("B", false, cg);




        boolean checked = ((CheckBox) view).isChecked();
        EditText yzEdit = (EditText) findViewById(R.id.yzEdit);

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.yzCheck:
                if (checked){
                    yzEdit.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    yzEdit.setTextIsSelectable(true);
                    yzEdit.setFocusable(true);
                    yzEdit.setFocusableInTouchMode(true);
                    yzEdit.setCursorVisible(true);
                    yzEdit.setEnabled(true);
                }
                else{
                    yzEdit.setBackgroundColor(Color.parseColor("#CCCCCC"));
                    yzEdit.setTextIsSelectable(false);
                    yzEdit.setFocusable(false);
                    yzEdit.setFocusableInTouchMode(false);
                    yzEdit.setCursorVisible(false);
                    yzEdit.setEnabled(false);
                }
                break;
        }


    }
    public void choices(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Choice.class);
           /* EditText editText = (EditText) findViewById(R.id.edi);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);*/
        startActivity(intent);

    }
}
