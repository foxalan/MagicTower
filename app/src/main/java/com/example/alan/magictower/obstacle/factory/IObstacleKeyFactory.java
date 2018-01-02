package com.example.alan.magictower.obstacle.factory;

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

public class IObstacleKeyFactory implements IObstacleFactory {

    private ObstacleKey key;

    public IObstacleKeyFactory(int x, int y, boolean exist, KeyType type){
        key = new ObstacleKey(x,y,exist);
        key.setType(type);
    }

    @Override
    public ObstacleKey createObstacle() {
        if (key == null){
            return null;
        }
        return key;
    }
}
