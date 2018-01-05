package com.example.alan.magictower.config;

import android.util.Log;

import com.example.alan.magictower.info.ObstaclePosition;
import com.example.alan.magictower.info.RolePosition;
import com.example.alan.magictower.obstacle.ObstacleType;
import com.example.alan.magictower.role.RoleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.alan.magictower.config.obstacle.ConfigDoorPosition.round_one_door_position;
import static com.example.alan.magictower.config.obstacle.ConfigDoorPosition.round_two_door_position;
import static com.example.alan.magictower.config.obstacle.ConfigFloorPosition.round_one_floor_position;
import static com.example.alan.magictower.config.obstacle.ConfigFloorPosition.round_two_floor_position;
import static com.example.alan.magictower.config.obstacle.ConfigJewelPosition.round_one_jewel_position;
import static com.example.alan.magictower.config.obstacle.ConfigJewelPosition.round_two_jewel_position;
import static com.example.alan.magictower.config.obstacle.ConfigWoodPosition.round_one_wood_position;
import static com.example.alan.magictower.config.obstacle.ConfigWoodPosition.round_two_wood_position;
import static com.example.alan.magictower.config.role.ConfigRoleSmilePosition.round_one_smile_position;
import static com.example.alan.magictower.config.role.ConfigRoleSmilePosition.round_two_smile_position;

/**
 * Function :
 * Modify Date : 2018/1/2
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class ConfigPositionCreator {
    private static final String TAG = "ConfigPositionCreator";
    private HashMap<Integer, HashMap<ObstacleType, List<ObstaclePosition>>> obstacleMap = new HashMap<>(16);
    private HashMap<Integer, HashMap<RoleType , List<RolePosition>>> roleMap = new HashMap<>(16);

    public HashMap<Integer, HashMap<RoleType, List<RolePosition>>> getRoleMap() {
        setRoleMap();
        return roleMap;
    }

    public HashMap<Integer, HashMap<ObstacleType, List<ObstaclePosition>>> getObstacleMap() {
        setObstacleMap();
        return obstacleMap;
    }

    private void setObstacleMap() {
        obstacleMap.put(1,getRoundOneObstacle());
        obstacleMap.put(2,getRoundTwoObstacle());
    }

    private void setRoleMap(){
        roleMap.put(1,getRoundOneRole());
        roleMap.put(2,getRoundTwoRole());

        Log.e(TAG, "setRoleMap:round "+getRoundOneRole().size() );
        Log.e(TAG, "setRoleMap: "+roleMap.size() );
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

        List<ObstaclePosition> obstacleFloorPositionList = new ArrayList<>();
        for (int i = 0; i < round_one_floor_position.length; i++) {
            ObstaclePosition position = new ObstaclePosition(round_one_floor_position[i][0], round_one_floor_position[i][1]);
            obstacleFloorPositionList.add(position);
        }
        obstacleTypeListHashMap.put(ObstacleType.FLOOR, obstacleFloorPositionList);


        return obstacleTypeListHashMap;
    }

    public HashMap<ObstacleType,List<ObstaclePosition>> getRoundTwoObstacle() {

        HashMap<ObstacleType, List<ObstaclePosition>> obstacleTypeListHashMap = new HashMap<>(16);
        List<ObstaclePosition> obstacleWoodPositionList = new ArrayList<>();
        for (int i = 0; i < round_two_wood_position.length; i++) {
            ObstaclePosition position = new ObstaclePosition(round_two_wood_position[i][0], round_two_wood_position[i][1]);
            obstacleWoodPositionList.add(position);
        }
        obstacleTypeListHashMap.put(ObstacleType.WOOD, obstacleWoodPositionList);

        List<ObstaclePosition> obstacleDoorPositionList = new ArrayList<>();
        for (int i = 0; i < round_two_door_position.length; i++) {
            ObstaclePosition position = new ObstaclePosition(round_two_door_position[i][0], round_two_door_position[i][1]);
            obstacleDoorPositionList.add(position);
        }
        obstacleTypeListHashMap.put(ObstacleType.DOOR, obstacleDoorPositionList);

        List<ObstaclePosition> obstacleJewelPositionList = new ArrayList<>();

        for (int i = 0; i <round_two_jewel_position.length; i++) {
            ObstaclePosition position = new ObstaclePosition(round_two_jewel_position[i][0], round_two_jewel_position[i][1]);
            obstacleJewelPositionList.add(position);
        }
        obstacleTypeListHashMap.put(ObstacleType.JEWEL, obstacleJewelPositionList);

        List<ObstaclePosition> obstacleFloorPositionList = new ArrayList<>();
        for (int i = 0; i < round_two_floor_position.length; i++) {
            ObstaclePosition position = new ObstaclePosition(round_two_floor_position[i][0], round_one_floor_position[i][1]);
            obstacleFloorPositionList.add(position);
        }
        obstacleTypeListHashMap.put(ObstacleType.FLOOR, obstacleFloorPositionList);

        return obstacleTypeListHashMap;
    }

    public HashMap<RoleType,List<RolePosition>> getRoundOneRole() {

        HashMap<RoleType, List<RolePosition>> roleListHashMap = new HashMap<>(16);
        List<RolePosition> roleSlimePositionList = new ArrayList<>();
        for (int i = 0; i < round_one_smile_position.length; i++) {
            RolePosition position = new RolePosition(round_one_smile_position[i][0], round_one_smile_position[i][1]);
            roleSlimePositionList.add(position);
        }
        roleListHashMap.put(RoleType.SLIME,roleSlimePositionList);

        return roleListHashMap;
    }

    public HashMap<RoleType,List<RolePosition>> getRoundTwoRole() {

        HashMap<RoleType, List<RolePosition>> roleListHashMap = new HashMap<>(16);
        List<RolePosition> roleSlimePositionList = new ArrayList<>();
        for (int i = 0; i < round_two_smile_position.length; i++) {
            RolePosition position = new RolePosition(round_two_smile_position[i][0], round_two_smile_position[i][1]);
            roleSlimePositionList.add(position);
        }
        roleListHashMap.put(RoleType.SLIME,roleSlimePositionList);

        return roleListHashMap;
    }
}
