package com.example.androidboardgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.androidboardgame.model.GameStatistics;
import com.example.androidboardgame.model.HighScoreManager;
import com.example.androidboardgame.model.GameStatistics;

import java.util.ArrayList;

/**
 * Created by administrator on 14/01/2015.
 */
//This class responsible for getting total Number of Games played .
public class NumberOfGamesPlayedAndTiedActivity extends Activity {
    private LinearLayout layoutForTotalNumberOfGamesPlayed;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics_activity);

        HighScoreManager highScoreManager = HighScoreManager.getInstance(getApplicationContext());
        //Getting Total Number of Games palyed and putting it in string
        String  totalNumberOfGamesPlayed = highScoreManager.getTotGamesPlayed().getTotalNumberOfGamesPlayed() + "";
        //Displaying TotalNumber of Games played on TextView .
        TextView totalGamesPlayedTextView = (TextView) findViewById(R.id.txtTotalPlayedGames);
        totalGamesPlayedTextView.setText(totalNumberOfGamesPlayed);
    }
}
