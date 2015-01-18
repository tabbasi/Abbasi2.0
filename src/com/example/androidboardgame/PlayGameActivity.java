package com.example.androidboardgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import com.example.androidboardgame.model.*;

import java.util.Date;
import java.util.HashMap;

import android.media.MediaPlayer;
import java.util.Map;
import android.os.Vibrator;
import org.w3c.dom.Text;


/**
 * Created by Administrator on 30/12/2014.
 */
public class PlayGameActivity extends Activity {

    Game currentGame = new Game();
    Map<Integer, Button> mapP1 = new HashMap<Integer, Button>();
    Map<Integer, Button> mapP2 = new HashMap<Integer, Button>();
    String Player1Name = "Pink Player";
    String Player2Name = "Blue Player";
    MediaPlayer buttonMedia;
    Settings applicationSettings;
    private   static  int gamePlayedCounter = 0;
    private   static  int gameTiedCounter = 0;
    Boolean isMusicEnabled;
    Boolean isSoundEnabled;
    Boolean isVibrationEnabled;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playgamelayout);
        //Initiliziing Game with basic parameters .
        InitGame();
        //Applying Users Settings to Game Enviorment .
        ApplySettings(getApplicationContext());
    }

    private void ApplySettings(Context applicationContext) {
        applicationSettings = new Settings(applicationContext);
        //Checking if Music is enabled
        isMusicEnabled = applicationSettings.GetMusic();
        //Checking if sound is anabled.
        isSoundEnabled = applicationSettings.GetSound();
        //Checking if vibration is enabled .
        isVibrationEnabled = applicationSettings.GetVibration();
    }
   //Setting up player 2 with game configuration .
    private void SetupPlayer2() {
        // Player 2 button handlers

        final Button btn1Player2 = (Button) findViewById(R.id.btn1Player2);
        btn1Player2.setText("3");
        btn1Player2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

           if (((Button)v).getText().equals("0")) return;

                VibrateDevice();
                PlaySound();

                boolean playAgain = currentGame.startFromBowlP2(1);
                updateUI();
                if (CheckWinning(currentGame.checkWining())) return;
                if (playAgain) ShowAgainDialog(Player2Name);
                else SwitchPlayers(2);

            }
        });
        mapP2.put(1, btn1Player2);
        final Button btn2Player2 = (Button) findViewById(R.id.btn2Player2);
        btn2Player2.setText("3");
        btn2Player2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((Button)v).getText().equals("0")) return;

                VibrateDevice();
                PlaySound();

                boolean playAgain = currentGame.startFromBowlP2(2);
                updateUI();
                if (CheckWinning(currentGame.checkWining())) return;
                if (playAgain) ShowAgainDialog(Player2Name);
                else SwitchPlayers(2);
            }
        });
        mapP2.put(2, btn2Player2);
        final Button btn3Player2 = (Button) findViewById(R.id.btn3Player2);
        btn3Player2.setText("3");
        btn3Player2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (((Button)v).getText().equals("0")) return;

                VibrateDevice();
                PlaySound();

                boolean playAgain = currentGame.startFromBowlP2(3);
                updateUI();
                if (CheckWinning(currentGame.checkWining())) return;
                if (playAgain) ShowAgainDialog(Player2Name);
                else SwitchPlayers(2);
            }
        });
        mapP2.put(3, btn3Player2);
        final Button btn4Player2 = (Button) findViewById(R.id.btn4Player2);
        btn4Player2.setText("3");
        btn4Player2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((Button)v).getText().equals("0")) return;
                VibrateDevice();
                PlaySound();
                boolean playAgain = currentGame.startFromBowlP2(4);
                updateUI();
                if (CheckWinning(currentGame.checkWining())) return;
                if (playAgain) ShowAgainDialog(Player2Name);
                else SwitchPlayers(2);
            }
        });
        mapP2.put(4, btn4Player2);
        final Button btn5Player2 = (Button) findViewById(R.id.btn5Player2);
        btn5Player2.setText("3");
        btn5Player2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((Button)v).getText().equals("0")) return;
                VibrateDevice();
                PlaySound();
                boolean playAgain = currentGame.startFromBowlP2(5);
                updateUI();
                if (CheckWinning(currentGame.checkWining())) return;
                if (playAgain) ShowAgainDialog(Player2Name);
                else SwitchPlayers(2);
            }
        });
        mapP2.put(5, btn5Player2);
        final Button btn6Player2 = (Button) findViewById(R.id.btn6Player2);
        btn6Player2.setText("3");
        btn6Player2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((Button)v).getText().equals("0")) return;
                VibrateDevice();
                PlaySound();
                boolean playAgain = currentGame.startFromBowlP2(6);
                updateUI();
                if (CheckWinning(currentGame.checkWining())) return;
                if (playAgain) ShowAgainDialog(Player2Name);
                else SwitchPlayers(2);
            }
        });
        mapP2.put(6, btn6Player2);

        final Button trayPlayer2 = (Button) findViewById(R.id.trayPlayer2);
        trayPlayer2.setText("0");
        mapP2.put(0, trayPlayer2);
    }
