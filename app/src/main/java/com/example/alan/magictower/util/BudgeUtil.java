package com.example.alan.magictower.util;

import com.example.alan.magictower.obstacle.Obstacle;
import com.example.alan.magictower.obstacle.ObstacleType;
import com.example.alan.magictower.obstacle.door.DoorType;
import com.example.alan.magictower.obstacle.door.ObstacleDoor;
import com.example.alan.magictower.role.BaseRole;
import com.example.alan.magictower.role.BaseRoleHero;

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

    public static boolean canMoveLeftWithWood(BaseRoleHero hero, List<Obstacle> obstacle, MoveType type) {

        for (Obstacle wood : obstacle) {
            if (wood.getObstacleType() == ObstacleType.WOOD){

                switch (type) {
                    case UP:
                        if (hero.getY() == 0) {
                            return false;
                        }
                        if (wood.getPosition().getX() == hero.getX()) {
                            if ((hero.getY() - wood.getPosition().getY()) == 1) {
                                return false;
                            }
                        }
                        break;
                    case DOWN:
                        if (hero.getY() == 10) {
                            return false;
                        }
                        if (wood.getPosition().getX() == hero.getX()) {
                            if ((hero.getY() - wood.getPosition().getY()) == -1) {
                                return false;
                            }
                        }
                        break;
                    case LEFT:
                        if (hero.getX() == 0) {
                            return false;
                        }
                        if (wood.getPosition().getY() == hero.getY()) {
                            if ((hero.getX() - wood.getPosition().getX()) == 1) {
                                return false;
                            }
                        }
                        break;
                    case RIGHT:
                        if (hero.getX() == 10) {
                            return false;
                        }
                        if (wood.getPosition().getY() == hero.getY()) {
                            if ((hero.getX() - wood.getPosition().getX()) == -1) {
                                return false;
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return true;
    }

    public static Obstacle canMoveLeftWithJewel(BaseRoleHero hero, List<Obstacle> obstacleJewels, MoveType type) {

        for (Obstacle jewel : obstacleJewels) {

            if (jewel.getObstacleType() == ObstacleType.JEWEL||jewel.getObstacleType() == ObstacleType.FLOOR){

                Obstacle obstacleJewel = jewel;
                if (jewel.isExist()) {
                    switch (type) {
                        case UP:
                            if (jewel.getPosition().getX() == hero.getX()) {
                                if ((hero.getY() - jewel.getPosition().getY()) == 1) {
                                    return obstacleJewel;
                                }
                            }
                            break;
                        case DOWN:

                            if (jewel.getPosition().getX() == hero.getX()) {
                                if ((hero.getY() - jewel.getPosition().getY()) == -1) {
                                    return obstacleJewel;
                                }
                            }
                            break;
                        case LEFT:

                            if (jewel.getPosition().getY() == hero.getY()) {
                                if ((hero.getX() - jewel.getPosition().getX()) == 1) {
                                    return obstacleJewel;
                                }
                            }
                            break;
                        case RIGHT:

                            if (jewel.getPosition().getY() == hero.getY()) {
                                if ((hero.getX() - jewel.getPosition().getX()) == -1) {
                                    return obstacleJewel;
                                }
                            }
                            break;
                        default:
                            break;
                    }

                }
            }
        }
        return null;
    }

    public static boolean canMoveLeftWithDoor(BaseRoleHero hero, List<Obstacle> obstacleDoors, MoveType type) {

        for (Obstacle door : obstacleDoors) {
            if (door.isExist()) {
                if (door.getObstacleType() == ObstacleType.DOOR){

                    ObstacleDoor obstacleDoor = (ObstacleDoor) door;
                    switch (type) {
                        case UP:
                            if (door.getPosition().getX() == hero.getX()) {
                                if ((hero.getY() - door.getPosition().getY()) == 1) {
                                    if (haveKey(obstacleDoor.getDoorType(), hero)) {
                                        hero.openDoor(obstacleDoor);
                                        return true;
                                    } else {

                                        return false;
                                    }
                                }
                            }
                            break;
                        case DOWN:

                            if (door.getPosition().getX() == hero.getX()) {
                                if ((hero.getY() - door.getPosition().getY()) == -1) {
                                    if (haveKey(obstacleDoor.getDoorType(), hero)) {
                                        hero.openDoor(obstacleDoor);
                                        return true;
                                    } else {

                                        return false;
                                    }
                                }
                            }
                            break;
                        case LEFT:

                            if (door.getPosition().getY() == hero.getY()) {
                                if ((hero.getX() - door.getPosition().getX()) == 1) {
                                    if (haveKey(obstacleDoor.getDoorType(), hero)) {
                                        hero.openDoor(obstacleDoor);
                                        return true;
                                    } else {

                                        return false;
                                    }
                                }
                            }
                            break;
                        case RIGHT:
                            if (door.getPosition().getY() == hero.getY()) {
                                if ((hero.getX() - door.getPosition().getX()) == -1) {
                                    if (haveKey(obstacleDoor.getDoorType(), hero)) {
                                        hero.openDoor(obstacleDoor);
                                        return true;
                                    } else {
                                        return false;
                                    }
                                }
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return true;
    }

    private static boolean haveKey(DoorType doorType, BaseRoleHero hero) {
        switch (doorType) {
            case BLUEDOOR:
                if (hero.getBlueKey() != 0) {
                    return true;
                }
                break;
            case REDDOOR:
                if (hero.getRedKey() != 0) {
                    return true;
                }
                break;
            case YELLOWDOOR:
                if (hero.getYellowKey() != 0) {
                    return true;
                }
                break;
            default:
                break;
        }

        return false;
    }

    public static boolean canAttackMonster(BaseRoleHero hero, List<BaseRole> baseRoleListMonster, MoveType type) {

        for (BaseRole baseRole : baseRoleListMonster) {
            if (baseRole.isAlive()) {
                switch (type) {
                    case UP:
                        if (baseRole.getRolePosition().getX() == hero.getX()) {
                            if ((hero.getY() - baseRole.getRolePosition().getY()) == 1) {
                                if (hero.attack(baseRole)) {
                                    return true;
                                } else {
                                    return false;
                                }
                            }
                        }
                        break;
                    case DOWN:

                        if (baseRole.getRolePosition().getX() == hero.getX()) {
                            if ((hero.getY() - baseRole.getRolePosition().getY()) == -1) {
                                if (hero.attack(baseRole)) {
                                    return true;
                                } else {
                                    return false;
                                }
                            }
                        }
                        break;
                    case LEFT:

                        if (baseRole.getRolePosition().getY() == hero.getY()) {
                            if ((hero.getX() - baseRole.getRolePosition().getX()) == 1) {
                                if (hero.attack(baseRole)) {
                                    return true;
                                } else {
                                    return false;
                                }
                            }
                        }
                        break;
                    case RIGHT:

                        if (baseRole.getRolePosition().getY() == hero.getY()) {
                            if ((hero.getX() - baseRole.getRolePosition().getX()) == -1) {
                                if (hero.attack(baseRole)) {
                                    return true;
                                } else {
                                    return false;
                                }
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return true;
    }


}
