package com.example.demoproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String text = "";
    String password="";
    TextView passwordLabel;
    String savedPassword="1P2L3P";
    int orientation ;
    String anotherSavedPassword="4P5P6P";
    long startTime;

    public void one(View view){
    text+="1";
    password+="1";
    Activity activity = MainActivity.this;
    addOrientation(activity);
    }
    public void two(View view){
        text+="2";
        password+="2";
        Activity activity = MainActivity.this;
        addOrientation(activity);
    }
    public void three(View view){
        text+="3";
        password+="3";
        Activity activity = MainActivity.this;
        addOrientation(activity);
    }
    public void four(View view){
        text+="4";
        password+="4";
        Activity activity = MainActivity.this;
        addOrientation(activity);
    }
    public void five(View view){
        text+="5";
        password+="5";
        Activity activity = MainActivity.this;
        addOrientation(activity);
    }
    public void six(View view){
        text+="6";
        password+="6";
        Activity activity = MainActivity.this;
        addOrientation(activity);
    }
    public void seven(View view){
        text+="7";
        password+="7";
        Activity activity = MainActivity.this;
        addOrientation(activity);
    }
    public void eight(View view){
        text+="8";
        password+="8";
        Activity activity = MainActivity.this;
        addOrientation(activity);
    }
    public void nine(View view){
        text+="9";
        password+="9";
        Activity activity = MainActivity.this;
        addOrientation(activity);
    }
    public void zero(View view){
        text+="0";
        password+="0";
        Activity activity = MainActivity.this;
        addOrientation(activity);
    }
    public void clear(View view){
        text="";
        password="";
        passwordLabel.setText("");
        startTime = System.currentTimeMillis();
    }
    public void send(View view){
        Log.i("ActualPassword",password);
        if(password.equals(savedPassword))
            passwordLabel.setText("Login Successfull");
        else if(password.equals(anotherSavedPassword)){
            long elapsedTime = (System.currentTimeMillis()-startTime)/1000;
            Log.i("ActualTime",elapsedTime+"");
            if(elapsedTime>2 && elapsedTime<5)
                passwordLabel.setText("Login Successfull");
            else
                passwordLabel.setText("Unsuccesfull!!");
        }
        else
            passwordLabel.setText("Unsuccesfull!!");
        startTime = System.currentTimeMillis();
    }
    public void addOrientation(Activity activity){
        orientation = activity.getResources().getConfiguration().orientation;
        Log.i("ADD_Orientation",orientation+"");
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            password+="L";
        } else {
            password += "P";
        }
        passwordLabel.setText(text);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putString("password", password);
        savedInstanceState.putString("text",text);
        savedInstanceState.putLong("startTime",startTime);
        // etc.

        super.onSaveInstanceState(savedInstanceState);
    }

//onRestoreInstanceState

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.


        password = savedInstanceState.getString("password");
        text = savedInstanceState.getString("text");
        passwordLabel.setText(text);
        startTime = savedInstanceState.getLong("startTime");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        passwordLabel = (TextView) findViewById(R.id.textView2);

    }
}