//Setting Player 1
    private void SetupPlayer1() {
        // Player 1 button handlers

        final Button btn1Player1 = (Button) findViewById(R.id.btn1Player1);
        btn1Player1.setText("3");
        btn1Player1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((Button)v).getText().equals("0")) return;
                VibrateDevice();
                PlaySound();
                boolean playAgain = currentGame.startFromBowlP1(1);
                updateUI();
                if (CheckWinning(currentGame.checkWining())) return;
                if (playAgain) ShowAgainDialog(Player1Name);
                else SwitchPlayers(1);

            }
        });
        mapP1.put(1, btn1Player1);
        final Button btn2Player1 = (Button) findViewById(R.id.btn2Player1);
        btn2Player1.setText("3");
        btn2Player1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((Button)v).getText().equals("0")) return;
                VibrateDevice();
                PlaySound();
                boolean playAgain = currentGame.startFromBowlP1(2);
                updateUI();
                if (CheckWinning(currentGame.checkWining())) return;
                if (playAgain) ShowAgainDialog(Player1Name);
                else SwitchPlayers(1);
            }
        });
        mapP1.put(2, btn2Player1);
        final Button btn3Player1 = (Button) findViewById(R.id.btn3Player1);
        btn3Player1.setText("3");
        btn3Player1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((Button)v).getText().equals("0")) return;
                VibrateDevice();
                PlaySound();
                boolean playAgain = currentGame.startFromBowlP1(3);
                updateUI();
                if (CheckWinning(currentGame.checkWining())) return;
                if (playAgain) ShowAgainDialog(Player1Name);
                else SwitchPlayers(1);
            }
        });
        mapP1.put(3, btn3Player1);
        final Button btn4Player1 = (Button) findViewById(R.id.btn4Player1);
        btn4Player1.setText("3");
        btn4Player1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((Button)v).getText().equals("0")) return;
                VibrateDevice();
                PlaySound();
                boolean playAgain = currentGame.startFromBowlP1(4);
                updateUI();
                if (CheckWinning(currentGame.checkWining())) return;
                if (playAgain) ShowAgainDialog(Player1Name);
                else SwitchPlayers(1);
            }
        });
        mapP1.put(4, btn4Player1);
        final Button btn5Player1 = (Button) findViewById(R.id.btn5Player1);
        btn5Player1.setText("3");
        btn5Player1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((Button)v).getText().equals("0")) return;
                VibrateDevice();
                PlaySound();
                boolean playAgain = currentGame.startFromBowlP1(5);
                updateUI();
                if (CheckWinning(currentGame.checkWining())) return;
                if (playAgain) ShowAgainDialog(Player1Name);
                else SwitchPlayers(1);
            }
        });
        mapP1.put(5, btn5Player1);
        final Button btn6Player1 = (Button) findViewById(R.id.btn6Player1);
        btn6Player1.setText("3");
        btn6Player1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((Button)v).getText().equals("0")) return;
                VibrateDevice();
                PlaySound();
                boolean playAgain = currentGame.startFromBowlP1(6);
                updateUI();
                if (CheckWinning(currentGame.checkWining())) return;
                if (playAgain) ShowAgainDialog(Player1Name);
                else SwitchPlayers(1);
            }
        });
        mapP1.put(6, btn6Player1);

        final Button trayPlayer1 = (Button) findViewById(R.id.trayPlayer1);
        trayPlayer1.setText("0");
        mapP1.put(0, trayPlayer1);
    }


