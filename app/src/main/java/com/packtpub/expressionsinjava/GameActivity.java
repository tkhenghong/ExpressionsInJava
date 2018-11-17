package com.packtpub.expressionsinjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textObjectPartA;
    TextView textObjectPartB;
    Button buttonObjectChoice1;
    Button buttonObjectChoice2;
    Button buttonObjectChoice3;
    int correctAnswer;
    int wrongAnswer1;
    int wrongAnswer2;

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
        textObjectPartA = (TextView) findViewById(R.id.textPartA);
        textObjectPartB = (TextView) findViewById(R.id.textPartB);
        buttonObjectChoice1 = (Button) findViewById(R.id.buttonChoice1);
        buttonObjectChoice2 = (Button) findViewById(R.id.buttonChoice2);
        buttonObjectChoice3 = (Button) findViewById(R.id.buttonChoice3);

        //Here we initialize all our variables
        int partA = 9;
        int partB = 9;
        correctAnswer = partA * partB;
        int wrongAnswer1 = correctAnswer - 1;
        int wrongAnswer2 = correctAnswer + 1;
        buttonObjectChoice1.setText("" + correctAnswer);
        buttonObjectChoice2.setText("" + wrongAnswer1);
        buttonObjectChoice3.setText("" + wrongAnswer2);

        buttonObjectChoice1.setOnClickListener(this);
        buttonObjectChoice2.setOnClickListener(this);
        buttonObjectChoice3.setOnClickListener(this);

    }// onCreate ends here

    @Override
    public void onClick(View v) {
        int answerGiven = 0;
        switch (v.getId()) {
            case R.id.buttonChoice1:
                // button 1 stuff goes here
                answerGiven = Integer.parseInt("" +
                        buttonObjectChoice1.getText());
                if (answerGiven == correctAnswer) {//yay it's the right answer
                    Toast.makeText(getApplicationContext(),
                            "Well done!",
                            Toast.LENGTH_LONG).show();
                } else {//uh oh!
                    Toast.makeText(getApplicationContext(), "Sorry that's wrong", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.buttonChoice2:
                // button 2 stuff goes here
                //same as previous case but using the next button
                answerGiven = Integer.parseInt("" +
                        buttonObjectChoice2.getText());
                if (answerGiven == correctAnswer) {
                    Toast.makeText(getApplicationContext(), "Well done!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry that's wrong", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.buttonChoice3:
                // button 3 stuff goes here
                //same as previous case but using the next button
                answerGiven = Integer.parseInt("" +
                        buttonObjectChoice3.getText());
                if (answerGiven == correctAnswer) {
                    Toast.makeText(getApplicationContext(), "Well done!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry that's wrong", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
