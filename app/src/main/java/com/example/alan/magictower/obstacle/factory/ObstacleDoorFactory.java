package com.example.alan.magictower.obstacle.factory;

import com.example.alan.magictower.info.ObstaclePosition;
import com.example.alan.magictower.obstacle.ObstacleType;
import com.example.alan.magictower.obstacle.door.DoorType;
import com.example.alan.magictower.obstacle.door.ObstacleDoor;

/**
 * Function :
 * Modify Date : 2018/1/2
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class ObstacleDoorFactory implements IObstacleFactory {

    private ObstacleDoor door;

    public ObstacleDoorFactory(ObstaclePosition position, boolean exist, DoorType doorType) {
        door = new ObstacleDoor(position,exist, ObstacleType.DOOR);
        door.setDoorType(doorType);
    }

    public void setDoorType(DoorType doorType){
        door.setDoorType(doorType);
    }

    @Override
    public ObstacleDoor createObstacle() {
        if (door == null) {
            return null;
        }
        return door;
    }
}
