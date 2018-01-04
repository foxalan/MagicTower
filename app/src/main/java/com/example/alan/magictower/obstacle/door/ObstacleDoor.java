package com.example.alan.magictower.obstacle.door;

import com.example.alan.magictower.info.ObstaclePosition;
import com.example.alan.magictower.obstacle.Obstacle;
import com.example.alan.magictower.obstacle.ObstacleType;

/**
 * Function :
 * Modify Date : 2018/1/2
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class ObstacleDoor extends Obstacle {

    private DoorType doorType;

    public ObstacleDoor(ObstaclePosition position, boolean exist, ObstacleType obstacleType) {
        super(position, exist, obstacleType);
    }


    public DoorType getDoorType() {
        return doorType;
    }

    public void setDoorType(DoorType doorType) {
        this.doorType = doorType;
    }


}
