package com.example.alan.magictower.role;

import com.example.alan.magictower.info.RolePosition;

/**
 * Function :史莱姆
 * Modify Date : 2018/1/3
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class RoleSlime extends Role {
    public RoleSlime(int mId, String mName, String mDes, boolean alive, int mAttack, int mDefense, int life, int x, int y, int mSpeed, RoleType type) {
        super(mId, mName, mDes, alive, mAttack, mDefense, life, x, y, mSpeed, type);
    }

    public RoleSlime(boolean alive, int mAttack, int mDefense, int life, RolePosition position, RoleType type) {
        super(alive, mAttack, mDefense, life, position, type);
    }




}
