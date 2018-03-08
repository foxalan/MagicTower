package com.example.alan.magictower.role;

import android.util.Log;

import com.example.alan.magictower.obstacle.door.ObstacleDoor;
import com.example.alan.magictower.obstacle.jewel.ObstacleJewel;
import com.example.alan.magictower.skill.SkillHeroFactory;
import com.example.alan.magictower.util.MoveType;

/**
 * Function : 主角类
 * Modify Date : 2018/1/2
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class BaseRoleHero extends BaseRole {

    private static final String TAG = "BaseRoleHero";
    /**
     * 技能接口
     */
    private SkillHeroFactory skillHeroFactory;

    /**
     * 三种KEY
     */
    private int yellowKey;
    private int blueKey;
    private int redKey;

    public BaseRoleHero(int mId, String mName, String mDes, boolean alive, int mAttack, int mDefense, int life, int x, int y, int mSpeed, RoleType type) {
        super(mId, mName, mDes, alive, mAttack, mDefense, life, x, y, mSpeed, type);
    }

    public int getYellowKey() {
        return yellowKey;
    }

    public void setYellowKey(int yellowKey) {
        this.yellowKey = yellowKey;
    }

    public int getBlueKey() {
        return blueKey;
    }

    public void setBlueKey(int blueKey) {
        this.blueKey = blueKey;
    }

    public int getRedKey() {
        return redKey;
    }

    public void setRedKey(int redKey) {
        this.redKey = redKey;
    }

    public void setSkillHeroFactory(SkillHeroFactory skillHeroFactory) {
        this.skillHeroFactory = skillHeroFactory;
    }

    /**
     * 进攻
     *
     * @param enemy
     */
    public boolean attack(BaseRole enemy) {

        return skillHeroFactory.attack(this, enemy);
    }

    /**
     * 回复生命
     *
     * @param baseRole
     * @param life
     */
    public void restore(BaseRole baseRole, int life) {
        skillHeroFactory.restore(this, life);
    }

    /**
     * 增加生命力
     *
     * @param attack
     */
    public void addAttack(int attack, ObstacleJewel jewel) {
        Log.e(TAG, "addAttack: ");
        skillHeroFactory.addAttack(this, attack, jewel);
    }

    /**
     * 增加防御力
     *
     * @param defense
     */
    public void addDefense(int defense, ObstacleJewel jewel) {
        skillHeroFactory.addDefense(this, defense, jewel);
    }

    /**
     * 开门
     */
    public void openDoor(ObstacleDoor door){
        skillHeroFactory.openDoor(this,door);
    }

    public void move(MoveType type) {
        switch (type) {
            case RIGHT:
                moveRight();
                break;
            case LEFT:
                moveLeft();
                break;
            case DOWN:
                moveDown();
                break;
            case UP:
                moveUp();
                break;
            default:
                break;

        }
    }

    /**
     * 向上走
     */
    public void moveUp() {
        setY(getY() - 1);
    }

    /**
     * 向下
     */
    public void moveDown() {
        setY(getY() + 1);
    }

    /**
     * 向左
     */
    public void moveLeft() {
        setX(getX() - 1);
    }

    /**
     * 向右
     */
    public void moveRight() {
        setX(getX() + 1);
    }
}
