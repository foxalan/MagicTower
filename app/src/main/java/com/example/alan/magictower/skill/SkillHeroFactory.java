package com.example.alan.magictower.skill;

import com.example.alan.magictower.obstacle.door.ObstacleDoor;
import com.example.alan.magictower.obstacle.jewel.ObstacleJewel;
import com.example.alan.magictower.role.Role;
import com.example.alan.magictower.role.RoleHero;
import com.example.alan.magictower.view.MagicLoader;

/**
 * Function :
 * Modify Date : 2018/1/2
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public class SkillHeroFactory implements ISillFactory, ISkillHero {

    @Override
    public boolean attack(RoleHero role, Role enemy) {

        MagicLoader.showDialogDuel(role,enemy);

        if (role.getmAttack() < enemy.getmDefense()) {
            return false;
        }

        if (role.getmDefense() > enemy.getmAttack()) {
            return true;
        }

        int countKill = enemy.getLife() / role.getmAttack() - enemy.getmDefense();
        int countByKill = role.getLife() / enemy.getmAttack() - role.getmDefense();
        if (countByKill > countKill) {
            enemy.setAlive(false);
            role.setLife(role.getLife() - countByKill * (enemy.getmAttack() - role.getmDefense()));
            return true;
        } else {
            return false;
        }
    }

    private static class HeroHolder {
        private static SkillHeroFactory INSTANCE = new SkillHeroFactory();
    }

    public static SkillHeroFactory getInstance() {
        return HeroHolder.INSTANCE;
    }


    @Override
    public ISkillHero createSkill() {
        return this;
    }


    @Override
    public void restore(Role role, int life) {

    }


    @Override
    public void addAttack(Role role, int attack, ObstacleJewel jewel) {
        role.setmAttack(role.getmAttack() + attack);
        jewel.setExist(false);
    }

    @Override
    public void addDefense(Role role, int defense, ObstacleJewel jewel) {
        role.setmDefense(role.getmDefense() + defense);
        jewel.setExist(false);
    }

    @Override
    public void openDoor(RoleHero role, ObstacleDoor door) {
        switch (door.getDoorType()) {
            case REDDOOR:
                role.setRedKey(role.getRedKey() - 1);
                break;
            case BLUEDOOR:
                role.setBlueKey(role.getBlueKey() - 1);
                break;
            case YELLOWDOOR:
                role.setYellowKey(role.getYellowKey() - 1);
                break;
            default:
                break;
        }
        door.setExist(false);
    }


}
