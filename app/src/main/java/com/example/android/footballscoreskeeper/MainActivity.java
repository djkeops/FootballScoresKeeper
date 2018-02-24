package com.example.android.footballscoreskeeper;

import android.app.Activity;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declaring TextViews.
    TextView homeTeamScoreTextView;
    TextView awayTeamScoreTextView;
    TextView homeTeamRCardsTextView;
    TextView homeTeamYCardsTextView;
    TextView awayTeamRCardsTextView;
    TextView awayTeamYCardsTextView;
    Activity activity;
    //Initializing the scores.
    private int scoreHomeTeam = 0;
    private int scoreAwayTeam = 0;
    private int rCardsHomeTeam = 0;
    private int rCardsAwayTeam = 0;
    private int yCardsHomeTeam = 0;
    private int yCardsAwayTeam = 0;

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("scoreHomeTeam", scoreHomeTeam);
        savedInstanceState.putInt("scoreAwayTeam", scoreAwayTeam);
        savedInstanceState.putInt("rCardsHomeTeam", rCardsHomeTeam);
        savedInstanceState.putInt("rCardsAwayTeam", rCardsAwayTeam);
        savedInstanceState.putInt("yCardsHomeTeam", yCardsHomeTeam);
        savedInstanceState.putInt("yCardsAwayTeam", yCardsAwayTeam);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = MainActivity.this;

        //Defining TextViews
        homeTeamScoreTextView = (TextView) findViewById(R.id.home_team_score);
        awayTeamScoreTextView = (TextView) findViewById(R.id.away_team_score);
        homeTeamRCardsTextView = (TextView) findViewById(R.id.home_team_r_cards);
        homeTeamYCardsTextView = (TextView) findViewById(R.id.home_team_y_cards);
        awayTeamRCardsTextView = (TextView) findViewById(R.id.away_team_r_cards);
        awayTeamYCardsTextView = (TextView) findViewById(R.id.away_team_y_cards);

        //Getting the values from TextView if are saved
        if (savedInstanceState != null) {
            scoreHomeTeam = savedInstanceState.getInt("scoreHomeTeam");
            scoreAwayTeam = savedInstanceState.getInt("scoreAwayTeam");
            rCardsHomeTeam = savedInstanceState.getInt("rCardsHomeTeam");
            rCardsAwayTeam = savedInstanceState.getInt("rCardsAwayTeam");
            yCardsHomeTeam = savedInstanceState.getInt("yCardsHomeTeam");
            yCardsAwayTeam = savedInstanceState.getInt("yCardsAwayTeam");
            displayScoreHomeTeam(scoreHomeTeam);
            displayScoreAwayTeam(scoreAwayTeam);
            displayRCardsHomeTeam(rCardsHomeTeam);
            displayRCardsAwayTeam(rCardsAwayTeam);
            displayYCardsHomeTeam(yCardsHomeTeam);
            displayYCardsAwayTeam(yCardsAwayTeam);
        }

    }

    /**
     * Incrementing and displaying the Score for Home Team
     *
     * @param view home_team_score
     */
    public void addScoreForHomeTeam(View view) {
        scoreHomeTeam += 1;
        displayScoreHomeTeam(scoreHomeTeam);
    }

    /**
     * Incrementing and displaying the Score for Away Team
     *
     * @param view away_team_score
     */
    public void addScoreForAwayTeam(View view) {
        scoreAwayTeam += 1;
        displayScoreAwayTeam(scoreAwayTeam);
    }

    /**
     * Incrementing and displaying the Red Cards for Home Team
     *
     * @param view home_team_r_cards
     */
    public void addRCardsForHomeTeam(View view) {
        rCardsHomeTeam += 1;
        displayRCardsHomeTeam(rCardsHomeTeam);
    }

    /**
     * Incrementing and displaying the Red Cards for Away Team
     *
     * @param view away_team_r_cards
     */
    public void addRCardsForAwayTeam(View view) {
        rCardsAwayTeam += 1;
        displayRCardsAwayTeam(rCardsAwayTeam);
    }

    /**
     * Incrementing and displaying the Yellow Cards for Home Team
     *
     * @param view home_team_y_cards
     */
    public void addYCardsForHomeTeam(View view) {
        yCardsHomeTeam += 1;
        displayYCardsHomeTeam(yCardsHomeTeam);
    }

    /**
     * Incrementing and displaying the Yellow Cards for Away Team
     *
     * @param view away_team_y_cards
     */
    public void addYCardsForAwayTeam(View view) {
        yCardsAwayTeam += 1;
        displayYCardsAwayTeam(yCardsAwayTeam);
    }

    /**
     * Resetting all scores
     *
     * @param view all Scores TextView
     */
    public void resetView(View view) {
        scoreHomeTeam = 0;
        scoreAwayTeam = 0;
        rCardsHomeTeam = 0;
        rCardsAwayTeam = 0;
        yCardsHomeTeam = 0;
        yCardsAwayTeam = 0;

        displayScoreHomeTeam(scoreHomeTeam);
        displayScoreAwayTeam(scoreAwayTeam);
        displayRCardsHomeTeam(rCardsHomeTeam);
        displayRCardsAwayTeam(rCardsAwayTeam);
        displayYCardsHomeTeam(yCardsHomeTeam);
        displayYCardsAwayTeam(yCardsAwayTeam);
    }

    /**
     * Displaying the score for Home Team and (only in Portrait mode) changing the font size according to the numbers of the characters
     *
     * @param score the new score
     */
    public void displayScoreHomeTeam(int score) {
        homeTeamScoreTextView.setText(String.valueOf(score));

        int value = activity.getResources().getConfiguration().orientation;

        if (value == Configuration.ORIENTATION_PORTRAIT) {
            if (score >= 10) {
                homeTeamScoreTextView.setTextSize(100);
            } else {
                homeTeamScoreTextView.setTextSize(140);
            }
        }
    }

    /**
     * Displaying the score for Away Team and (only in Portrait mode) changing the font size according to the numbers of the characters
     *
     * @param score the new score
     */
    public void displayScoreAwayTeam(int score) {
        awayTeamScoreTextView.setText(String.valueOf(score));

        int value = activity.getResources().getConfiguration().orientation;

        if (value == Configuration.ORIENTATION_PORTRAIT) {
            if (score >= 10) {
                awayTeamScoreTextView.setTextSize(100);
            } else {
                awayTeamScoreTextView.setTextSize(140);
            }
        }
    }

    /**
     * Displaying the Red Cards for Home Team.
     */
    public void displayRCardsHomeTeam(int score) {
        homeTeamRCardsTextView.setText(String.valueOf(score));
    }

    /**
     * Displaying the Red Cards for Away Team.
     */
    public void displayRCardsAwayTeam(int score) {
        awayTeamRCardsTextView.setText(String.valueOf(score));
    }

    /**
     * Displaying the Yellow Cards for Home Team.
     */
    public void displayYCardsHomeTeam(int score) {
        homeTeamYCardsTextView.setText(String.valueOf(score));
    }

    /**
     * Displaying the Red Cards for Away Team.
     */
    public void displayYCardsAwayTeam(int score) {
        awayTeamYCardsTextView.setText(String.valueOf(score));
    }

}
