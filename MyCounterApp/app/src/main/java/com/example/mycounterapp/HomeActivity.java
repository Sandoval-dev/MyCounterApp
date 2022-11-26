package com.example.mycounterapp;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Set;

public class HomeActivity extends AppCompatActivity {

    TextView value;
    Button minus,plus,ayar;
    int upperLimit;
    int lowerLimit;
    int currentValue;

    boolean upperVib;
    boolean upperSound;
    boolean lowerVib;
    boolean lowerSound;

    SetupClass setupClass;
    Vibrator vibrator=null;
    MediaPlayer mediaPlayer=null;





    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_VOLUME_UP) {
            if (currentValue<upperLimit) {
                currentValue += 5;
                value.setText(String.valueOf(currentValue));
            }
            else{
                vibrator.vibrate(1000);
                Log.d("----------------","Titreşim Başarılı");
                mediaPlayer.start();
            }
        }

        if (keyCode==KeyEvent.KEYCODE_VOLUME_DOWN){
            if (currentValue>lowerLimit) {
                currentValue -= 5;
                value.setText(String.valueOf(currentValue));
            }
            else{
                vibrator.vibrate(1000);
                Log.d("----------------","Titreşim Başarılı");
                mediaPlayer.start();
            }

        }


        return true;
    }


    @Override
    protected void onResume() {
        super.onResume();
        setupClass.loadValues();
        getPreferences();
    }

    private void getPreferences(){
        currentValue=setupClass.currentValue;
        upperLimit=setupClass.upperLimit;
        lowerLimit=setupClass.lowerLimit;
        upperVib=setupClass.upperVib;
        upperSound=setupClass.upperSound;
        lowerSound=setupClass.lowerSound;
        lowerVib=setupClass.lowerVib;
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        value=(TextView) findViewById(R.id.value);
        minus=(Button) findViewById(R.id.minus);
        plus=(Button) findViewById(R.id.plus);
        ayar=(Button) findViewById(R.id.ayar);



        Context context=getApplicationContext();
        setupClass=SetupClass.getInstance(context);

        vibrator=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        mediaPlayer=MediaPlayer.create(context,R.raw.bildirim);





        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentValue<upperLimit)
                currentValue++;
                else{
                    vibrator.vibrate(1000);
                    Log.d("----------------","Titreşim Başarılı");
                    mediaPlayer.start();

                }
                value.setText(String.valueOf(currentValue));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentValue>lowerLimit)
                currentValue--;
                else{
                    vibrator.vibrate(1000);
                    Log.d("----------------","Titreşim Başarılı");
                    mediaPlayer.start();

                }
                value.setText(String.valueOf(currentValue));
            }
        });

        ayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(HomeActivity.this,SetupActivity.class);
                startActivity(intent2);
            }
        });






    }
}