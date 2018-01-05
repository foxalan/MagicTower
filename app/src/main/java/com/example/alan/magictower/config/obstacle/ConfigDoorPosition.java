package com.example.alan.magictower.config.obstacle;

/**
 * Function :
 * Modify Date : 2018/1/5
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class ConfigDoorPosition {

    /**
     * 0:黄门
     * 1.蓝门
     * 2.红门
     */

    public static int[][] round_one_door_position = new int[][]{
            {2, 4, 0}, {2, 6, 1}, {8, 4, 2}, {8, 6, 1}
    };

    public static int[][] round_two_door_position = new int[][]{

            {2, 5, 0}, {8, 5, 1}, {5, 2, 0}, {5, 8, 1},
    };

}

