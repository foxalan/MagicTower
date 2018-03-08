package com.example.alan.magictower.factory;

import android.util.Log;

import com.example.alan.magictower.config.ConfigPositionCreator;
import com.example.alan.magictower.config.ConfigRole;
import com.example.alan.magictower.info.RolePosition;
import com.example.alan.magictower.role.BaseRole;
import com.example.alan.magictower.role.BaseRoleSlime;
import com.example.alan.magictower.role.RoleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Function :
 * Modify Date : 2018/1/3
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class RoleFactory {

    private static final String TAG = "RoleFactory";

    public int getRound() {
        return ConfigPositionCreator.getInstance().getRoleMap().size();
    }

    private static class RoleHolder {
        private static RoleFactory INSTANCE = new RoleFactory();
    }

    public static RoleFactory getInstance() {
        return RoleHolder.INSTANCE;
    }

    public List<BaseRole> getRole(int round) {

        List<BaseRole> baseRoleList = new ArrayList<>();
        baseRoleList.clear();

        HashMap<RoleType, List<RolePosition>> typeListHashMap = ConfigPositionCreator.getInstance().getRoleMap().get(round);

        Log.e(TAG, "getRole: " +typeListHashMap.size());
//        if (round > typeListHashMap.size()) {
//
//            return null;
//        }

        for (RoleType type : typeListHashMap.keySet()) {
            switch (type) {
                case SLIME:
                    for (RolePosition position : typeListHashMap.get(type)) {
                        RoleSlimeFactory roleFactory = new RoleSlimeFactory(true, ConfigRole.SLIME_ATTACK,ConfigRole.SLIME_DEFENSE,ConfigRole.SLIME_LIFE ,position, RoleType.SLIME);
                        BaseRoleSlime slime = roleFactory.createRole();
                        baseRoleList.add(slime);
                    }
                    break;
                    default:
                        break;
            }
        }

        return baseRoleList;
    }

}
