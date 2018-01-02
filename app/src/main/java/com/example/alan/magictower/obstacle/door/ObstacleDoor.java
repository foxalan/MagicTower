package com.example.alan.magictower.obstacle.door;

import com.example.alan.magictower.obstacle.Obstacle;

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

    public ObstacleDoor(int x, int y, boolean exist) {
        super(x, y, exist);
    }

    public DoorType getDoorType() {
        return doorType;
    }

    public void setDoorType(DoorType doorType) {
        this.doorType = doorType;
    }


}
