package com.example.android.scorekeeperapp;

import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    /**Global variables in forms of ints that keep score, yellow
     * and red card count for team A and B*/
    private int teamA = 0;
    private int teamB = 0;
    private int yellowcardA = 0;
    private int yellowcardB = 0;
    private int redcardA = 0;
    private int redcardB = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }
    /**Restoring saved values and showing them in TextViews using methods
     * it also saves final outcome of last game*/
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            teamA = savedInstanceState.getInt("saveGoalA");
            teamB = savedInstanceState.getInt("saveGoalB");
            yellowcardA = savedInstanceState.getInt("saveYellowA");
            yellowcardB = savedInstanceState.getInt("saveYellowB");
            redcardA = savedInstanceState.getInt("saveRedA");
            redcardB = savedInstanceState.getInt("saveRedB");
            String lastGameStringBackup = savedInstanceState.getString("finalString");
            TextView lastScoreTextBackup = (TextView) findViewById(R.id.lastGameScore);
            lastScoreTextBackup.setText(lastGameStringBackup);
            displayScoreTeamA(teamA);
            displayScoreTeamB(teamB);
            displayYellowA(yellowcardA);
            displayYellowB(yellowcardB);
            displayRedA(redcardA);
            displayRedB(redcardB);
        }
    }
    /**Saving int values of score from global ints
     * when screen is rotating*/
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("saveGoalA", teamA);
        savedInstanceState.putInt("saveGoalB", teamB);
        savedInstanceState.putInt("saveYellowA", yellowcardA);
        savedInstanceState.putInt("saveYellowB", yellowcardB);
        savedInstanceState.putInt("saveRedA", redcardA);
        savedInstanceState.putInt("saveRedB", redcardB);
        TextView lastScoreText = (TextView) findViewById(R.id.lastGameScore);
        String lastGameString = lastScoreText.getText().toString();
        savedInstanceState.putString("finalString", lastGameString);
        super.onSaveInstanceState(savedInstanceState);
    }
    /**Method that displays score for Team A
     * taking @scoreForTeamA as input*/
    private void displayScoreTeamA (int scoreForTeamA) {
        TextView scoreViewA = (TextView) findViewById(R.id.scoreTeamA);
        scoreViewA.setText(String.valueOf(scoreForTeamA));
    }
    /**Method that displays score for Team B
     * taking int @scoreForTeamB as input*/
    private void displayScoreTeamB (int scoreForTeamB) {
        TextView scoreViewB = (TextView) findViewById(R.id.scoreTeamB);
        scoreViewB.setText(String.valueOf(scoreForTeamB));
    }
    /**Method that displays number of yellow cards
     * for Team A taking int @yellowForA as input*/
    private void displayYellowA (int yellowForA) {
        TextView yellowAView = (TextView) findViewById(R.id.yellowA);
        yellowAView.setText(String.valueOf(yellowForA));
    }
    /**Method that displays number of red cards
     * for Team A taking int @redForA as input*/
    private void displayRedA (int redForA) {
        TextView redAView = (TextView) findViewById(R.id.redscoreA);
        redAView.setText(String.valueOf(redForA));
    }
    /**Method that displays number of yellow cards
     * for Team B taking int @yellowForB as input*/
    private void displayYellowB (int yellowForB) {
        TextView yellowBView = (TextView) findViewById(R.id.yellowB);
        yellowBView.setText(String.valueOf(yellowForB));
    }
    /**Method that displays number of red cards
     * for Team B taking int @redForB as input*/
    private void displayRedB (int redForB) {
        TextView redBView = (TextView) findViewById(R.id.redscoreB);
        redBView.setText(String.valueOf(redForB));
    }
    /**Method that adds one Goal for Team A and calls a method
     * displayScoreTeamA to show it in TextView*/
    public void goalForA (View view) {
        teamA++;
        displayScoreTeamA(teamA);
    }
    /**Method that adds one yellow card for Team A and calls a method
     * displayYellowA to show it in TextView*/
    public void yellowForA (View view) {
        yellowcardA ++;
        displayYellowA(yellowcardA);
    }
    /**Method that adds one red card for Team A and calls a method
     * displayRedB to show it in TextView*/
    public void redForA (View view) {
        redcardA ++;
        displayRedA(redcardA);
    }
    /**Method that adds one Goal for Team B and calls a method
     * goalForB to show it in TextView*/
    public void goalForB (View view) {
        teamB ++;
        displayScoreTeamB(teamB);
    }
    /**Method that adds one yellow card for Team B and calls a method
     * yellowForB to show it in TextView*/
    public void yellowForB (View view) {
        yellowcardB ++;
        displayYellowB(yellowcardB);
    }
    /**Method that adds one red card for Team B and calls a method
     * redForB to show it in TextView*/
    public void redForB (View view) {
        redcardB ++;
        displayRedB(redcardB);
    }
    /**Show final result of the game depending on what score is
     * and then resets score to display 0 for new game**/
    public void resetButton (View view) {
        TextView finalScore = (TextView) findViewById(R.id.lastGameScore);
        if (teamA > teamB) {
            Toast.makeText(getApplicationContext(), "Team A won. Congrats !!!", Toast.LENGTH_SHORT).show();
            finalScore.setText(R.string.lastGameA);
        }
        else if (teamB > teamA) {
            Toast.makeText(getApplicationContext(), "TeamB won. Wooo hooo", Toast.LENGTH_SHORT).show();
            finalScore.setText(R.string.lastGameB);
        }
        else {
            Toast.makeText(getApplicationContext(), "It`s a draw o_O", Toast.LENGTH_SHORT).show();
            finalScore.setText(R.string.lastGameDraw);
        }
        teamA = 0;
        teamB = 0;
        yellowcardB = 0;
        yellowcardA = 0;
        redcardA = 0;
        redcardB = 0;
        displayScoreTeamA(teamA);
        displayScoreTeamB(teamB);
        displayRedA(redcardA);
        displayRedB(redcardB);
        displayYellowA(yellowcardA);
        displayYellowB(yellowcardB);
    }
}
