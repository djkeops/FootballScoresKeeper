package com.example.android.footballscoreskeeper;

import android.app.Activity;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * Declaring TextViews.
     * TextView home_team_score_view = (TextView) findViewById(R.id.home_team_score);
     * TextView away_team_score_view = (TextView) findViewById(R.id.away_team_score);
     * TextView home_team_r_cards_view = (TextView) findViewById(R.id.home_team_r_cards);
     * TextView away_team_r_cards_view = (TextView) findViewById(R.id.away_team_r_cards);
     * TextView home_team_y_cards_view = (TextView) findViewById(R.id.home_team_y_cards);
     * TextView away_team_y_cards_view = (TextView) findViewById(R.id.away_team_y_cards);
     */


    int scoreHomeTeam = 0;
    int scoreAwayTeam = 0;
    int rCardsHomeTeam = 0;
    int rCardsAwayTeam = 0;
    int yCardsHomeTeam = 0;
    int yCardsAwayTeam = 0;
    TextView homeTeamScoreTextView;
    TextView awayTeamScoreTextView;
    TextView homeTeamRCardsTextView;
    TextView homeTeamYCardsTextView;
    TextView awayTeamRCardsTextView;
    TextView awayTeamYCardsTextView;


    Activity activity;

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

        /**
         * Define TextViews
         */
        homeTeamScoreTextView = (TextView) findViewById(R.id.home_team_score);
        awayTeamScoreTextView = (TextView) findViewById(R.id.away_team_score);
        homeTeamRCardsTextView = (TextView) findViewById(R.id.home_team_r_cards);
        homeTeamYCardsTextView = (TextView) findViewById(R.id.home_team_y_cards);
        awayTeamRCardsTextView = (TextView) findViewById(R.id.away_team_r_cards);
        awayTeamYCardsTextView = (TextView) findViewById(R.id.away_team_y_cards);

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

    public void addScoreForHomeTeam(View view) {
        scoreHomeTeam = scoreHomeTeam + 1;
        displayScoreHomeTeam(scoreHomeTeam);
    }

    public void addScoreForAwayTeam(View view) {
        scoreAwayTeam = scoreAwayTeam + 1;
        displayScoreAwayTeam(scoreAwayTeam);
    }

    public void addRCardsForHomeTeam(View view) {
        rCardsHomeTeam = rCardsHomeTeam + 1;
        displayRCardsHomeTeam(rCardsHomeTeam);
    }

    public void addRCardsForAwayTeam(View view) {
        rCardsAwayTeam = rCardsAwayTeam + 1;
        displayRCardsAwayTeam(rCardsAwayTeam);
    }

    public void addYCardsForHomeTeam(View view) {
        yCardsHomeTeam = yCardsHomeTeam + 1;
        displayYCardsHomeTeam(yCardsHomeTeam);
    }

    public void addYCardsForAwayTeam(View view) {
        yCardsAwayTeam = yCardsAwayTeam + 1;
        displayYCardsAwayTeam(yCardsAwayTeam);
    }

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
     * Displays the given score for Home Team.
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
     * Displays the given score for Away Team.
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
     * Displays the red cards for Home Team.
     */
    public void displayRCardsHomeTeam(int score) {
        homeTeamRCardsTextView.setText(String.valueOf(score));
    }

    /**
     * Displays the red cards for Away Team.
     */
    public void displayRCardsAwayTeam(int score) {
        awayTeamRCardsTextView.setText(String.valueOf(score));
    }

    /**
     * Displays the yellow cards for Home Team.
     */
    public void displayYCardsHomeTeam(int score) {
        homeTeamYCardsTextView.setText(String.valueOf(score));
    }

    /**
     * Displays the red cards for Away Team.
     */
    public void displayYCardsAwayTeam(int score) {
        awayTeamYCardsTextView.setText(String.valueOf(score));
    }

}
