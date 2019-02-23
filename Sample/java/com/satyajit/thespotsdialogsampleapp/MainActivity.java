package com.satyajit.thespotsdialogsampleapp;


import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.satyajit.thespotsdialog.SpotsDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    void DialogTerminator(final AlertDialog AD){


        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                AD.cancel();
            }
        }.start();


    }


    public void Demo1(View v){

        //This Demo shows the Default loader

       final AlertDialog dialog = new SpotsDialog.Builder()
                .setContext(this)   //Need to send the Context , from fragments you can use getApplication()
                .setCancelable(false) //Set Option to cancel when clicked outside
                .build();

        dialog.show();



        DialogTerminator(dialog);




    }

    public void Demo2(View v){

        //This Demo shows the loader with Custom Style

        final AlertDialog dialog = new SpotsDialog.Builder()
                .setContext(this)   //Need to send the Context , from fragments you can use getApplication()
                .setCancelable(false) //Set Option to cancel when clicked outside
                .setTheme(R.style.Custom) //Set the Style from Styles.xml
                .build();

        dialog.show();



        DialogTerminator(dialog);




    }

    public void Demo3(View v){


        //This uses a Custom Typeface

        Typeface typeface = Typeface.createFromAsset(this.getAssets(), "halogen.otf"); //Create a Typeface


        final AlertDialog dialog = new SpotsDialog.Builder()
                .setContext(this)   //Need to send the Context , from fragments you can use getApplication()
                .setMessage("Using Custom Typeface...") //Set Custom Text
                .setTypeface(typeface)  //Set the Typeface
                .setCancelable(false) //Set Option to cancel when clicked outside
                .build();

        dialog.show();



    DialogTerminator(dialog);




    }

    public void Github(View v){

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/satyajiit/TheSpotsDialog"));
        startActivity(browserIntent);


    }


}


