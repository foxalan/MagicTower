package com.example.alan.magictower.obstacle.factory;

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

public class IObstacleDoorFactory implements IObstacleFactory {

    private ObstacleDoor door;

    public IObstacleDoorFactory(int x, int y, boolean exist, DoorType doorType) {
        door = new ObstacleDoor(x, y, exist);
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
