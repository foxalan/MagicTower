package com.example.alan.magictower.skill;

import com.example.alan.magictower.obstacle.door.ObstacleDoor;
import com.example.alan.magictower.obstacle.jewel.ObstacleJewel;
import com.example.alan.magictower.role.BaseRole;
import com.example.alan.magictower.role.BaseRoleHero;
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
    public boolean attack(BaseRoleHero role, BaseRole enemy) {

        if (role.getAttack() < enemy.getDefense()) {
            return false;
        }

        int countKill = enemy.getLife() / role.getAttack() - enemy.getDefense();
        int countByKill = role.getLife() / enemy.getAttack() - role.getDefense();
        if (countByKill > countKill) {
            MagicLoader.getInstance().showDialogDuel(role,enemy);
            enemy.setAlive(false);
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
    public void restore(BaseRole baseRole, int life) {
    }

    @Override
    public void addAttack(BaseRole baseRole, int attack, ObstacleJewel jewel) {
        baseRole.setAttack(baseRole.getAttack() + attack);
        jewel.setExist(false);
    }

    @Override
    public void addDefense(BaseRole baseRole, int defense, ObstacleJewel jewel) {
        baseRole.setDefense(baseRole.getDefense() + defense);
        jewel.setExist(false);
    }

    @Override
    public void openDoor(BaseRoleHero role, ObstacleDoor door) {
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
