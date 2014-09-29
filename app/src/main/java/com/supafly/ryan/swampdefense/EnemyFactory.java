package com.supafly.ryan.swampdefense;

import android.content.Context;

import java.util.ArrayList;
import java.util.Timer;

import java.lang.Math;
import java.util.TimerTask;

/**
 * Created by Ryan on 9/20/2014.
 */

//creates enemies
public class EnemyFactory {
    private static ArrayList<EnemyCharacter> enemies;

    private Timer enemySpawn;

    public EnemyFactory(Context context, double difficulty) {
        long delay = (long)((100)*(10l-Math.log(difficulty)));

        enemies = new ArrayList<EnemyCharacter>();

        final Context ctxt = context;

        class spawn extends TimerTask {
            public void run() {
                EnemyFactory.enemies.add(new SeminoleCharacter(ctxt));
            }
        }

        enemySpawn = new Timer("Spawn Timer");
        enemySpawn.scheduleAtFixedRate(new spawn(), 10000l, 5000l);//delay);
    }

    public static void moveEnemies() {
        for(int i = 0; i < enemies.size(); i++) {
            enemies.get(i).advance();
        }
    }
}
