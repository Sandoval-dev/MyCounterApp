package com.example.mycounterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SetupActivity extends AppCompatActivity {

    EditText upValue,lowValue;
    Button upPlus,upMinus,lowPlus,lowMinus;
    CheckBox upVib,upVol,lowVib,lowVol;
    int upperlimit=10;
    int lowerlimit=0;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onPause() {
        super.onPause();
        upperlimit=Integer.valueOf(upValue.getText().toString());
        editor.putInt("UpperLimit",upperlimit);
        editor.commit();
        Log.d("***************",String.valueOf(upperlimit));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);




        upValue=(EditText) findViewById(R.id.up_value);
        upPlus=(Button) findViewById(R.id.up_plus);
        upMinus=(Button) findViewById(R.id.up_minus);
        lowValue=(EditText) findViewById(R.id.low_value);
        lowPlus=(Button) findViewById(R.id.low_plus);
        lowMinus=(Button) findViewById(R.id.low_minus);
        upVib=(CheckBox) findViewById(R.id.up_Vib);
        upVol=(CheckBox) findViewById(R.id.up_Vol);
        lowVib=(CheckBox) findViewById(R.id.low_Vib);
        lowVol=(CheckBox) findViewById(R.id.low_Vol);


        Context context=getApplicationContext();
        sharedPreferences=context.getSharedPreferences(context.getPackageName(),Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();

        lowValue.setText(String.valueOf(lowerlimit));
        upValue.setText(String.valueOf(upperlimit));

        upPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upperlimit++;
                upValue.setText(String.valueOf(upperlimit));
            }
        });

        upMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upperlimit--;
                upValue.setText(String.valueOf(upperlimit));
            }
        });

        lowPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lowerlimit++;
                lowValue.setText(String.valueOf(lowerlimit));
            }
        });

        lowMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lowerlimit--;
                lowValue.setText(String.valueOf(lowerlimit));
            }
        });









    }


}