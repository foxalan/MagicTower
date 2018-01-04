package com.example.alan.magictower.obstacle;

import com.example.alan.magictower.info.ObstaclePosition;

/**
 * Function :障碍物
 * Modify Date : 2018/1/2
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class Obstacle {

    private ObstaclePosition position;
    private boolean exist;
    private ObstacleType obstacleType;

    public Obstacle(ObstaclePosition position, boolean exist, ObstacleType obstacleType) {
        this.position = position;
        this.exist = exist;
        this.obstacleType = obstacleType;
    }

    public Obstacle(ObstaclePosition position, ObstacleType type) {
        this(position,true,type);
    }

    public ObstaclePosition getPosition() {
        return position;
    }

    public void setPosition(ObstaclePosition position) {
        this.position = position;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public ObstacleType getObstacleType() {
        return obstacleType;
    }

    public void setObstacleType(ObstacleType obstacleType) {
        this.obstacleType = obstacleType;
    }
}
