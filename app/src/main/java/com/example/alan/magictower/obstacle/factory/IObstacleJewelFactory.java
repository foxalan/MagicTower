package com.example.alan.magictower.obstacle.factory;

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

public class IObstacleJewelFactory implements IObstacleFactory {

    private ObstacleJewel jewel;

    public IObstacleJewelFactory(int x, int y, boolean exist, JewelType type) {
        jewel = new ObstacleJewel(x, y, exist);
        jewel.setType(type);
    }

    public void setJewelType(JewelType type){
        jewel.setType(type);
    }

    @Override
    public ObstacleJewel createObstacle() {
        if (jewel == null) {
            return null;
        }
        return jewel;
    }
}
