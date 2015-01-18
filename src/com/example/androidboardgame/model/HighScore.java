package com.example.androidboardgame.model;

import java.util.ArrayList;
import java.util.Collections;

public class HighScore {

    private static final int HIGH_SCORE_COUNT = 20;
    ArrayList<Score> scores;

	public HighScore() {
		super();
		initializeHiScoresList();
	}

	private void initializeHiScoresList() {
		scores = new ArrayList<Score>();

	}

	public void setHighScore(Score score) {
			if (!isReallyHiScore(score))
				return;
			putScoreInList(score);
	}

    public void putScoreInList(Score score) {
        for (Score sc : scores) {
            if (sc.getScore() == score.getScore()) //If score already exists
            {
                return;
            }
        }
        // other wise add to the list
        scores.add(score);
        if (scores.size() <= HIGH_SCORE_COUNT)
            return;
        // other wise sort the list first
        Collections.sort(scores, new ScoreComparator());
        // then remove the last item from the list
        // currentList.remove(currentList.size() - 1);
        scores.remove(0);


    }

    public void putScoreInList(ArrayList<Long> currentList, long score) {
		for (long sc : currentList) {if (sc == score) {	return;	}	}
		// other wise add to the list
		currentList.add(score);
		if (currentList.size() <= HIGH_SCORE_COUNT)
			return;
		// other wise sort the list first
		Collections.sort(currentList);
		// then remove the last item from the list
		// currentList.remove(currentList.size() - 1);
		currentList.remove(0);

	}
    //Gets High Score
    private int getMaxScore(ArrayList<Score> scores){


        return Collections.max(scores, new ScoreComparator()).getScore();

    }
    //Gets Min Score
    private int getMinScore(ArrayList<Score> scores){

        /*int minScore = Integer.MAX_VALUE;
        for (Score s : scores){
            if (s.getScore() > minScore) minScore = s.getScore();
        }
        return minScore;*/

        return Collections.min(scores, new ScoreComparator()).getScore();
    }
     //Checks if its really high score
	private boolean isReallyHiScore(Score score) {
		if (scores.size() < 1 || scores.size() < HIGH_SCORE_COUNT)
			return true;
		int max = getMaxScore(scores);
		int min = getMinScore(scores);

		if (score.getScore() < max && score.getScore() > min)
			return true;
		else
			return false;
	}

	public ArrayList<Score> getHighScores() {
		return scores;
	}

	public int getHighScore() {
		return getMaxScore(scores);
	}

}
