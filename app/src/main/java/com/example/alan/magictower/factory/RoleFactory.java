package com.example.alan.magictower.factory;

import com.example.alan.magictower.role.Role;
import com.example.alan.magictower.role.RoleSlime;
import com.example.alan.magictower.role.RoleType;

import java.util.ArrayList;
import java.util.List;

import static com.example.alan.magictower.config.ConfigPosition.ROUND_ONE_SMILE_POSITION;
import static com.example.alan.magictower.config.ConfigRole.SLIME_ALIVE;
import static com.example.alan.magictower.config.ConfigRole.SLIME_ATTACK;
import static com.example.alan.magictower.config.ConfigRole.SLIME_DEFENSE;
import static com.example.alan.magictower.config.ConfigRole.SLIME_ID;
import static com.example.alan.magictower.config.ConfigRole.SLIME_LIFE;
import static com.example.alan.magictower.config.ConfigRole.SLIME_NAME;

/**
 * Function :
 * Modify Date : 2018/1/3
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class RoleFactory {

    private static class RoleHolder {
        private static RoleFactory INSTANCE = new RoleFactory();
    }

    public static RoleFactory getInstance() {
        return RoleHolder.INSTANCE;
    }

    public List<Role> getRole(int round) {

        List<Role> roleList = new ArrayList<>();
        roleList.clear();
        switch (round) {
            case 1:
                for (int i = 0; i < ROUND_ONE_SMILE_POSITION.length; i++) {
                    RoleSlimeFactory roleSlimeFactory = new RoleSlimeFactory(SLIME_ID,SLIME_NAME,"",SLIME_ALIVE,
                            SLIME_ATTACK,SLIME_DEFENSE,SLIME_LIFE,ROUND_ONE_SMILE_POSITION[i][0],ROUND_ONE_SMILE_POSITION[i][1],0, RoleType.SLIME);
                    RoleSlime slime = roleSlimeFactory.createRole();
                    roleList.add(slime);
                }
                break;
            case 2:
                break;
            default:
                break;
        }

        return roleList;
    }

}
