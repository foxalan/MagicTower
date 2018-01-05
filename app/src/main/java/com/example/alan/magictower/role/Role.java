package com.example.alan.magictower.role;

import com.example.alan.magictower.info.RolePosition;

/**
 * Function : 角色类
 * Modify Date : 2018/1/2
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public abstract class Role {

    private int mId;
    private String mName;
    private String mDes;
    private boolean alive;
    private int mAttack;
    private int mDefense;
    private int life;
    private int x;
    private int y;
    private int mSpeed;
    private RoleType type;

    public RolePosition getRolePosition() {
        return rolePosition;
    }

    public void setRolePosition(RolePosition rolePosition) {
        this.rolePosition = rolePosition;
    }

    private RolePosition rolePosition;

    public Role(int mId, String mName, String mDes, boolean alive, int mAttack, int mDefense, int life, int x, int y, int mSpeed,RoleType type) {
        this.mId = mId;
        this.mName = mName;
        this.mDes = mDes;
        this.alive = alive;
        this.mAttack = mAttack;
        this.mDefense = mDefense;
        this.life = life;
        this.x = x;
        this.y = y;
        this.mSpeed = mSpeed;
        this.type = type;
    }

    public Role(boolean alive, int mAttack, int mDefense, int life,RolePosition position,RoleType type) {
        this.rolePosition = position;
        this.alive = alive;
        this.mAttack = mAttack;
        this.mDefense = mDefense;
        this.life = life;
        this.type = type;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDes() {
        return mDes;
    }

    public void setmDes(String mDes) {
        this.mDes = mDes;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getmAttack() {
        return mAttack;
    }

    public void setmAttack(int mAttack) {
        this.mAttack = mAttack;
    }

    public int getmDefense() {
        return mDefense;
    }

    public void setmDefense(int mDefense) {
        this.mDefense = mDefense;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getmSpeed() {
        return mSpeed;
    }

    public void setmSpeed(int mSpeed) {
        this.mSpeed = mSpeed;
    }

    public RoleType getType() {
        return type;
    }

    public void setType(RoleType type) {
        this.type = type;
    }
}
