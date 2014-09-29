package com.supafly.ryan.swampdefense;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

import java.util.ArrayList;

/**
 PlayerCharacter Class

 Controls player behavior

 authors @bern422 @ryancphil

 **/
public class CharacterDrawer extends View {

    private Bitmap[] sprites;
    private Paint mPaint;
    private Paint transPaint;
    private Canvas canvas;
    private Context context;

    private static ArrayList<BitmapTriple> drawingList;

    public CharacterDrawer(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public CharacterDrawer(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public CharacterDrawer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        init();
    }

    public void init() {
        mPaint = new Paint();

        drawingList = new ArrayList<BitmapTriple>();

        transPaint = new Paint();
        transPaint.setColor(getResources().getColor(android.R.color.transparent));
        transPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));

        canvas = new Canvas();

        this.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap)null));
    }

    public static int addBmpTrip(BitmapTriple x) {
        //Log.e("","Adding new triple at location "+x.getX()+", "+x.getY());
        drawingList.add(x);
        return drawingList.size()-1;
    }

    public static void removeBmpTrip(int i) {
        //Log.e("","Removing triple");
        drawingList.remove(i);
    }

    public void update() {
        //Log.e("","I AM CALLED");
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Log.e("","drawingList is size "+drawingList.size());
        for(int i = 0; i < drawingList.size(); i++) {
            BitmapTriple temp = drawingList.get(i);
            Log.e("","drawing "+temp.getName());
            //Log.e("","drawing bitmap at "+temp.getX()+", "+temp.getY());
            canvas.drawBitmap(temp.getBmp(), temp.getX(), temp.getY(), mPaint);
        }
        Log.e("", "DONE WITH LOOP");
        invalidate();
    }

}