package com.example.alan.magictower.info;

/**
 * Function :
 * Modify Date : 2018/1/4
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class ObstaclePosition {

    private int x;
    private int y;
    private int type;

    public ObstaclePosition(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ObstaclePosition(int x, int y) {
        this.x = x;
        this.y = y;
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
}
