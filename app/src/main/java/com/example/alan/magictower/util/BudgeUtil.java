package com.example.alan.magictower.util;

import com.example.alan.magictower.obstacle.wood.ObstacleWood;
import com.example.alan.magictower.role.RoleHero;

import java.util.List;

/**
 * Function :移动工具
 * Modify Date : 2018/1/3
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class BudgeUtil {

    public static boolean canMoveLeftWithWood(RoleHero hero, List<ObstacleWood> obstacleWoods, MoveType type) {

        for (ObstacleWood wood : obstacleWoods) {
            switch (type) {
                case UP:
                    if (hero.getY() == 0) {
                        return false;
                    }
                    if (wood.getX() == hero.getX()) {
                        if ((hero.getY() - wood.getY()) == 1) {
                            return false;
                        }
                    }
                    break;
                case DOWN:
                    if (hero.getY() == 10) {
                        return false;
                    }
                    if (wood.getX() == hero.getX()) {
                        if ((hero.getY() - wood.getY()) == -1) {
                            return false;
                        }
                    }
                    break;
                case LEFT:
                    if (hero.getX() == 0) {
                        return false;
                    }
                    if (wood.getY() == hero.getY()) {
                        if ((hero.getX() - wood.getX()) == 1) {
                            return false;
                        }
                    }
                    break;
                case RIGHT:
                    if (hero.getX() == 10){
                        return false;
                    }
                    if (wood.getY() == hero.getY()) {
                        if ((hero.getX() - wood.getX()) == -1) {
                            return false;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return true;
    }
}
