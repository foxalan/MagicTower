package com.example.alan.magictower.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.example.alan.magictower.callback.IHeroPowerChangeCallBack;
import com.example.alan.magictower.config.ConfigObstacle;
import com.example.alan.magictower.obstacle.door.ObstacleDoor;
import com.example.alan.magictower.obstacle.jewel.ObstacleJewel;
import com.example.alan.magictower.obstacle.wood.ObstacleWood;
import com.example.alan.magictower.role.Role;
import com.example.alan.magictower.role.RoleHero;
import com.example.alan.magictower.util.BudgeUtil;
import com.example.alan.magictower.util.MoveType;

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

    private static final String TAG = "GamePanel";
    private RoleHero roleHero;
    private List<ObstacleWood> obstacleWoodList;
    private List<ObstacleDoor> obstacleDoorList;
    private List<ObstacleJewel> obstacleJewelList;
    private IHeroPowerChangeCallBack iHeroPowerChangeCallBack;

    private List<Role> roleMonsterList;

    public void setRoleMonsterList(List<Role> roleMonsterList) {
        this.roleMonsterList = roleMonsterList;
    }

    public void setHeroPowerChangeCallBack(IHeroPowerChangeCallBack iHeroPowerChangeCallBack) {
        this.iHeroPowerChangeCallBack = iHeroPowerChangeCallBack;
    }

    public void setObstacleJewelList(List<ObstacleJewel> obstacleJewelList) {
        this.obstacleJewelList = obstacleJewelList;
    }

    public void setObstacleDoorList(List<ObstacleDoor> obstacleDoorList) {
        this.obstacleDoorList = obstacleDoorList;
    }

    public void setObstacleWoodList(List<ObstacleWood> obstacleWoodList) {
        this.obstacleWoodList = obstacleWoodList;
    }

    public void setRole(RoleHero role) {
        this.roleHero = role;
    }

    private int mWith = 880;
    private int mHeight = 880;

    private int rect_width = 80;
    private int rect_hero_width = 80;
    private int rect_count = 11;

    private List<Rect> rectList;
    private Paint paint;
    private Paint paint_hero;
    private Paint paint_wood;
    private Paint paint_door;
    private Paint paint_jewel;

    public GamePanel(Context context) {
        this(context, null);
    }

    public GamePanel(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GamePanel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFocusable(true);
        requestFocus();
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
        paint_hero.setColor(Color.MAGENTA);

        paint_wood = new Paint();
        paint_wood.setAntiAlias(true);
        paint_wood.setStrokeWidth(5);
        paint_wood.setStyle(Paint.Style.FILL_AND_STROKE);
        paint_wood.setColor(Color.BLACK);

        paint_door = new Paint();
        paint_door.setAntiAlias(true);
        paint_door.setStrokeWidth(5);
        paint_door.setStyle(Paint.Style.FILL_AND_STROKE);
        paint_door.setColor(Color.BLUE);

        paint_jewel = new Paint();
        paint_jewel.setAntiAlias(true);
        paint_jewel.setStrokeWidth(5);
        paint_jewel.setStyle(Paint.Style.FILL_AND_STROKE);
        paint_jewel.setColor(Color.RED);
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

        drawRoleHero(canvas);
        drawWoods(canvas);
        drawDoors(canvas);
        drawJewel(canvas);
        drawMonster(canvas);

        for (Rect rect : rectList) {
            canvas.drawRect(rect, paint);
        }
    }


    /**
     * 画主角
     *
     * @param canvas
     */
    private void drawRoleHero(Canvas canvas) {
        if (roleHero != null) {
            Rect rect = new Rect();
            rect.set(roleHero.getX() * rect_hero_width, roleHero.getY() * rect_hero_width, (roleHero.getX() + 1) * rect_hero_width, (roleHero.getY() + 1) * rect_hero_width);
            canvas.drawRect(rect, paint_hero);
        }
    }

    /**
     * 画木头
     *
     * @param canvas
     */
    private void drawWoods(Canvas canvas) {
        if (obstacleWoodList != null) {
            for (ObstacleWood wood : obstacleWoodList) {
                Rect rect = new Rect();
                rect.set(wood.getX() * rect_width, wood.getY() * rect_width,
                        (wood.getX() + 1) * rect_width, (wood.getY() + 1) * rect_width);
                canvas.drawRect(rect, paint_wood);
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        MoveType moveType = MoveType.DOWN;
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_DOWN:
                moveType = MoveType.DOWN;
                Log.e(TAG, "onKeyDown: ");
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                moveType = MoveType.UP;
                Log.e(TAG, "onKeyUp: ");
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                moveType = MoveType.LEFT;
                Log.e(TAG, "onKeyLeft:");
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                moveType = MoveType.RIGHT;
                Log.e(TAG, "onKeyRight:");
                break;
            default:
                break;
        }

        if (BudgeUtil.canMoveLeftWithWood(roleHero, obstacleWoodList, moveType)) {
            ObstacleJewel jewel = BudgeUtil.canMoveLeftWithJewel(roleHero, obstacleJewelList,moveType);
            if (jewel != null) {
                getJewel(jewel);
            }
            if (BudgeUtil.canMoveLeftWithDoor(roleHero,obstacleDoorList,moveType)){
                roleHero.move(moveType);
            }
        }

        invalidate();
        if (iHeroPowerChangeCallBack != null){
            iHeroPowerChangeCallBack.updateHeroPower();
        }
        return true;
    }

    /**
     * 画门
     *
     * @param canvas
     */
    private void drawDoors(Canvas canvas) {
        if (obstacleDoorList != null) {
            for (ObstacleDoor door : obstacleDoorList) {
                if (door.isExist()) {
                    Rect rect = new Rect();
                    rect.set(door.getX() * rect_width, door.getY() * rect_width,
                            (door.getX() + 1) * rect_width, (door.getY() + 1) * rect_width);
                    switch (door.getDoorType()) {
                        case REDDOOR:
                            paint_door.setColor(Color.RED);
                            break;
                        case BLUEDOOR:
                            paint_door.setColor(Color.BLUE);
                            break;
                        case YELLOWDOOR:
                            paint_door.setColor(Color.YELLOW);
                            break;
                        default:
                            break;
                    }
                    canvas.drawRect(rect, paint_door);
                }
            }
        }
    }

    private void drawJewel(Canvas canvas) {

        if (obstacleJewelList != null) {
            for (ObstacleJewel jewel : obstacleJewelList) {
                if (jewel.isExist()) {
                    Rect rect = new Rect();
                    rect.set(jewel.getX() * rect_width, jewel.getY() * rect_width,
                            (jewel.getX() + 1) * rect_width, (jewel.getY() + 1) * rect_width);
                    switch (jewel.getType()) {
                        case DEFENSE:
                            paint_jewel.setColor(Color.GREEN);
                            break;
                        case ATTACK:
                            paint_jewel.setColor(Color.RED);
                            break;
                        case OVERALL:
                            paint_jewel.setColor(Color.YELLOW);
                            break;
                        default:
                            break;
                    }
                    canvas.drawCircle((rect.left + rect.right) / 2, (rect.bottom + rect.top) / 2, (rect_width / 2 - 20), paint_jewel);
                }
            }
        }
    }

    private void drawMonster(Canvas canvas) {
        if (roleMonsterList!=null){
            for (Role role:roleMonsterList){
                if (role.isAlive()){

                }
            }
        }
    }


    private void getJewel(ObstacleJewel jewel){
        switch (jewel.getType()) {
            case ATTACK:
                roleHero.addAttack(ConfigObstacle.JEWEL_ATTACK,jewel);
                break;
            case DEFENSE:
                roleHero.addDefense(ConfigObstacle.JEWEL_DEFENCE,jewel);
                break;
            case OVERALL:
                break;
            default:
                break;
        }

    }

}
