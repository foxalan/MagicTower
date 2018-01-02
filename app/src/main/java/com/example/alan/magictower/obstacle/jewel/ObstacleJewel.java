package com.example.alan.magictower.obstacle.jewel;

import com.example.alan.magictower.obstacle.Obstacle;

/**
 * Function :
 * Modify Date : 2018/1/2
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class ObstacleJewel extends Obstacle{

    private JewelType type;

    public JewelType getType() {
        return type;
    }

    public void setType(JewelType type) {
        this.type = type;
    }

    public ObstacleJewel(int x, int y, boolean exist) {
        super(x, y, exist);
    }


}
