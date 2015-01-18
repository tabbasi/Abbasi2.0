package com.example.androidboardgame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.androidboardgame.model.BackgroundMusicService;
import com.example.androidboardgame.model.HighScoreManager;
import com.example.androidboardgame.model.Settings;

public class MainActivity extends Activity {
    private static final String EXTRA_MESSAGE = "TEST";

    MediaPlayer backgroundMusic;
    Boolean isMusicEnabled;
    Settings applicationSettings;
    public static Intent backgroundServiceIntent;
    /**
     * Called when the activity is first created.
     */

    private void ApplySettings(Context applicationContext) {
        applicationSettings = new Settings(applicationContext);
        isMusicEnabled = applicationSettings.GetMusic();

        HighScoreManager.getInstance(getApplicationContext()).loadHighScoresFromPreferences(getApplicationContext());
        HighScoreManager.getInstance(getApplicationContext()).loadTotalNumberOfGamesPlayedFromPreferences(getApplicationContext());
        HighScoreManager.getInstance(getApplicationContext()).loadTotalNumberOfGamesTiedFromPreferences(getApplicationContext());
        HighScoreManager.getInstance(getApplicationContext()).storeTotalNumberOfGamesPlayedToPreferences(getApplicationContext());
        HighScoreManager.getInstance(getApplicationContext()).storeTotalNumberOfTiedGamesToPreferences(getApplicationContext());
     }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ApplySettings(getApplicationContext());
        //Starts Music Service
        StartMusicService();
       //Shows Settings Menu
        final Button button = (Button) findViewById(R.id.btnSettings);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendMessage(v);
            }
        });
        //Show Help Menu
        final Button helpButton = (Button) findViewById(R.id.btnHelp);
        helpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ShowHelp(v);

            }
        });
        //Shows Play Game Activity
        final Button PlayGameButton = (Button) findViewById(R.id.btnPlayGame);
        PlayGameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Initilize Game
                InitilizeGame(v);

            }
        });

        ((Button) findViewById(R.id.btnGameStats)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartStatisticsActivity();
            }
        });

        //Exit from App
        final Button exitGame = (Button) findViewById(R.id.btnExit);
        exitGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                QuitGame(v);

            }
        });
    }
    //To Start Background Music Service.
    private void StartMusicService() {

        if (backgroundServiceIntent == null)
            backgroundServiceIntent = new Intent(this, BackgroundMusicService.class);

        if (!isMusicEnabled) return;

        startService(backgroundServiceIntent);
    }

    private void StartStatisticsActivity(){
        Intent intent = new Intent(this, StatisticsActivity.class);
        startActivity(intent);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, SettingsActicity.class);
        String message = "test string";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    //
    public void ShowHelp(View View){
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }
    //SetupGame in Start position
    public void InitilizeGame(View View)
    {
        Intent intent = new Intent(this, PlayGameActivity.class);
        startActivity(intent);
    }
    //To Quit from Game App
    public void QuitGame(View View)
    {
        StopMusicService();
        finish();
        System.exit(0);
    }
//  To Stop Background Music Service .
    private void StopMusicService() {

        if (backgroundServiceIntent == null) return;
        backgroundServiceIntent = new Intent(this, BackgroundMusicService.class);
        stopService(backgroundServiceIntent);
    }

}
