package com.supafly.ryan.swampdefense;

import java.util.Timer;
import java.util.TimerTask;

/**

 GameController Class

 Singleton class, controls game globals

 authors @bern422 @ryancphil

 **/

public class GameController {

    //scalar with which to modify enemy speed and frequency
    public static double difficulty;

    //keeps track of in-game time, allows scaling of difficulty
    private Timer gtime;

    //player score, because everyone likes to see how they did
    private int score;

    //integer to store game state
    //0 - game is paused
    //1 - game is playing
    //2 - game is over
    private int gameState;

    //determines rate at which difficulty
    //increases as time increases
    private final int DIFFICULTY_SCALAR = 1;

    //new game constructor
    public GameController (){
        gtime = new Timer("Game Timer");

        difficulty = 1;

        score = 0;

        //defines a schedule
        //starts 10 seconds after creation
        //upon start (and every 10 seconds thereafter)
        //increases difficulty by DIFFICULTY_SCALAR + difficulty
        gtime.scheduleAtFixedRate(new IncreaseDifficulty(), 10000l, 10000l);

        //let the games begin
        gameState = 1;
    }

    public double getDifficulty() {
       return difficulty;
    }

    public void increaseDifficulty() {
        difficulty += DIFFICULTY_SCALAR;
    }

    //increase score
    public void updateScore(int s) {
        score += s;
    }

    public int getScore() {
        return score;
    }

    //un-pauses/pauses game,
    //depending on current gameState
    public void pauseToggle() {
        if(gameState == 1) {
            gameState = 0;
        }
        else gameState = 1;
    }

    //ends game
    public void endGame() {
        gameState = 2;
    }
}
