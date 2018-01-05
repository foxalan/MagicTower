package com.example.alan.magictower.factory;

import com.example.alan.magictower.role.Role;

import java.util.ArrayList;
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

    private static class RoleHolder {
        private static RoleFactory INSTANCE = new RoleFactory();
    }

    public static RoleFactory getInstance() {
        return RoleHolder.INSTANCE;
    }

    public List<Role> getRole(int round) {

        List<Role> roleList = new ArrayList<>();
        roleList.clear();



        return roleList;
    }

}
