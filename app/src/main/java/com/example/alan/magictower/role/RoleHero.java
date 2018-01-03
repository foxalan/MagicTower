package com.example.alan.magictower.role;

import android.util.Log;

import com.example.alan.magictower.obstacle.jewel.ObstacleJewel;
import com.example.alan.magictower.skill.SkillHeroFactory;

/**
 * Function :
 * Modify Date : 2018/1/2
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class RoleHero extends Role {

    private static final String TAG = "RoleHero";
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

    public RoleHero(int mId, String mName, String mDes, boolean alive, int mAttack, int mDefense, int life, int x, int y, int mSpeed) {
        super(mId, mName, mDes, alive, mAttack, mDefense, life, x, y, mSpeed);
    }

    public SkillHeroFactory getSkillHeroFactory() {
        return skillHeroFactory;
    }

    public void setSkillHeroFactory(SkillHeroFactory skillHeroFactory) {
        this.skillHeroFactory = skillHeroFactory;
    }

    /**
     * 进攻
     *
     * @param enemy
     */
    public void attack(Role enemy) {
        skillHeroFactory.attack(this, enemy);
    }

    /**
     * 回复生命
     *
     * @param role
     * @param life
     */
    public void restore(Role role, int life) {
        skillHeroFactory.restore(this, life);
    }

    /**
     * 增加生命力
     *
     * @param attack
     */
    public void addAttack(int attack, ObstacleJewel jewel) {
        Log.e(TAG, "addAttack: ");
        skillHeroFactory.addAttack(this,attack,jewel);
    }


    /**
     * 增加防御力
     *
     * @param defense
     */
    public void addDefense(int defense) {

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
