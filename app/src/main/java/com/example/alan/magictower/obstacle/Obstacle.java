package com.example.alan.magictower.obstacle;

/**
 * Function :障碍物
 * Modify Date : 2018/1/2
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class Obstacle {

    private int x;
    private int y;
    private boolean exist;

    public Obstacle(int x, int y, boolean exist) {
        this.x = x;
        this.y = y;
        this.exist = exist;
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

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }
}
