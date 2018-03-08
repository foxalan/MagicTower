package com.example.alan.magictower.image;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

/**
 * Function :
 * Modify Date : 2018/3/8
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class ImageSplitter {

    public static List<ImagePiece> split(Bitmap bitmap, int xPiece, int yPiece) {

        List<ImagePiece> pieces = new ArrayList<ImagePiece>(xPiece * yPiece);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int pieceWidth = width / 3;
        int pieceHeight = height / 3;
        for (int i = 0; i < yPiece; i++) {
            for (int j = 0; j < xPiece; j++) {
                ImagePiece piece = new ImagePiece();
                piece.index = j + i * xPiece;
                int xValue = j * pieceWidth;
                int yValue = i * pieceHeight;
                piece.bitmap = Bitmap.createBitmap(bitmap, xValue, yValue,
                        pieceWidth, pieceHeight);
                pieces.add(piece);
            }
        }

        return pieces;
    }
}