//Checks which palyer is winning
    private boolean CheckWinning(int playerNumber) {
        if (playerNumber == 0) {
            return false;
        }
        if (playerNumber == 1) {
            CreateWinningDialog(Player1Name);
            SetHighScore(Player1Name, Utils.GetStringFromDate(new Date()), currentGame.getPlayer1Score() );
            //gamePlayedCounter += 1;
            gamePlayedCounter = HighScoreManager.getInstance(getApplicationContext()).getTotalNumberOfGamesPlayed();
            //Conter will always incremented when a game finishes and save it to settings it will keep track of number of played games .
            SetTotalGamesPlayed(gamePlayedCounter+1);
            return true;
        }
        if (playerNumber == 2) {
            CreateWinningDialog(Player2Name);
            SetHighScore(Player2Name, Utils.GetStringFromDate(new Date()), currentGame.getPlayer2Score() );
            //gamePlayedCounter += 1;
            gamePlayedCounter = HighScoreManager.getInstance(getApplicationContext()).getTotalNumberOfGamesPlayed();
            SetTotalGamesPlayed(gamePlayedCounter+1);
            return true;
        }
        if (playerNumber == -1) {
            CreateWinningDialog(Player1Name, Player2Name);
            SetHighScore(Player1Name, Utils.GetStringFromDate(new Date()), currentGame.getPlayer1Score() );
            SetHighScore(Player2Name, Utils.GetStringFromDate(new Date()), currentGame.getPlayer2Score() );
            //gamePlayedCounter += 1;
            gamePlayedCounter = HighScoreManager.getInstance(getApplicationContext()).getTotalNumberOfGamesPlayed();
            SetTotalGamesPlayed(gamePlayedCounter+1);
            SetTotalGamesTied(gameTiedCounter+1);
            return true;
        }
        return false;
    }
    //Getting player score here with player name and date time .
    private void SetHighScore(String playerName, String dateTimeString, int playerScore) {
        Score score = new Score();
        score.setDateTimeString(dateTimeString);
        score.setPlayerName(playerName);
        score.setScore(playerScore);
        HighScoreManager.getInstance(getApplicationContext()).putHighScore(score);
        HighScoreManager.getInstance(getApplicationContext()).storeHighScoresToPreferences(getApplicationContext());
    }
    private void SetTotalGamesPlayed(int totalGamesPlayed)
    {
        GameStatistics totGamesPlayed = new GameStatistics();
        //Setting total games played.
        totGamesPlayed.setTotalNumberOfGamesPlayed(totalGamesPlayed);

        HighScoreManager.getInstance(getApplicationContext()).setTotalGamesPlayed(totGamesPlayed);
        //Saving Total games played to settings Shared preferences
        HighScoreManager.getInstance(getApplicationContext()).storeTotalNumberOfGamesPlayedToPreferences(getApplicationContext());
    }
    //Getting total number of tied games .
    private void SetTotalGamesTied(int totalGamesTied)
    {
        GameStatistics totGameTied = new GameStatistics();
        totGameTied.setTotalNumberOfTied(totalGamesTied);
        HighScoreManager.getInstance(getApplicationContext()).setTotalGamesTied(totGameTied);
        HighScoreManager.getInstance(getApplicationContext()).storeTotalNumberOfTiedGamesToPreferences(getApplicationContext());
    }
    //Create a dialog box which pops on winning if shows name of player who wins
    private void CreateWinningDialog(String player1Name, String player2Name) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // set title
        alertDialogBuilder.setTitle("Game Finished");

        // set dialog message
        alertDialogBuilder
                .setMessage("The game is tied between " + player1Name + " & " + player2Name
                        + "\r\n Want to play again?").setCancelable(false)
                .setPositiveButton("YES, WHY NOT.", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        InitGame();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
   //Dialog box if player 2 wins
    private void CreateWinningDialog(String playerName) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // set title
        alertDialogBuilder.setTitle("Game Finished");
        // set dialog message
        alertDialogBuilder
                .setMessage(playerName + " wins" + "\r\n Want to play again?").setCancelable(false)
                .setPositiveButton("YES, WHY NOT.", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        InitGame();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
   //Game initilizing parameters
    private void InitGame() {
        mapP1.clear();
        mapP2.clear();
        currentGame.init();
        setupBackButton();
        SetupPlayer1();
        SetupPlayer2();
        SetupPlayerText();
        //Swith palyers on turns.
        SwitchPlayers(2); // Enable Player 1 & Disable Player 2
    }
   //Players text and colors
    private void SetupPlayerText() {
        TextView player1NameTextView = (TextView) findViewById(R.id.textPlayer1);
        String textPlayer1 = String.format("<font color=#ffffff>Player 1:</font> <font color=#FF6699>%s</font>", Player1Name);
        player1NameTextView.setText(Html.fromHtml(textPlayer1));

        TextView player2NameTextView = (TextView) findViewById(R.id.textPlayer2);
        String textPlayer2 = String.format("<font color=#ffffff>Player 2:</font> <font color=#33CCFF>%s</font>", Player2Name);
        player2NameTextView.setText(Html.fromHtml(textPlayer2));
    }

    private void setupBackButton() {
        // Back button handler
        final Button backToMain = (Button) findViewById(R.id.btnBackPlayGame);
        backToMain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BackToMain(v);
            }
        });
    }
   //switching players on turns
    private void SwitchPlayers(int playerNumber) {
        if (playerNumber == 1) {
            DisablePlayer(1);
            EnablePlayer(2);

        } else if (playerNumber == 2) {
            DisablePlayer(2);
            EnablePlayer(1);

        }
    }
