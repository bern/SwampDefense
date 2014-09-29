package com.supafly.ryan.swampdefense;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.lang.Math;

/**
 * Created by Ryan on 9/20/2014.
 */
public class SeminoleCharacter extends EnemyCharacter {

    public SeminoleCharacter(Context context) {
        super(context);

        sprites = new Bitmap[4];

        sprites[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.fsu_stand);
        sprites[0] = sprites[0].copy(Bitmap.Config.ARGB_8888, true);

        sprites[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.fsu_left);
        sprites[1] = sprites[1].copy(Bitmap.Config.ARGB_8888, true);

        sprites[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.fsu_stand);
        sprites[2] = sprites[2].copy(Bitmap.Config.ARGB_8888, true);

        sprites[3] = BitmapFactory.decodeResource(context.getResources(), R.drawable.fsu_right);
        sprites[3] = sprites[3].copy(Bitmap.Config.ARGB_8888, true);

        e_x = 600;
        e_y = (int)(Math.random()*700);

        index_held = CharacterDrawer.addBmpTrip(new BitmapTriple(e_x,e_y,sprites[0],"seminole"));
    }

}
