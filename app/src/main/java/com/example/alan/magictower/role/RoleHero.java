package com.example.alan.magictower.role;

import com.example.alan.magictower.skill.ISkillHeroFactory;

/**
 * Function :
 * Modify Date : 2018/1/2
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class RoleHero extends Role {

    private ISkillHeroFactory skillHeroFactory;

    public ISkillHeroFactory getSkillHeroFactory() {
        return skillHeroFactory;
    }

    public void setSkillHeroFactory(ISkillHeroFactory skillHeroFactory) {
        this.skillHeroFactory = skillHeroFactory;
    }

    public RoleHero(int mId, String mName, String mDes, boolean alive, int mAttack, int mDefense, int life) {
        super(mId, mName, mDes, alive, mAttack, mDefense, life);
    }

    public void attack(Role enemy) {
        skillHeroFactory.attack(this,enemy);
    }

    public void restore(Role role, int life) {
        skillHeroFactory.restore(this,life);
    }

    public void addAttack(int attack) {
        skillHeroFactory.addAttack(this,attack);
    }


    public void addDefense(int defense) {
        skillHeroFactory.addDefense(this,defense);
    }


}
