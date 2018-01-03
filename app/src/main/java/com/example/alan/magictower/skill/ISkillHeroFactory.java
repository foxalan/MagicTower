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

public class ISkillHeroFactory implements ISillFactory, ISkillHero {


    @Override
    public ISkillHero createSkill() {
        return this;
    }

    @Override
    public void attack(Role role, Role enemy) {

    }

    @Override
    public void restore(Role role, int life) {

    }

    @Override
    public void addAttack(Role role, int attack, ObstacleJewel jewel) {

    }

    @Override
    public void addDefense(Role role, int defense, ObstacleJewel jewel) {


    }


}
