package com.example.androidboardgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.androidboardgame.model.HighScoreManager;
import com.example.androidboardgame.model.Score;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by administrator on 12/01/2015.
 */
public class HighScoreActivity extends Activity {

    private LinearLayout layoutForHighScore;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore_activity);
        layoutForHighScore = (LinearLayout) findViewById(R.id.highscorelist);
        CreateHighScoreLayout(layoutForHighScore);
    }

    private void CreateHighScoreLayout(LinearLayout layoutForHighScore) {
        HighScoreManager highScoreManager = HighScoreManager.getInstance(getApplicationContext());
        ArrayList<Score> scores = highScoreManager.getScore();
        for(Score score : scores){
            layoutForHighScore.addView(GetViewForScore(score));
        }
    }

    private View GetViewForScore(Score score){
        TextView textView = new TextView(getApplicationContext());
        textView.setText(GetTextForScore(score));
        textView.setTextSize(20f);
        return textView;
    }

    private String GetTextForScore(Score score) {
        String textToSet;
        textToSet = String.format("%s : %s : %s", score.getDateTimeString(), score.getPlayerName(), score.getScore());
        return textToSet;
    }

}