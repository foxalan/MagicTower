package com.example.alan.magictower.obstacle.factory;

import com.example.alan.magictower.info.ObstaclePosition;
import com.example.alan.magictower.obstacle.ObstacleType;
import com.example.alan.magictower.obstacle.key.KeyType;
import com.example.alan.magictower.obstacle.key.ObstacleKey;

/**
 * Function :
 * Modify Date : 2018/1/2
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class ObstacleKeyFactory implements IObstacleFactory {

    private ObstacleKey key;

    public ObstacleKeyFactory(ObstaclePosition position, boolean exist, KeyType type){
        key = new ObstacleKey(position,exist, ObstacleType.KEY);
        key.setKeyType(type);
    }

    @Override
    public ObstacleKey createObstacle() {
        if (key == null){
            return null;
        }
        return key;
    }
}
