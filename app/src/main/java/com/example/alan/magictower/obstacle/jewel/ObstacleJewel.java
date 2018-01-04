package com.example.alan.magictower.obstacle.jewel;

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

public class ObstacleJewel extends Obstacle{

    private JewelType jewelType;

    public ObstacleJewel(ObstaclePosition position, boolean exist, ObstacleType obstacleType) {
        super(position, exist, obstacleType);
    }


    public JewelType getJewelType() {
        return jewelType;
    }

    public void setJewelType(JewelType jewelType) {
        this.jewelType = jewelType;
    }
}
