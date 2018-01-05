package com.example.alan.magictower.obstacle.factory;

import com.example.alan.magictower.info.ObstaclePosition;
import com.example.alan.magictower.obstacle.ObstacleType;
import com.example.alan.magictower.obstacle.floor.FloorType;
import com.example.alan.magictower.obstacle.floor.ObstacleFloor;

/**
 * Function :
 * Modify Date : 2018/1/5
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class ObstacleFloorFactory implements IObstacleFactory {

    private ObstacleFloor floor;

    public ObstacleFloorFactory(ObstaclePosition position, boolean exist, FloorType floorType) {
        floor = new ObstacleFloor(position,ObstacleType.FLOOR);
        floor.setFloorType(floorType);
    }

    @Override
    public ObstacleFloor createObstacle() {
        return floor;
    }
}
