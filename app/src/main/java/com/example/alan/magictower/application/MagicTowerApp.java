package com.example.alan.magictower.application;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.alan.magictower.R;
import com.example.alan.magictower.image.ImagePiece;
import com.example.alan.magictower.image.ImageSplitter;

import java.util.List;

/**
 * Function :
 * Modify Date : 2018/1/3
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class MagicTowerApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hero);
        List<ImagePiece> split= ImageSplitter.split(bitmap,4,4);





    }
}
