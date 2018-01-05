package com.example.alan.magictower.obstacle.floor;

import com.example.alan.magictower.info.ObstaclePosition;
import com.example.alan.magictower.obstacle.Obstacle;
import com.example.alan.magictower.obstacle.ObstacleType;

/**
 * Function :
 * Modify Date : 2018/1/4
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class ObstacleFloor extends Obstacle {

    private FloorType floorType;

    public FloorType getFloorType() {
        return floorType;
    }

    public void setFloorType(FloorType floorType) {
        this.floorType = floorType;
    }

    public ObstacleFloor(ObstaclePosition position, ObstacleType type) {
        super(position, type);
    }
}
