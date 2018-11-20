package com.packtpub.expressionsinjava;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity; //Cannot use this
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends Activity implements View.OnClickListener {

    TextView textObjectPartA;
    TextView textObjectPartB;
    Button buttonObjectChoice1;
    Button buttonObjectChoice2;
    Button buttonObjectChoice3;

    TextView textObjectScore;
    TextView textObjectLevel;

    int currentScore = 0;
    int currentLevel = 1;

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
        textObjectScore = (TextView) findViewById(R.id.textScore);
        textObjectLevel = (TextView) findViewById(R.id.textLevel);
        buttonObjectChoice1 = (Button) findViewById(R.id.buttonChoice1);
        buttonObjectChoice2 = (Button) findViewById(R.id.buttonChoice2);
        buttonObjectChoice3 = (Button) findViewById(R.id.buttonChoice3);


        buttonObjectChoice1.setOnClickListener(this);
        buttonObjectChoice2.setOnClickListener(this);
        buttonObjectChoice3.setOnClickListener(this);
        setQuestion();
    }// onCreate ends here

    @Override
    public void onClick(View v) {
        int answerGiven = 0;
        switch (v.getId()) {
            case R.id.buttonChoice1:
                //initialize a new int with the value contained in
                //Remember we put it there ourselves previously
                answerGiven = Integer.parseInt("" +
                        buttonObjectChoice1.getText());

                break;
            case R.id.buttonChoice2:
                //same as previous case but using the next button
                answerGiven = Integer.parseInt("" +
                        buttonObjectChoice2.getText());

                break;
            case R.id.buttonChoice3:
                //same as previous case but using the next button
                answerGiven = Integer.parseInt("" +
                        buttonObjectChoice3.getText());

                break;
        }

        updateScoreAndLevel(answerGiven);
        setQuestion();
    }

    void setQuestion() {
        //generate the parts of the question
        int numberRange = currentLevel * 3;
        Random randInt = new Random();
        int partA = randInt.nextInt(numberRange);
        partA++;//don't want a zero value
        int partB = randInt.nextInt(numberRange);
        partB++;//don't want a zero value

        correctAnswer = partA * partB;
        int wrongAnswer1 = correctAnswer - 2;
        int wrongAnswer2 = correctAnswer + 2;
        textObjectPartA.setText("" + partA);
        textObjectPartB.setText("" + partB);

        //set the multi choice buttons

        //A number between 0 and 2
        int buttonLayout = randInt.nextInt(3);
        switch (buttonLayout) {
            case 0:
                buttonObjectChoice1.setText("" + correctAnswer);
                buttonObjectChoice2.setText("" + wrongAnswer1);
                buttonObjectChoice3.setText("" + wrongAnswer2);
                break;
            case 1:
                buttonObjectChoice2.setText("" + correctAnswer);
                buttonObjectChoice3.setText("" + wrongAnswer1);
                buttonObjectChoice1.setText("" + wrongAnswer2);
                break;
            case 2:
                buttonObjectChoice3.setText("" + correctAnswer);
                buttonObjectChoice1.setText("" + wrongAnswer1);
                buttonObjectChoice2.setText("" + wrongAnswer2);
                break;
        }
    }

    void updateScoreAndLevel(int answerGiven) {
        if (isCorrect(answerGiven)) {
            for (int i = 1; i <= currentLevel; i++) {
                currentScore = currentScore + i;
            }
            currentLevel++;
        } else {
            currentScore = 0;
            currentLevel = 1;
        }

        //Actually update the two TextViews
        textObjectScore.setText("Score: " + currentScore);
        textObjectLevel.setText("Level: " + currentLevel);
    }

    boolean isCorrect(int answerGiven) {
        boolean correctTrueOrFalse;
        if (answerGiven == correctAnswer) {//YAY!
            Toast.makeText(getApplicationContext(), "Well done!",
                    Toast.LENGTH_LONG).show();
            correctTrueOrFalse = true;
        } else {//Uh-oh!
            Toast.makeText(getApplicationContext(), "Sorry",
                    Toast.LENGTH_LONG).show();
            correctTrueOrFalse = false;
        }
        return correctTrueOrFalse;
    }
}
