package com.example.androidboardgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.androidboardgame.model.HighScore;

/**
 * Created by administrator on 12/01/2015.
 */
//This class is responsible to call statistics activities like How many games played . How many games tied. When last game was palyed and who won the game .
public class StatisticsActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamestatistics_activity);

        ((Button) findViewById(R.id.btnHighScore)).setOnClickListener(new
                  View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          StartHighScoreActivity();
                      }
                  });
        ((Button) findViewById(R.id.btnTotalNumbersOfGame)).setOnClickListener(new
               View.OnClickListener() {
                   @Override
                   public void onClick(View v) {

                       StartNumberOfGamesActivity();
                   }
               });
        ((Button) findViewById(R.id.btnTotalNumbersOfTied)).setOnClickListener(new
                  View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                   StartNumberOfGamesTiedActivity();
                    }
                 });
    }
    //Calls to High score Activity which checks which player got high score BluePlayer or PinkPlayer it also shows the date when games was played and keep history .
  private void StartHighScoreActivity() {
        Intent intent = new Intent(this, HighScoreActivity.class);
        startActivity(intent);
    }
    //Calls to NoOfGamesPlayed Acitvity it checks how many games played .
    private  void StartNumberOfGamesActivity()
    {
        Intent intent = new Intent(this, NumberOfGamesPlayedAndTiedActivity.class);
        startActivity(intent);
    }
    //Calls to Total Games Activity which checks how many games are tied in case no player wins.
    private  void StartNumberOfGamesTiedActivity()
    {
        Intent intent = new Intent(this, TotalTiedGamesActicity.class);
        startActivity(intent);
    }
}