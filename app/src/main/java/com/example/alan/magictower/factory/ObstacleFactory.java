package com.example.alan.magictower.factory;

import android.util.Log;

import com.example.alan.magictower.config.ConfigPositionCreator;
import com.example.alan.magictower.info.ObstaclePosition;
import com.example.alan.magictower.obstacle.Obstacle;
import com.example.alan.magictower.obstacle.ObstacleType;
import com.example.alan.magictower.obstacle.door.DoorType;
import com.example.alan.magictower.obstacle.door.ObstacleDoor;
import com.example.alan.magictower.obstacle.factory.ObstacleDoorFactory;
import com.example.alan.magictower.obstacle.factory.ObstacleJewelFactory;
import com.example.alan.magictower.obstacle.factory.ObstacleKeyFactory;
import com.example.alan.magictower.obstacle.factory.ObstacleWoodFactory;
import com.example.alan.magictower.obstacle.jewel.JewelType;
import com.example.alan.magictower.obstacle.jewel.ObstacleJewel;
import com.example.alan.magictower.obstacle.key.KeyType;
import com.example.alan.magictower.obstacle.key.ObstacleKey;
import com.example.alan.magictower.obstacle.wood.ObstacleWood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Function :
 * Modify Date : 2018/1/3
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class ObstacleFactory {

    private static final String TAG = "ObstacleFactory";

    public int getRound() {
        return ConfigPositionCreator.getInstance().getObstacleMap().size();
    }

    private static class ObstacleHolder {
        private static final ObstacleFactory INSTANCE = new ObstacleFactory();
    }

    public static ObstacleFactory getInstance() {
        return ObstacleHolder.INSTANCE;
    }


    public List<Obstacle> getObstacle(int round) {

        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.clear();

        HashMap<ObstacleType, List<ObstaclePosition>> typeListHashMap = ConfigPositionCreator.getInstance().getObstacleMap().get(round);
        Log.e(TAG, "getObstacle: "+typeListHashMap.size() );

        if (round > typeListHashMap.size()) {

            return null;
        }

//        Map map = new HashMap();
//        Iterator iter = map.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry entry = (Map.Entry) iter.next();
//            Object key = entry.getKey();
//            Object val = entry.getValue();
//        }


        for (ObstacleType type : typeListHashMap.keySet()) {
            switch (type) {
                case KEY:
                    for (ObstaclePosition position : typeListHashMap.get(type)) {
                        ObstacleKeyFactory keyFactory = new ObstacleKeyFactory(position, true, KeyType.BLUE);
                        ObstacleKey key = keyFactory.createObstacle();
                        obstacles.add(key);
                    }
                    break;
                case DOOR:
                    for (ObstaclePosition position : typeListHashMap.get(type)) {
                        ObstacleDoorFactory doorFactory = new ObstacleDoorFactory(position, true, DoorType.YELLOWDOOR);
                        ObstacleDoor door = doorFactory.createObstacle();
                        obstacles.add(door);
                    }
                    break;
                case WOOD:
                    for (ObstaclePosition position : typeListHashMap.get(type)) {
                        ObstacleWoodFactory woodFactory = new ObstacleWoodFactory(position, true);
                        ObstacleWood wood = woodFactory.createObstacle();
                        obstacles.add(wood);
                    }
                    break;
                case FLOOR:
                    break;

                case JEWEL:
                    for (ObstaclePosition position : typeListHashMap.get(type)) {
                        ObstacleJewelFactory jewelFactory = new ObstacleJewelFactory(position, true, JewelType.ATTACK);
                        ObstacleJewel jewel = jewelFactory.createObstacle();
                        obstacles.add(jewel);
                    }
                    break;
                default:
                    break;
            }
        }
        return obstacles;
    }
}
