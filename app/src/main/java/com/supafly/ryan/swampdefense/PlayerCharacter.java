package com.supafly.ryan.swampdefense;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.MotionEvent;

/**
 PlayerCharacter Class

 Controls player behavior

 authors @bern422 @ryancphil

 **/
public class PlayerCharacter {

    private Bitmap[] sprites;

    private int location_in_drawer;

    private final int PLAYER_SPEED = 3;

    private int player_x;
    private int player_y;

    private Context context;

    public PlayerCharacter(Context context) {
        this.context = context;
        init();
    }

    public void init() {
        player_x = 7;
        player_y = 325;

        sprites = new Bitmap[3];

        sprites[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.al_stand);
        //sprites[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.al_close);

        sprites[0] = sprites[0].copy(Bitmap.Config.ARGB_8888, true);

        Log.e("","adding gator");
        location_in_drawer = CharacterDrawer.addBmpTrip(new BitmapTriple(player_x,player_y,sprites[0],"gator"));
    }

    public boolean onTouchEvent(MotionEvent event) {
        //final int action = event.getActionMasked();
        //final int pointer = event.getActionIndex();
            //pointer detected below albert
            //move albert down
            if(event.getAction() == MotionEvent.ACTION_MOVE) {
                if (event.getY() >= player_y) {
                    player_y += PLAYER_SPEED;
                } else {
                    player_y -= PLAYER_SPEED;
                }
            }

        Log.e("", "replacing gator");
        CharacterDrawer.removeBmpTrip(location_in_drawer);
        location_in_drawer = CharacterDrawer.addBmpTrip(new BitmapTriple(player_x,player_y,sprites[0],"gator"));
        Log.e("", "replaced gator");
        return true;
    }

}