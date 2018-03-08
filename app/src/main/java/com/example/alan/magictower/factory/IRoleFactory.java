package com.example.alan.magictower.factory;

import com.example.alan.magictower.role.BaseRole;

/**
 * Function :
 * Modify Date : 2018/1/2
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public interface IRoleFactory {

    /**
     * 将工厂抽象返回一个Role
     * @return
     */
    BaseRole createRole();
}
