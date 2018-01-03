package com.example.alan.magictower.skill;

import com.example.alan.magictower.obstacle.door.ObstacleDoor;
import com.example.alan.magictower.obstacle.jewel.ObstacleJewel;
import com.example.alan.magictower.role.Role;
import com.example.alan.magictower.role.RoleHero;

/**
 * Function :
 * Modify Date : 2018/1/2
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public interface ISkillHero extends ISkill {

    /**
     * 回复
     * @param role
     * @param life
     */
    void restore(Role role,int life);

    /**
     * 加攻击力
     * @param role
     * @param attack
     * @param jewel
     */
    void addAttack(Role role,int attack,ObstacleJewel jewel);

    /**
     * 加防御力
     * @param role
     * @param defense
     * @param jewel
     */
    void addDefense(Role role, int defense, ObstacleJewel jewel);

    /**
     * 开门
     * @param role
     * @param door
     */
    void openDoor(RoleHero role, ObstacleDoor door);


}
