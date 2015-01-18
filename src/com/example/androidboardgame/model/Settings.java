package com.example.androidboardgame.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;


/**
 * Created by administrator on 08/01/2015.
 */
public class Settings {
    public static final String MyPREFERENCES = "ABOARDGAMESETTINGS" ;

    private HighScore hiScoreObject;
    private GameStatistics totalGamesPlayedObject;
    private static final String HISCORE_KEY = "hiscoreKey";
    private static final String TOTALGAMESpLAYED = "totalGamesPlayed";
    private static final String TOTALGAMESTIED = "totalGamesTid";
    public final String Music = "musicKey";
    public final String Sound = "soundKey";
    public final String Vibration = "vibrationKey";
    public final String WinnerPlayer = "winnningPlayer";
    public final String NumberofGamesPlayed ="numberOfGamesPlayed" ;
    public final String GamePlayedOn = "GamePlayedOn";
    public static Context contextOfApplication;

    SharedPreferences sharedpreferences;

    public Settings(Context context){
        contextOfApplication = context;
        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(contextOfApplication);
    }

    public HighScore GetHighScore(){
        String hiScoreString = GetHighScoreFromSP();
        if (hiScoreString.equals("null")) {
            hiScoreObject = HighScoreManager.getInstance(contextOfApplication).getHighScores();
            SetHighScore(hiScoreObject);
        } else {
            hiScoreObject = Utils.convertStringToHiScore(hiScoreString);
            HighScoreManager.getInstance(contextOfApplication).setHighScore(hiScoreObject);
        }
        // retrieve high scores from HighScoreManager
        return hiScoreObject;
    }

public GameStatistics GetTotalGamesPlayed()
{
    String totalGamesString = GetTotalNumberofGamesPlayed();
    if(totalGamesString.equals("null")){
     totalGamesPlayedObject = HighScoreManager.getInstance(contextOfApplication).getTotGamesPlayed();
    setTotalGamesPlayed(totalGamesPlayedObject);
    }
    else
    {
        totalGamesPlayedObject = Utils.convertStringToTotalGamesPlayed(totalGamesString);

    }
    return totalGamesPlayedObject;
}
    //Returns total Number of Games Tied
    public GameStatistics GetTotalGamesTied()
    {
        String totalGamesTied = GetTotalNumberofGamesPlayed();
        if(totalGamesTied.equals("null")){
            totalGamesPlayedObject = HighScoreManager.getInstance(contextOfApplication).getTotalTies();
            setTotalGamesPlayed(totalGamesPlayedObject);
        }
        else
        {
            totalGamesPlayedObject = Utils.convertStringToTotalGamesPlayed(totalGamesTied);

        }

        return totalGamesPlayedObject;
    }
// Returns total High Score List
    private String GetHighScoreFromSP(){
        if (sharedpreferences.contains(HISCORE_KEY))
            return sharedpreferences.getString(HISCORE_KEY, "null");

        return "null";
    }
    //Returns total number of Games played
    private String GetTotalNumberofGamesPlayed()
    {
        if (sharedpreferences.contains(TOTALGAMESpLAYED))
            return sharedpreferences.getString(TOTALGAMESpLAYED, "null");
        return "null";
    }
    //Sets music
    public void SetMusic(Boolean value){
        PutValue(Music, value);
    }
    //Get Music
    public boolean GetMusic(){
        return GetValue(Music);
    }
    //Sets Sound
    public void SetSound(Boolean value){
        PutValue(Sound, value);
    }
    //Gets Sound
    public boolean GetSound(){
        return GetValue(Sound);
    }
    //Sets Vibration
    public void SetVibration(Boolean value){
        PutValue(Vibration, value);
    }
    //Sets Vibration
    public boolean GetVibration(){
        return GetValue(Vibration);
    }

    //Gets Saved Settings from Shared Preferences .
    private boolean GetValue(String keyName){
        if (sharedpreferences.contains(keyName))
            return sharedpreferences.getBoolean(keyName, false);
        return false;
    }
   //Sets Vales to Settings
    private void PutValue(String keyName, Boolean value){
        Editor editor = sharedpreferences.edit();
        editor.putBoolean(keyName, value);
        editor.commit();
    }
//Storing High Score to Settings
    public synchronized void SetHighScore(final HighScore hiScore) {
        hiScoreObject = hiScore;
        Editor editor = sharedpreferences.edit();
        editor.putString(HISCORE_KEY,
        Utils.convertHiScoreToString(hiScoreObject));
        editor.commit();
    }
//Storing TotalNumber Of Games Played in Settings .
   public synchronized void setTotalGamesPlayed(final GameStatistics gameStatistics)
   {
       totalGamesPlayedObject = gameStatistics;
       Editor editor = sharedpreferences.edit();
       editor.putString(TOTALGAMESpLAYED,Utils.convertTotalGamesPlayedToString(totalGamesPlayedObject));
       editor.commit();
   }
}
