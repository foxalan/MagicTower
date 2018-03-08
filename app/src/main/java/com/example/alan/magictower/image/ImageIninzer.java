package com.example.alan.magictower.image;

import android.graphics.Bitmap;

import java.util.HashMap;
import java.util.List;

/**
 * Function :
 * Modify Date : 2018/3/8
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class ImageIninzer {

    private HashMap<Integer,List<Bitmap>> mListHashMap = new HashMap<>();


    public HashMap<Integer, List<Bitmap>> getmListHashMap() {
        return mListHashMap;
    }

    public void setmListHashMap(HashMap<Integer, List<Bitmap>> mListHashMap) {
        this.mListHashMap = mListHashMap;
    }
}
