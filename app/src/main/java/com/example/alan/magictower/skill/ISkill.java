package com.example.alan.magictower.skill;

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

public interface ISkill {

    /**
     * 普通攻击
     * @param role
     * @param enemy
     */
    boolean attack(BaseRoleHero role, BaseRole enemy);
}