//Disabling player after its turn.
    private void DisablePlayer(int playerNumber) {
        if (playerNumber == 1) {
            for (Map.Entry<Integer, Button> button : mapP1.entrySet()) {
                (button.getValue()).setBackground(getResources().getDrawable(R.drawable.disabled));
                (button.getValue()).setEnabled(false);

            }
        } else if (playerNumber == 2) {
            for (Map.Entry<Integer, Button> button : mapP2.entrySet()) {
                (button.getValue()).setBackground(getResources().getDrawable(R.drawable.disabled));
                (button.getValue()).setEnabled(false);

            }
        }
    }
 //Play game again dialog .
    private void ShowAgainDialog(String playerName) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // set title
        alertDialogBuilder.setTitle("Play Again");
        // set dialog message
        alertDialogBuilder
                .setMessage("Play again " + playerName).setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
   //Enabling player to play its turn .
    private void EnablePlayer(int playerNumber) {
        if (playerNumber == 1) {
            for (Map.Entry<Integer, Button> button : mapP1.entrySet()) {
                if (button.getKey() == 0) {
                    (button.getValue()).setBackground(getResources().getDrawable(R.drawable.pinktray));

                } else
                    (button.getValue()).setBackground(getResources().getDrawable(R.drawable.pinkbowl));
                (button.getValue()).setEnabled(true);
            }
        } else if (playerNumber == 2) {
            for (Map.Entry<Integer, Button> button : mapP2.entrySet()) {
                if (button.getKey() == 0) {
                    (button.getValue()).setBackground(getResources().getDrawable(R.drawable.bluetray));
                } else
                    (button.getValue()).setBackground(getResources().getDrawable(R.drawable.bluebowl));
                (button.getValue()).setEnabled(true);
            }
        }
    }
//Updating UI with score and bowls with number of seeds.
    private void updateUI() {

        for (Bowl b : currentGame.bowls) {
            UpdateControlText(b.getPlayerId(), b.getId(), (b.getSeeds() + ""));
        }
        for (Bowl b : currentGame.bowls2) {
            UpdateControlText(b.getPlayerId(), b.getId(), b.getSeeds() + "");
        }

    }
   //Setting up controls text .
    private void UpdateControlText(int playerId, int bowlId, String seeds) {
        switch (playerId) {
            case 1:
                mapP1.get(bowlId).setText(seeds);
                break;
            case 2:
                mapP2.get(bowlId).setText(seeds);
                break;
        }
    }
    //Back to Main Activity
    public void BackToMain(View View) {
        finish();
    }
    //Vibrate device on Button click .
    public void VibrateDevice()
    {
        if (!isVibrationEnabled) return;
        Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        vib.vibrate(200);
    }
    //Plays sound on Button Click
    public void PlaySound()
    {
        if (!isSoundEnabled) return;
        //play sounds here
        buttonMedia = MediaPlayer.create(getApplicationContext() , R.raw.buttonmusc);
        buttonMedia.start();
    }

}
