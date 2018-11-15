package com.packtpub.expressionsinjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //The next line loads our UI design to the screen, write the wrong layout name will either open the same page or unexpected pages.
        setContentView(R.layout.activity_game);

        /*Here we get a working object based on either the button
or TextView class and base as well as link our new objects
directly to the appropriate UI elements that we created
previously*/
        // Must create them ONLY AFTER setContentView(R.layout.activity_main); because the view
        // must be created first before the objects of the UI element is created
        TextView textObjectPartA =
                (TextView)findViewById(R.id.textPartA);
        TextView textObjectPartB =
                (TextView)findViewById(R.id.textPartB);
        Button buttonObjectChoice1 =
                (Button)findViewById(R.id.buttonChoice1);
        Button buttonObjectChoice2 =
                (Button)findViewById(R.id.buttonChoice2);
        Button buttonObjectChoice3 =
                (Button)findViewById(R.id.buttonChoice3);

        //Here we initialize all our variables
        int partA = 9;
        int partB = 9;
        int correctAnswer = partA * partB;
        int wrongAnswer1 = correctAnswer - 1;
        int wrongAnswer2 = correctAnswer + 1;
        buttonObjectChoice1.setText("" + correctAnswer);


    }// onCreate ends here

}
