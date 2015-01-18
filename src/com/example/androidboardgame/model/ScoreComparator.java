package com.example.androidboardgame.model;

import java.util.Comparator;

/**
 * Created by administrator on 12/01/2015.
 */
public class ScoreComparator implements Comparator<Score> {

    @Override
    public int compare(Score a, Score b) {

        if(a.getScore() > b.getScore()) return -1; // highest value first
        if(a.getScore() == b.getScore()) return 0;
        return 1;

    }
}
