package com.example.androidboardgame.model;


import java.util.Random;

public class Helpers{

        public static int getRandomNumber(){
        //Get a random number of the bowl from where to start the moves
        Random rand = new Random();
        int  n = rand.nextInt(6) + 1;
        return n;
        }


}