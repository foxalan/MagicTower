package com.example.alan.magictower.factory;

import com.example.alan.magictower.obstacle.door.DoorType;
import com.example.alan.magictower.obstacle.door.ObstacleDoor;
import com.example.alan.magictower.obstacle.factory.IObstacleDoorFactory;
import com.example.alan.magictower.obstacle.factory.IObstacleWoodFactory;
import com.example.alan.magictower.obstacle.wood.ObstacleWood;

import java.util.ArrayList;
import java.util.List;

import static com.example.alan.magictower.config.ConfigPositon.ROUND_ONE_DOOR_POSITION;
import static com.example.alan.magictower.config.ConfigPositon.ROUND_ONE_WOOD_POSITION;

/**
 * Function :
 * Modify Date : 2018/1/3
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class ObstacleFactory {

    private static class ObstacleHolder{
        private static final ObstacleFactory INSTANCE = new ObstacleFactory();
    }

    public static ObstacleFactory getInstance(){
        return ObstacleHolder.INSTANCE;
    }

    public List<ObstacleDoor> createDoor(){
        List<ObstacleDoor> obstacleDoorList = new ArrayList<>();
        obstacleDoorList.clear();
        for (int i = 0; i < ROUND_ONE_DOOR_POSITION.length; i++) {

            IObstacleDoorFactory doorFactory = new IObstacleDoorFactory(ROUND_ONE_DOOR_POSITION[i][0], ROUND_ONE_DOOR_POSITION[i][1], true, DoorType.YELLOW);
            if (i == 0){
                doorFactory.setDoorType(DoorType.BLUE);
            }
            ObstacleDoor door = doorFactory.createObstacle();
            obstacleDoorList.add(door);
        }

        return new ArrayList<>(obstacleDoorList);
    }

    public List<ObstacleWood> createWood(){
        List<ObstacleWood> obstacleWoodList = new ArrayList<>();
        for (int i = 0; i < ROUND_ONE_WOOD_POSITION.length; i++) {
            IObstacleWoodFactory woodFactory = new IObstacleWoodFactory(ROUND_ONE_WOOD_POSITION[i][0], ROUND_ONE_WOOD_POSITION[i][1], true);
            ObstacleWood wood = woodFactory.createObstacle();
            obstacleWoodList.add(wood);
        }
        return new ArrayList<>(obstacleWoodList);
    }
}
