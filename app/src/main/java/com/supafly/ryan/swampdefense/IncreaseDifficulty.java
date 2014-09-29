package com.supafly.ryan.swampdefense;

import java.util.TimerTask;

/**
 * Created by Ryan on 9/20/2014.
 */

public class IncreaseDifficulty extends TimerTask {
    public void run() {
        MainActivity.gameController.increaseDifficulty();
    }
}
