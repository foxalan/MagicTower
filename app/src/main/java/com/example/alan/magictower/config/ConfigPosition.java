package com.example.alan.magictower.config;

import com.example.alan.magictower.info.ObstaclePosition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Function :
 * Modify Date : 2018/1/2
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class ConfigPosition {

    private static HashMap<Integer,int[][]> obstacleWoodMap = new HashMap<>();
    private static List<ObstaclePosition> obstaclePositionList = new ArrayList<>();

    static {
        for (int i = 0;i<round_one_wood_positon.length;i++)
    }

    public static  int[][] round_one_wood_positon = new int[][]{
            {4,0},{4,1},{4,2},{4,3},{4,4},
            {4,6},{4,7},{4,8},{4,9},{4,10},
            {6,0},{6,1},{6,2},{6,3},{6,4},
            {6,6},{6,7},{6,8},{6,9},{6,10},
            {0,4},{1,4},{3,4},{4,4},
            {0,6},{1,6},{3,6},{4,6},
            {7,4},{9,4},{10,4},{11,4},
            {7,6},{9,6},{10,6},{11,6},
    };

    public static final int[][] ROUND_ONE_DOOR_POSITION = new int[][]{
            {2,4},{2,6},{8,4},{8,6}
    };

    public static final int[][] ROUND_ONE_JEWEL_POSITION = new int[][]{
            {0,1},{1,0},
            {1,5},{9,5},
            {10,9},{9,10},
    };

    public static final int[][] ROUND_ONE_SMILE_POSITION = new int[][]{
            {0,3},{1,2},{2,1},{3,0},
            {7,10},{8,9},{9,8},{10,7}
    };
}
