package com.supafly.ryan.swampdefense;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

/**
 EnemyCharacter Class

 Controls enemy behavior

 authors @bern422 @ryancphil

 **/
public class EnemyCharacter {

    protected Bitmap[] sprites;

    protected double e_speed;
    protected double e_frequency;

    protected int index_held;

    protected int e_x;
    protected int e_y;

    private Context context;

    public EnemyCharacter(Context context) {
        this.context = context;
    }

    public double geteSpeed() {
        return e_speed;
    }

    public void advance() {
        Log.e("", "moved enemies");
        e_x -= geteSpeed();
        Log.e("", "removing index "+index_held);
        CharacterDrawer.removeBmpTrip(index_held);
        index_held = CharacterDrawer.addBmpTrip(new BitmapTriple(e_x,e_y,sprites[0],"seminole"));
    }
}