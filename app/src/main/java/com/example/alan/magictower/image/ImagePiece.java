package com.example.alan.magictower.image;

import android.graphics.Bitmap;

/**
 * Function :
 * Modify Date : 2018/3/8
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class ImagePiece {

    public int index = 0;
    public Bitmap bitmap = null;


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
