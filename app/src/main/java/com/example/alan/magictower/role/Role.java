package com.example.alan.magictower.role;

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

    public Role(int mId, String mName, String mDes, boolean alive, int mAttack, int mDefense, int life) {
        this.mId = mId;
        this.mName = mName;
        this.mDes = mDes;
        this.alive = alive;
        this.mAttack = mAttack;
        this.mDefense = mDefense;
        this.life = life;
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

    public int getmDencefence() {
        return mDefense;
    }

    public void setmDencefence(int mDefense) {
        this.mDefense = mDefense;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
