package com.example.alan.magictower.duel;

import android.support.v7.widget.AppCompatTextView;
import android.util.Log;

import com.example.alan.magictower.role.BaseRole;

/**
 * @author Alan
 */

public class MonsterAttackThread extends Thread {

    private static final String TAG = "MonsterAttackThread";
    private BaseRole hero;
    private BaseRole monster;
    private RolesDuel rolesDuel;
    private int count;
    private AppCompatTextView tv_hero_life;
    private int loseLife;

    public MonsterAttackThread(RolesDuel rolesDuel, BaseRole hero, BaseRole monster, AppCompatTextView tv_hero_life) {
        this.rolesDuel = rolesDuel;
        this.hero = hero;
        this.monster = monster;
        this.tv_hero_life = tv_hero_life;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();

        count = (monster.getLife() / (hero.getAttack() - monster.getDefense()))+100;
        Log.d(TAG, "run: "+ count);
        loseLife = monster.getAttack() - hero.getDefense();
        for (int i = 0; i < count; i++) {
            if (monster.getLife() == 0){
                break;
            }

            try {
                sleep(200);
                rolesDuel.monsterAttack(hero,loseLife);
                Log.e(TAG, "run: "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
