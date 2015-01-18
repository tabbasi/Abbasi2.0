package com.example.androidboardgame.model;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	public static HighScore convertStringToHiScore(String json) {
		Gson gson = new Gson();
		HighScore hiScore = gson.fromJson(json, HighScore.class);
		return hiScore;
	}
    public static GameStatistics convertStringToTotalGamesPlayed(String json) {
        Gson gson = new Gson();
        GameStatistics totGames = gson.fromJson(json, GameStatistics.class);
        return totGames;
    }
	public static String convertHiScoreToString(HighScore hiScore) {
		Gson gson = new Gson();
		String json = gson.toJson(hiScore);
		return json;
	}
    //Converting object to Json .
    public static String convertTotalGamesPlayedToString(GameStatistics gameStatistics)
    {
        Gson gson = new Gson();
        String jsonString = gson.toJson(gameStatistics);
        return jsonString;
    }
    public static String GetStringFromDate(Date currentDate){
        return new SimpleDateFormat("MM/dd/yyyy").format(currentDate);
    }

}
