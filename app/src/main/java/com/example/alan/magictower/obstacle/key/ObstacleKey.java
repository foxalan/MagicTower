package com.example.alan.magictower.obstacle.key;

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

public class ObstacleKey extends Obstacle{

    private KeyType keyType;

    public ObstacleKey(ObstaclePosition position, boolean exist, ObstacleType obstacleType) {
        super(position, exist, obstacleType);
    }

    public KeyType getKeyType() {
        return keyType;
    }

    public void setKeyType(KeyType keyType) {
        this.keyType = keyType;
    }
}
