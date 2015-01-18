package com.example.androidboardgame.model;

import java.util.ArrayList;

import android.content.Context;

//
public class HighScoreManager {

	private static HighScoreManager INSTANCE;
    private static final String TOTALNUMBER_OF_GAMES_COUNT  = "";
	private HighScore highScore;
    private GameStatistics gameStatics;
    private GameStatistics totalGamesTied;
    private static Context context;


	public synchronized static HighScoreManager getInstance(Context ctx) {
        context = ctx;
		if (INSTANCE == null) {
			INSTANCE = new HighScoreManager();
		}
		return INSTANCE;
	}

	public HighScoreManager() {
		if (highScore == null) {
			highScore = new HighScore();
		}
        if (gameStatics == null) {
            gameStatics = new GameStatistics();
        }
        if (totalGamesTied==null)
        {
            totalGamesTied = new GameStatistics();
        }
	}
    //Getting High Score .
	public HighScore getHighScores() {
		return highScore;
	}
    //Getting Totatal Number of Games Played
    public GameStatistics getTotGamesPlayed()
    {
        return gameStatics;
    }
    //Getting Total Ties .
    public GameStatistics getTotalTies()
    {
        return totalGamesTied;
    }
    //Setting High Score
	public void putHighScore(Score score) {
		if (highScore != null) {
			highScore.setHighScore(score);
		}
	}

	public long getHighScore() {
		if (highScore != null) {
			return highScore.getHighScore();
		}
		return 0;
	}
    //Returns List of Score
	public ArrayList<Score> getScore() {
		if (highScore != null) {
			return highScore.getHighScores();
		}
		return null;
	}
    //Sets HighScore to Object
	public void setHighScore(HighScore highScore) {
		this.highScore = highScore;
	}
    //Setting Total Games Played .
    public void setTotalGamesPlayed(GameStatistics totalGamesPlayed) {
        this.gameStatics = totalGamesPlayed;
    }
    //Setting Total Games Tied .
    public void setTotalGamesTied(GameStatistics totalGamesTied) {
        this.totalGamesTied = totalGamesTied;
    }
    //Loading high scores from Setting Shared preference .
	public void loadHighScoresFromPreferences(Context context) {
        Settings settings = new Settings(context);
		setHighScore(settings.GetHighScore());
	}
    //Loading total Games played from Settings
    public void loadTotalNumberOfGamesPlayedFromPreferences(Context context) {
        Settings settings = new Settings(context);
        setTotalGamesPlayed(settings.GetTotalGamesPlayed());
    }
    public void loadTotalNumberOfGamesTiedFromPreferences(Context context) {
        Settings settings = new Settings(context);
        setTotalGamesPlayed(settings.GetTotalGamesTied());
    }
    //Storing highScore to Shared Preferences .
	public void storeHighScoresToPreferences(Context context) {
        Settings settings = new Settings(context);
        settings.SetHighScore(highScore);
	}
    //Storing total Number of games played to Settings .
    public  void storeTotalNumberOfGamesPlayedToPreferences(Context context)
    {
        Settings settings = new Settings(context);
        settings.setTotalGamesPlayed(gameStatics);
    }
    // storing totalTied Games to Shared preference .
    public  void storeTotalNumberOfTiedGamesToPreferences(Context context)
    {
        Settings settings = new Settings(context);
        settings.setTotalGamesPlayed(totalGamesTied);
    }
    //Getting total Number of Games Played
    public  int getTotalNumberOfGamesPlayed()
    {
        if (gameStatics == null) return 0;
        return gameStatics.getTotalNumberOfGamesPlayed();
    }

    public void  putMaximumNumberOfGamesPlayed(int totGamesPlayed)
    {
        if (gameStatics != null){
            gameStatics.setTotalNumberOfGamesPlayed(totGamesPlayed);
        }
    }
}
