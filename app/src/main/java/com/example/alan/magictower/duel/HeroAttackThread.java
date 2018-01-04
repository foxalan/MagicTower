package com.example.alan.magictower.duel;

import android.support.v7.widget.AppCompatTextView;
import android.util.Log;

import com.example.alan.magictower.role.Role;
import com.example.alan.magictower.view.MagicLoader;

/**
 * @author Alan
 */

public class HeroAttackThread extends Thread {
    private static final String TAG = "HeroAttackThread";

    private Role hero;
    private Role monster;
    private RolesDuel rolesDuel;
    private int count;
    private AppCompatTextView tv_monster_life;
    private int loseLife;

    public HeroAttackThread(RolesDuel rolesDuel, Role hero, Role monster, AppCompatTextView tv_monster_life) {
        this.rolesDuel = rolesDuel;
        this.hero = hero;
        this.monster = monster;
        this.tv_monster_life = tv_monster_life;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();
        count = (monster.getLife() / (hero.getmAttack() - monster.getmDefense())) + 100;
        Log.d(TAG, "run: " + count);
        loseLife = hero.getmAttack() - monster.getmDefense();
        for (int i = 0; i < count; i++) {

            if (monster.getLife() == 0) {
                break;
            }

            try {
                sleep(200);
                rolesDuel.heroAttack(monster, loseLife);
                Log.e(TAG, "run: " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            sleep(500);
            MagicLoader.getInstance().stopLoading();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
