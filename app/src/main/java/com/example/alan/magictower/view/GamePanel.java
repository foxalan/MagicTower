package com.example.alan.magictower.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Function :
 * Modify Date : 2018/1/2
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class GamePanel extends View {

    private int mWith = 800;
    private int mHeight = 800;

    private int rect_width = 80;
    private int rect_count = 10;

    private List<Rect> rectList;
    private Paint paint;

    public GamePanel(Context context) {
        this(context, null);
    }

    public GamePanel(Context context, AttributeSet attrs) {

        this(context, attrs, 0);
    }

    public GamePanel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initRect();
        initPaint();
    }

    private void initPaint() {

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.parseColor("#00ff00"));
        paint.setStrokeCap(Paint.Cap.BUTT);

    }

    private void initRect() {
        rectList = new ArrayList<>();
        rectList.clear();
        for (int i = 0; i < rect_count; i++) {
            for (int j = 0; j < rect_count; j++) {
                Rect rect = new Rect();
                rect.set(rect_width * i, j * rect_width, rect_width * (i + 1), rect_width * (j + 1));
                rectList.add(rect);
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(mWith, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (Rect rect : rectList) {
            canvas.drawRect(rect, paint);
        }
    }
}
