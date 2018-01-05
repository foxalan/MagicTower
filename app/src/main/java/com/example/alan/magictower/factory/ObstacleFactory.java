package com.example.alan.magictower.factory;

import com.example.alan.magictower.obstacle.door.DoorType;
import com.example.alan.magictower.obstacle.door.ObstacleDoor;
import com.example.alan.magictower.obstacle.factory.ObstacleDoorFactory;
import com.example.alan.magictower.obstacle.factory.ObstacleJewelFactory;
import com.example.alan.magictower.obstacle.factory.ObstacleWoodFactory;
import com.example.alan.magictower.obstacle.jewel.JewelType;
import com.example.alan.magictower.obstacle.jewel.ObstacleJewel;
import com.example.alan.magictower.obstacle.wood.ObstacleWood;

import java.util.ArrayList;
import java.util.List;

import static com.example.alan.magictower.config.ConfigPositionCreator.ROUND_ONE_DOOR_POSITION;
import static com.example.alan.magictower.config.ConfigPositionCreator.ROUND_ONE_JEWEL_POSITION;
import static com.example.alan.magictower.config.ConfigPositionCreator.ROUND_ONE_WOOD_POSITION;

/**
 * Function :
 * Modify Date : 2018/1/3
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class ObstacleFactory {

    private static class ObstacleHolder {
        private static final ObstacleFactory INSTANCE = new ObstacleFactory();
    }

    public static ObstacleFactory getInstance() {
        return ObstacleHolder.INSTANCE;
    }



    public List<ObstacleDoor> createDoor() {
        List<ObstacleDoor> obstacleDoorList = new ArrayList<>();
        obstacleDoorList.clear();
        for (int i = 0; i < ROUND_ONE_DOOR_POSITION.length; i++) {

            ObstacleDoorFactory doorFactory = new ObstacleDoorFactory(ROUND_ONE_DOOR_POSITION[i][0], ROUND_ONE_DOOR_POSITION[i][1], true, DoorType.YELLOWDOOR);
            if (i == 0) {
                doorFactory.setDoorType(DoorType.BLUEDOOR);
            }
            ObstacleDoor door = doorFactory.createObstacle();
            obstacleDoorList.add(door);
        }

        return new ArrayList<>(obstacleDoorList);
    }

    public List<ObstacleWood> createWood() {
        List<ObstacleWood> obstacleWoodList = new ArrayList<>();
        for (int i = 0; i < ROUND_ONE_WOOD_POSITION.length; i++) {
            ObstacleWoodFactory woodFactory = new ObstacleWoodFactory(ROUND_ONE_WOOD_POSITION[i][0], ROUND_ONE_WOOD_POSITION[i][1], true);
            ObstacleWood wood = woodFactory.createObstacle();
            obstacleWoodList.add(wood);
        }
        return new ArrayList<>(obstacleWoodList);
    }

    public List<ObstacleJewel> createJewel() {
        List<ObstacleJewel> obstacleJewelList = new ArrayList<>();
        for (int i = 0; i < ROUND_ONE_JEWEL_POSITION.length; i++) {
            ObstacleJewelFactory jewelFactory = new ObstacleJewelFactory(ROUND_ONE_JEWEL_POSITION[i][0], ROUND_ONE_JEWEL_POSITION[i][1], true, JewelType.ATTACK);
            if (i % 2 == 0) {
                jewelFactory.setJewelType(JewelType.DEFENSE);
            }
            ObstacleJewel jewel = jewelFactory.createObstacle();
            obstacleJewelList.add(jewel);
        }
        return new ArrayList<>(obstacleJewelList);
    }
}
