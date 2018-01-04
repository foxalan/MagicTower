package com.example.alan.magictower.duel;

import android.support.v7.widget.AppCompatTextView;
import android.util.Log;

import com.example.alan.magictower.role.Role;

/**
 * @author Alan 
 */

public class MonsterAttackThread extends Thread {

    private static final String TAG = "MonsterAttackThread";
    private Role hero;
    private Role monster;
    private RolesDuel rolesDuel;
    private int count;
    private AppCompatTextView tv_hero_life;
    private int loseLife;

    public MonsterAttackThread(RolesDuel rolesDuel, Role hero, Role monster,AppCompatTextView tv_hero_life) {
        this.rolesDuel = rolesDuel;
        this.hero = hero;
        this.monster = monster;
        this.tv_hero_life = tv_hero_life;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();

        count = (monster.getLife() / (hero.getmAttack() - monster.getmDefense()))+100;
        Log.d(TAG, "run: "+ count);
        loseLife = monster.getmAttack() - hero.getmDefense();
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
