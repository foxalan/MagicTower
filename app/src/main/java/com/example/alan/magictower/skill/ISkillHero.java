package com.example.alan.magictower.skill;

import com.example.alan.magictower.obstacle.jewel.ObstacleJewel;
import com.example.alan.magictower.role.Role;

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
     */
    void addAttack(Role role,int attack,ObstacleJewel jewel);

    /**
     * 加防御力
     * @param role
     * @param defense
     */
    void addDefense(Role role, int defense, ObstacleJewel jewel);

}
