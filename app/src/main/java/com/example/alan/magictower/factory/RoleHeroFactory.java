package com.example.alan.magictower.factory;

import com.example.alan.magictower.role.RoleHero;
import com.example.alan.magictower.role.RoleType;

/**
 * Function :
 * Modify Date : 2018/1/2
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class RoleHeroFactory implements IRoleFactory {

    private RoleHero roleHero;

    public RoleHeroFactory(int mId, String mName, String mDes, boolean alive, int mAttack, int mDefense, int life, int x, int y, int mSpeed, RoleType type) {
        roleHero = new RoleHero(mId, mName, mDes, alive, mAttack, mDefense, life, x, y, mSpeed,type);
    }

    @Override
    public RoleHero createRole() {
        return roleHero;
    }


}
