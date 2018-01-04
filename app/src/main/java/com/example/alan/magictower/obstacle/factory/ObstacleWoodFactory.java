package com.example.alan.magictower.obstacle.factory;

import com.example.alan.magictower.info.ObstaclePosition;
import com.example.alan.magictower.obstacle.ObstacleType;
import com.example.alan.magictower.obstacle.wood.ObstacleWood;

/**
 * Function :
 * Modify Date : 2018/1/2
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class ObstacleWoodFactory implements IObstacleFactory {

    private ObstacleWood wood;

    public ObstacleWoodFactory(ObstaclePosition position, boolean exist) {
        wood = new ObstacleWood(position, ObstacleType.WOOD);
    }

    @Override
    public ObstacleWood createObstacle() {
        if (wood == null) {
            return null;
        }
        return wood;
    }
}
