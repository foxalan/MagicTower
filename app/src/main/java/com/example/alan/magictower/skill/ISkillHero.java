package com.example.alan.magictower.skill;

import com.example.alan.magictower.obstacle.door.ObstacleDoor;
import com.example.alan.magictower.obstacle.jewel.ObstacleJewel;
import com.example.alan.magictower.role.BaseRole;
import com.example.alan.magictower.role.BaseRoleHero;

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
     * @param baseRole
     * @param life
     */
    void restore(BaseRole baseRole, int life);

    /**
     * 加攻击力
     * @param baseRole
     * @param attack
     * @param jewel
     */
    void addAttack(BaseRole baseRole, int attack, ObstacleJewel jewel);

    /**
     * 加防御力
     * @param baseRole
     * @param defense
     * @param jewel
     */
    void addDefense(BaseRole baseRole, int defense, ObstacleJewel jewel);

    /**
     * 开门
     * @param role
     * @param door
     */
    void openDoor(BaseRoleHero role, ObstacleDoor door);


}
