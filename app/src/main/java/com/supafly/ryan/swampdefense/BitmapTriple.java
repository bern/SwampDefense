package com.supafly.ryan.swampdefense;

import android.graphics.Bitmap;

/**
 * Created by Ryan on 9/20/2014.
 */
public class BitmapTriple {
    private int x;
    private int y;

    private String name;

    Bitmap bmp;

    public BitmapTriple(int x, int y, Bitmap bmp, String name) {
        this.x = x;
        this.y = y;
        this.bmp = bmp;
        this.name = name;
    }

    public String getName() { return name; }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Bitmap getBmp() {
        return bmp;
    }
}
