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
import com.example.alan.magictower.obstacle.Obstacle;
import com.example.alan.magictower.obstacle.door.ObstacleDoor;
import com.example.alan.magictower.obstacle.jewel.ObstacleJewel;
import com.example.alan.magictower.role.Role;
import com.example.alan.magictower.role.RoleHero;
import com.example.alan.magictower.util.BudgeUtil;
import com.example.alan.magictower.util.MoveType;

import java.util.ArrayList;
import java.util.HashMap;
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

    private HashMap<Integer, List<Obstacle>> listHashMap;
    private List<Obstacle> currentObstacle;
    private int round;

    public void setRound(int round) {
        this.round = round;
        currentObstacle = listHashMap.get(round);
    }

    public void setListHashMap(HashMap<Integer, List<Obstacle>> listHashMap) {
        this.listHashMap = listHashMap;
    }

    private IHeroPowerChangeCallBack iHeroPowerChangeCallBack;

    private List<Role> roleMonsterList;

    public void setRoleMonsterList(List<Role> roleMonsterList) {
        this.roleMonsterList = roleMonsterList;
    }

    public void setHeroPowerChangeCallBack(IHeroPowerChangeCallBack iHeroPowerChangeCallBack) {
        this.iHeroPowerChangeCallBack = iHeroPowerChangeCallBack;
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
    private Paint paint_slime;

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

        paint_slime = new Paint();
        paint_slime.setAntiAlias(true);
        paint_slime.setStrokeWidth(5);
        paint_slime.setStyle(Paint.Style.FILL_AND_STROKE);
        paint_slime.setColor(Color.DKGRAY);

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
        drawObstacle(canvas);
        drawMonster(canvas);

        for (Rect rect : rectList) {
            canvas.drawRect(rect, paint);
        }
    }

    /**
     * 画障碍我
     *
     * @param canvas
     */
    private void drawObstacle(Canvas canvas) {
        if (currentObstacle == null){
            return;
        }
        for (Obstacle obstacle : currentObstacle) {
            switch (obstacle.getObstacleType()) {
                case WOOD:
                    Rect rect = new Rect();
                    rect.set(obstacle.getPosition().getX() * rect_width, obstacle.getPosition().getY() * rect_width,
                            (obstacle.getPosition().getX() + 1) * rect_width, (obstacle.getPosition().getY() + 1) * rect_width);
                    canvas.drawRect(rect, paint_wood);
                    break;
                case JEWEL:

                    ObstacleJewel jewel = (ObstacleJewel) obstacle;
                    if (obstacle.isExist()) {

                        Rect rect_jewel = new Rect();
                        rect_jewel.set(jewel.getPosition().getX() * rect_width, jewel.getPosition().getY() * rect_width,
                                (jewel.getPosition().getX() + 1) * rect_width, (jewel.getPosition().getY() + 1) * rect_width);
                        switch (jewel.getJewelType()) {
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
                        canvas.drawCircle((rect_jewel.left + rect_jewel.right) / 2, (rect_jewel.bottom + rect_jewel.top) / 2, (rect_width / 2 - 20), paint_jewel);
                    }
                    break;
                case DOOR:
                    ObstacleDoor door = (ObstacleDoor) obstacle;
                    if (obstacle.isExist()) {
                        Rect rect_door = new Rect();
                        rect_door.set(door.getPosition().getX() * rect_width, door.getPosition().getY() * rect_width,
                                (door.getPosition().getX() + 1) * rect_width, (door.getPosition().getY() + 1) * rect_width);
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
                        canvas.drawRect(rect_door, paint_door);
                    }
                    break;
                default:
                    break;
            }
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

        if (BudgeUtil.canMoveLeftWithWood(roleHero, currentObstacle, moveType)) {
            ObstacleJewel jewel = BudgeUtil.canMoveLeftWithJewel(roleHero, currentObstacle, moveType);
            if (jewel != null) {
                getJewel(jewel);
            }
            if (BudgeUtil.canMoveLeftWithDoor(roleHero, currentObstacle, moveType)) {
                if (BudgeUtil.canAttackMonster(roleHero, roleMonsterList, moveType)) {
                    roleHero.move(moveType);
                }
            }
        }

        invalidate();
        if (iHeroPowerChangeCallBack != null) {
            iHeroPowerChangeCallBack.updateHeroPower();
        }
        return true;
    }

    private void drawMonster(Canvas canvas) {
        if (roleMonsterList != null) {
            for (Role role : roleMonsterList) {
                if (role.isAlive()) {
                    switch (role.getType()) {
                        case SLIME:
                            Rect rect = new Rect();
                            rect.set(role.getX() * rect_width, role.getY() * rect_width,
                                    (role.getX() + 1) * rect_width, (role.getY() + 1) * rect_width);
                            canvas.drawRect(rect, paint_slime);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    private void getJewel(ObstacleJewel jewel) {
        switch (jewel.getJewelType()) {
            case ATTACK:
                roleHero.addAttack(ConfigObstacle.JEWEL_ATTACK, jewel);
                break;
            case DEFENSE:
                roleHero.addDefense(ConfigObstacle.JEWEL_DEFENCE, jewel);
                break;
            case OVERALL:
                break;
            default:
                break;
        }

    }
}
