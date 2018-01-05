package com.example.alan.magictower.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;

import com.example.alan.magictower.R;
import com.example.alan.magictower.callback.IHeroPowerChangeCallBack;
import com.example.alan.magictower.config.ConfigObstacle;
import com.example.alan.magictower.obstacle.Obstacle;
import com.example.alan.magictower.obstacle.door.ObstacleDoor;
import com.example.alan.magictower.obstacle.floor.ObstacleFloor;
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

    private int round;
    private RoleHero roleHero;

    private HashMap<Integer, List<Obstacle>> listHashMap;
    private HashMap<Integer, List<Role>> roleHashMap;

    public void setRoleHashMap(HashMap<Integer, List<Role>> roleHashMap) {
        this.roleHashMap = roleHashMap;
    }

    public void setListHashMap(HashMap<Integer, List<Obstacle>> listHashMap) {
        this.listHashMap = listHashMap;
    }

    private List<Obstacle> currentObstacle;
    private List<Role> currentRole;

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
        currentObstacle = listHashMap.get(round);
        currentRole = roleHashMap.get(round);
    }

    private IHeroPowerChangeCallBack iHeroPowerChangeCallBack;

    public void setHeroPowerChangeCallBack(IHeroPowerChangeCallBack iHeroPowerChangeCallBack) {
        this.iHeroPowerChangeCallBack = iHeroPowerChangeCallBack;
    }

    public void setRole(RoleHero role) {
        this.roleHero = role;
    }

    private int mWith = 880;
    private int mHeight = 880;

    private int rectWidth = 80;
    private int rectCount = 11;

    private List<Rect> rectList;
    private Paint paint;

    private Bitmap bitmapFloorUp;
    private Bitmap bitmapFloorDown;
    private Bitmap bitmapWood;
    private Bitmap bitmapBackground;
    private Bitmap bitmapYellowDoor;
    private Bitmap bitmapRedJewel;
    private Bitmap bitmapRoleSlime;

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
        initBitmap();
    }

    private void initBitmap() {
        bitmapFloorUp = BitmapFactory.decodeResource(getResources(), R.drawable.up_floor);
        bitmapFloorDown = BitmapFactory.decodeResource(getResources(), R.drawable.down_floor);
        bitmapWood = BitmapFactory.decodeResource(getResources(), R.drawable.terrain);
        bitmapBackground = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        bitmapYellowDoor = BitmapFactory.decodeResource(getResources(), R.drawable.yellow_door);
        bitmapRedJewel = BitmapFactory.decodeResource(getResources(), R.drawable.jewel_red);
        bitmapRoleSlime = BitmapFactory.decodeResource(getResources(), R.drawable.role_slime);
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
        for (int i = 0; i < rectCount; i++) {
            for (int j = 0; j < rectCount; j++) {
                Rect rect = new Rect();
                rect.set(rectWidth * i, j * rectWidth, rectWidth * (i + 1), rectWidth * (j + 1));
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

        drawBackground(canvas);
        drawObstacle(canvas);
        drawMonster(canvas);
        drawRoleHero(canvas);
    }

    private void drawBackground(Canvas canvas) {
        for (Rect rect : rectList) {
            canvas.drawBitmap(bitmapBackground, null, rect, paint);
        }
    }

    /**
     * 画障碍
     *
     * @param canvas
     */
    private void drawObstacle(Canvas canvas) {
        if (currentObstacle == null) {
            return;
        }
        for (Obstacle obstacle : currentObstacle) {
            switch (obstacle.getObstacleType()) {
                case WOOD:
                    Rect rect = new Rect();
                    rect.set(obstacle.getPosition().getX() * rectWidth, obstacle.getPosition().getY() * rectWidth,
                            (obstacle.getPosition().getX() + 1) * rectWidth, (obstacle.getPosition().getY() + 1) * rectWidth);
                    canvas.drawBitmap(bitmapWood, null, rect, paint);
                    break;
                case JEWEL:

                    ObstacleJewel jewel = (ObstacleJewel) obstacle;
                    if (obstacle.isExist()) {

                        Rect rectJewel = new Rect();
                        rectJewel.set(jewel.getPosition().getX() * rectWidth, jewel.getPosition().getY() * rectWidth,
                                (jewel.getPosition().getX() + 1) * rectWidth, (jewel.getPosition().getY() + 1) * rectWidth);
                        switch (jewel.getJewelType()) {
                            case DEFENSE:
                                break;
                            case ATTACK:
                                canvas.drawBitmap(bitmapRedJewel, null, rectJewel, paint);
                                break;
                            case OVERALL:
                                break;
                            default:
                                break;
                        }

                    }
                    break;
                case DOOR:
                    ObstacleDoor door = (ObstacleDoor) obstacle;
                    if (obstacle.isExist()) {
                        Rect rectDoor = new Rect();
                        rectDoor.set(door.getPosition().getX() * rectWidth, door.getPosition().getY() * rectWidth,
                                (door.getPosition().getX() + 1) * rectWidth, (door.getPosition().getY() + 1) * rectWidth);
                        switch (door.getDoorType()) {
                            case REDDOOR:
                                break;
                            case BLUEDOOR:
                                break;
                            case YELLOWDOOR:
                                canvas.drawBitmap(bitmapYellowDoor, null, rectDoor, paint);
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case FLOOR:
                    ObstacleFloor floor = (ObstacleFloor) obstacle;
                    Rect rectFloor = new Rect();
                    rectFloor.set(floor.getPosition().getX() * rectWidth, floor.getPosition().getY() * rectWidth,
                            (floor.getPosition().getX() + 1) * rectWidth, (floor.getPosition().getY() + 1) * rectWidth);
                    switch (floor.getFloorType()) {
                        case UP:
                            canvas.drawBitmap(bitmapFloorUp, null, rectFloor, paint);
                            break;
                        case DOWN:
                            canvas.drawBitmap(bitmapFloorDown, null, rectFloor, paint);
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void drawMonster(Canvas canvas) {
        if (currentRole != null) {
            for (Role role : currentRole) {
                if (role.isAlive()) {
                    switch (role.getType()) {
                        case SLIME:
                            Rect rect = new Rect();
                            rect.set(role.getRolePosition().getX() * rectWidth, role.getRolePosition().getY() * rectWidth,
                                    (role.getRolePosition().getX() + 1) * rectWidth, (role.getRolePosition().getY() + 1) * rectWidth);
                            canvas.drawBitmap(bitmapRoleSlime, null, rect, paint);
                            break;
                        default:
                            break;
                    }
                }
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
            rect.set(roleHero.getX() * rectWidth, roleHero.getY() * rectWidth, (roleHero.getX() + 1) * rectWidth, (roleHero.getY() + 1) * rectWidth);
            canvas.drawRect(rect, paint);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        MoveType moveType = MoveType.DOWN;
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_DOWN:
                moveType = MoveType.DOWN;
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                moveType = MoveType.UP;
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                moveType = MoveType.LEFT;
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                moveType = MoveType.RIGHT;
                break;
            default:
                break;
        }

        if (BudgeUtil.canMoveLeftWithWood(roleHero, currentObstacle, moveType)) {
            Obstacle obstacle = BudgeUtil.canMoveLeftWithJewel(roleHero, currentObstacle, moveType);
            if (obstacle != null) {
                switch (obstacle.getObstacleType()) {
                    case JEWEL:
                        ObstacleJewel jewel = (ObstacleJewel) obstacle;
                        getJewel(jewel);
                        break;
                    case FLOOR:
                        ObstacleFloor floor = (ObstacleFloor) obstacle;
                        switch (floor.getFloorType()) {
                            case UP:
                                setRound(getRound() + 1);
                                break;
                            case DOWN:
                                setRound(getRound() - 1);
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
            }
            if (BudgeUtil.canMoveLeftWithDoor(roleHero, currentObstacle, moveType)) {
                if (BudgeUtil.canAttackMonster(roleHero, currentRole, moveType)) {
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
