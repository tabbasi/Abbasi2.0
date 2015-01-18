package com.example.androidboardgame.model;

/**
 * Created by administrator on 12/01/2015.
 */
public class GameStatistics {

    private int TotalNumberOfGamesPlayed;
    private  int TotalNumberOfTied;
    //Returns TotalNumber of Games Played.
    public  int getTotalNumberOfGamesPlayed()
    {
        return  TotalNumberOfGamesPlayed;
    }
    //Sets TotalNumber of Games Played .
    public void setTotalNumberOfGamesPlayed(int totGamesPalyed)
    {
        TotalNumberOfGamesPlayed = totGamesPalyed;
    }
    //Returns Total Number of Ties.
    public int getTotalNumberOfTied()
    {
        return  TotalNumberOfTied;
    }
    //Sets Total Number of Ties .
    public void setTotalNumberOfTied(int totalTies){
        TotalNumberOfTied = totalTies;
    }
}
