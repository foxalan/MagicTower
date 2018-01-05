package com.example.alan.magictower.config;

import com.example.alan.magictower.info.ObstaclePosition;
import com.example.alan.magictower.obstacle.ObstacleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.alan.magictower.config.ConfigDoorPosition.round_one_door_position;
import static com.example.alan.magictower.config.ConfigJewelPosition.round_one_jewel_position;
import static com.example.alan.magictower.config.ConfigWoodPosition.round_one_wood_position;

/**
 * Function :
 * Modify Date : 2018/1/2
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class ConfigPositionCreator {

    private HashMap<Integer, HashMap<ObstacleType, List<ObstaclePosition>>> obstacleMap = new HashMap<>();


    public HashMap<Integer, HashMap<ObstacleType, List<ObstaclePosition>>> getObstacleMap() {
        setObstacleMap();
        return obstacleMap;
    }

    public void setObstacleMap() {
        obstacleMap.put(1,getRoundOneObstacle());
    }

    private static class PositionCreatorHolder {
        private final static ConfigPositionCreator INSTANCE = new ConfigPositionCreator();
    }

    public static ConfigPositionCreator getInstance() {

        return PositionCreatorHolder.INSTANCE;
    }

    public HashMap<ObstacleType,List<ObstaclePosition>> getRoundOneObstacle() {

        HashMap<ObstacleType, List<ObstaclePosition>> obstacleTypeListHashMap = new HashMap<>(16);
        List<ObstaclePosition> obstacleWoodPositionList = new ArrayList<>();
        for (int i = 0; i < round_one_wood_position.length; i++) {
            ObstaclePosition position = new ObstaclePosition(round_one_wood_position[i][0], round_one_wood_position[i][1]);
            obstacleWoodPositionList.add(position);
        }

        obstacleTypeListHashMap.put(ObstacleType.WOOD, obstacleWoodPositionList);

        List<ObstaclePosition> obstacleDoorPositionList = new ArrayList<>();
        for (int i = 0; i < round_one_door_position.length; i++) {
            ObstaclePosition position = new ObstaclePosition(round_one_door_position[i][0], round_one_door_position[i][1]);
            obstacleDoorPositionList.add(position);
        }

        obstacleTypeListHashMap.put(ObstacleType.DOOR, obstacleDoorPositionList);

        List<ObstaclePosition> obstacleJewelPositionList = new ArrayList<>();

        for (int i = 0; i <round_one_jewel_position.length; i++) {
            ObstaclePosition position = new ObstaclePosition(round_one_jewel_position[i][0], round_one_jewel_position[i][1]);
            obstacleJewelPositionList.add(position);
        }

        obstacleTypeListHashMap.put(ObstacleType.JEWEL, obstacleJewelPositionList);

        return obstacleTypeListHashMap;
    }


}
