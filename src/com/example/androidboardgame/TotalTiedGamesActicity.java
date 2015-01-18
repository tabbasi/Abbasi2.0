package com.example.androidboardgame;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.androidboardgame.model.HighScoreManager;

/**
 * Created by administrator on 17/01/2015.
 */
//This class is responsible for total games tied .
public class TotalTiedGamesActicity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.totalties_activity);
        HighScoreManager highScoreManager = HighScoreManager.getInstance(getApplicationContext());
        //Getting number of games tied .
        String  totalNumberOfGamesTied = highScoreManager.getTotalTies().getTotalNumberOfTied() + "";
        //Setting number of games tied with UI
        TextView totalGamesPlayedTextView = (TextView) findViewById(R.id.labelTotalGamesTied);
        totalGamesPlayedTextView.setText(totalNumberOfGamesTied);
    }
}
