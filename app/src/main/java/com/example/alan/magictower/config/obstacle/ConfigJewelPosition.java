package com.example.alan.magictower.config.obstacle;

/**
 * Function :
 * Modify Date : 2018/1/5
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class ConfigJewelPosition {

    /**
     * 0:防御
     * 1.攻击
     * 2.都加
     */
    public static int[][] round_one_jewel_position = new int[][]{
            {0, 1, 0}, {1, 0, 1},
            {1, 5, 1}, {9, 5, 1},
            {10, 9, 1}, {9, 10, 0},
    };


    public static int[][] round_two_jewel_position = new int[][]{
            {6, 6, 0}, {4, 6, 1}, {4, 4, 1}, {6, 4, 0}
    };

}
