package com.example.alan.magictower.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.example.alan.magictower.obstacle.wood.ObstacleWood;
import com.example.alan.magictower.role.RoleHero;

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

    private RoleHero role;
    private List<ObstacleWood> obstacleWoodList;

    public void setObstacleWoodList(List<ObstacleWood> obstacleWoodList) {
        this.obstacleWoodList = obstacleWoodList;
    }

    public void setRole(RoleHero role) {
        this.role = role;
    }

    private int mWith = 880;
    private int mHeight = 880;

    private int rect_width = 80;
    private int rect_count = 11;

    private List<Rect> rectList;
    private Paint paint;
    private Paint paint_hero;
    private Paint paint_wood;

    public GamePanel(Context context) {
        this(context, null);
    }

    public GamePanel(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GamePanel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFocusable(true);
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

        paint_hero = new Paint();
        paint_hero.setAntiAlias(true);
        paint_hero.setStrokeWidth(5);
        paint_hero.setStyle(Paint.Style.FILL_AND_STROKE);
        paint_hero.setColor(Color.YELLOW);

        paint_wood = new Paint();
        paint_wood.setAntiAlias(true);
        paint_wood.setStrokeWidth(5);
        paint_wood.setStyle(Paint.Style.FILL_AND_STROKE);
        paint_wood.setColor(Color.BLUE);
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

        drawRole(canvas);
        drawWoods(canvas);

        for (Rect rect : rectList) {
            canvas.drawRect(rect, paint);
        }
    }

    /**
     * 画主角
     * @param canvas
     */
    private void drawRole(Canvas canvas) {
        if (role != null){
            Rect rect = new Rect();
            rect.set(role.getX()*rect_width,role.getY()*rect_width,(role.getX()+1)*rect_width,(role.getY()+1)*rect_width);
            canvas.drawRect(rect,paint_hero);
        }
    }

    /**
     * 画木头
     * @param canvas
     */
    private void drawWoods(Canvas canvas) {
        if (obstacleWoodList!=null){
            for (ObstacleWood wood:obstacleWoodList){
                Rect rect = new Rect();
                rect.set(wood.getX()*rect_width,wood.getY()*rect_width,
                        (wood.getX()+1)*rect_width,(wood.getY()+1)*rect_width);
                canvas.drawRect(rect,paint_wood);
            }
        }
    }

}
