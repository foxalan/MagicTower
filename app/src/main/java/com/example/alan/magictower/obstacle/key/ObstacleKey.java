package com.example.alan.magictower.obstacle.key;

import com.example.alan.magictower.obstacle.Obstacle;

/**
 * Function :
 * Modify Date : 2018/1/2
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class ObstacleKey extends Obstacle{

    private KeyType type;

    public KeyType getType() {
        return type;
    }

    public void setType(KeyType type) {
        this.type = type;
    }

    public ObstacleKey(int x, int y, boolean exist) {
        super(x, y, exist);
    }
}
