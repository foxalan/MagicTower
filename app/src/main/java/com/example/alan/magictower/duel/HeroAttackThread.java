package com.example.alan.magictower.duel;

import android.support.v7.widget.AppCompatTextView;

import com.example.alan.magictower.role.Role;
import com.example.alan.magictower.view.MagicLoader;

public class HeroAttackThread extends Thread {

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
        count = (monster.getLife() / (hero.getmAttack() - monster.getmDefense()))+1;
        loseLife = hero.getmAttack() - monster.getmDefense();
        for (int i = 0; i < count; i++) {
            try {
                sleep(2000);
                rolesDuel.heroAttack(monster,loseLife);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            sleep(500);
            MagicLoader.stopLoading();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
