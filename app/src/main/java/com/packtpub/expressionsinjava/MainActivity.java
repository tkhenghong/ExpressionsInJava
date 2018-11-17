package com.packtpub.expressionsinjava;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //first we declare and initialize few variables
        int a = 10;
        String b = "Alan Turing";
        boolean c = true;
        System.out.println("Hello systems.");
        //Let's look at how Android 'sees' these variables
        //by outputting them, one at a time to the console
        Log.i("info", "a = " + a);
        Log.i("info", "b = " + b);
        Log.i("info", "c = " + c);

        //Now let's make some changes and output them again
        a++;
        a = a + 10;
        b = b + " was smarter than the average bear Booboo";
        b = b + a;
        c = (1 + 1 == 3);//1+1 is definitely 2! So false.

        //Now to output them all again
        Log.i("info", "a = " + a);
        Log.i("info", "b = " + b);
        Log.i("info", "c = " + c);
        //start another activity
//        startActivity(new Intent(MainActivity.this, GameActivity.class));


        //Make listener like this:
        //playButton.setOnClickListener();
        Button playButton = (Button)findViewById(R.id.playButton);
        playButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // Open another Activity like this:
        Intent i;
        i = new Intent(this, GameActivity.class);
        startActivity(i);
    }
}
