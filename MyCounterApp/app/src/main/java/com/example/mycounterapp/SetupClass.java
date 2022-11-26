package com.example.mycounterapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SetupClass {
    int upperLimit;
    int lowerLimit;
    int currentValue;

    boolean upperVib;
    boolean upperSound;
    boolean lowerVib;
    boolean lowerSound;

    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    static  SetupClass setupClass=null;


    public SetupClass(Context context) {
        this.context=context;
        sharedPreferences=context.getSharedPreferences("Setup",Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();

    }

    public static SetupClass getInstance(Context context){
        if (setupClass==null) {
            setupClass = new SetupClass(context); //eğer nullsa
        }
        return setupClass;
    }

    public void setValues(int upperLimit,int lowerLimit,int currentValue,boolean upperVib,boolean upperSound, boolean lowerSound, boolean lowerVib){
        this.upperLimit=upperLimit;
        this.lowerLimit=lowerLimit;
        this.currentValue=currentValue;
        this.upperVib=upperVib;
        this.upperSound=upperSound;
        this.lowerVib=lowerVib;
        this.lowerSound=lowerSound;
    }

    public void saveValues(){
        editor.putInt("upperlimit",upperLimit);
        editor.putInt("lowerlimit",lowerLimit);
        editor.putInt("currentValue",currentValue);
        editor.putBoolean("upperVib",upperVib);
        editor.putBoolean("upperSound",upperSound);
        editor.putBoolean("lowerVib",lowerVib);
        editor.putBoolean("lowerSound",lowerSound);
        editor.commit();
    }

    public void loadValues(){
        upperLimit=sharedPreferences.getInt("upperlimit",10);
        lowerLimit=sharedPreferences.getInt("lowerlimit",0);
        currentValue=sharedPreferences.getInt("currentValue",0);
        upperVib=sharedPreferences.getBoolean("upperVib",true);
        lowerVib=sharedPreferences.getBoolean("lowerVib",true);
        upperSound=sharedPreferences.getBoolean("upperSound",true);
        lowerSound=sharedPreferences.getBoolean("lowerSound",true);

    }
}
