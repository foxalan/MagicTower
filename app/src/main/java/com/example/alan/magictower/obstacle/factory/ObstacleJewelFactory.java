package com.example.alan.magictower.obstacle.factory;

import com.example.alan.magictower.info.ObstaclePosition;
import com.example.alan.magictower.obstacle.ObstacleType;
import com.example.alan.magictower.obstacle.jewel.JewelType;
import com.example.alan.magictower.obstacle.jewel.ObstacleJewel;

/**
 * Function :
 * Modify Date : 2018/1/2
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class ObstacleJewelFactory implements IObstacleFactory {

    private ObstacleJewel jewel;

    public ObstacleJewelFactory(ObstaclePosition position, boolean exist, JewelType type) {
        jewel = new ObstacleJewel(position, exist, ObstacleType.JEWEL);
        jewel.setJewelType(type);
    }

    public void setJewelType(JewelType type){
        jewel.setJewelType(type);
    }

    @Override
    public ObstacleJewel createObstacle() {
        if (jewel == null) {
            return null;
        }
        return jewel;
    }
}
