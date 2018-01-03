package com.example.alan.magictower;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.alan.magictower.factory.IRoleHeroFactory;
import com.example.alan.magictower.obstacle.factory.IObstacleWoodFactory;
import com.example.alan.magictower.obstacle.wood.ObstacleWood;
import com.example.alan.magictower.role.RoleHero;
import com.example.alan.magictower.view.GamePanel;

import java.util.ArrayList;
import java.util.List;

import static com.example.alan.magictower.config.Config.ALIVE;
import static com.example.alan.magictower.config.Config.HEAR_ID;
import static com.example.alan.magictower.config.Config.HER0_ATTACK;
import static com.example.alan.magictower.config.Config.HERO_DEFENCE;
import static com.example.alan.magictower.config.Config.HERO_DES;
import static com.example.alan.magictower.config.Config.HERO_LIFE;
import static com.example.alan.magictower.config.Config.HERO_NAME;
import static com.example.alan.magictower.config.Config.HERO_SPEED;
import static com.example.alan.magictower.config.Config.HERO_X;
import static com.example.alan.magictower.config.Config.HERO_Y;
import static com.example.alan.magictower.config.Config.KEY_BLUE;
import static com.example.alan.magictower.config.Config.KEY_RED;
import static com.example.alan.magictower.config.Config.KEY_YELLOW;
import static com.example.alan.magictower.config.ConfigPositon.ROUND_ONE_WOOD_POSITION;


/**
 * @author Alan
 */

public class MainActivity extends AppCompatActivity {

    private GamePanel gamePanel;

    private IRoleHeroFactory roleHeroFactory;
    private RoleHero hero;

    private List<ObstacleWood> obstacleWoodList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initRole();
        initWood();
        initEvent();
    }

    private void initViews() {
        gamePanel = findViewById(R.id.gamePanel);
    }

    private void initRole() {
        roleHeroFactory = new IRoleHeroFactory(HEAR_ID, HERO_NAME, HERO_DES, ALIVE,
                HER0_ATTACK, HERO_DEFENCE, HERO_LIFE, HERO_X, HERO_Y, HERO_SPEED);
        hero = roleHeroFactory.createRole();
        hero.setYellowKey(KEY_YELLOW);
        hero.setBlueKey(KEY_BLUE);
        hero.setRedKey(KEY_RED);
    }

    private void initEvent() {
        gamePanel.setRole(hero);
        gamePanel.setObstacleWoodList(obstacleWoodList);
    }

    /**
     * 初始化木頭
     */
    private void initWood() {
        for(int i = 0;i<ROUND_ONE_WOOD_POSITION.length;i++){
            IObstacleWoodFactory woodFactory = new IObstacleWoodFactory(ROUND_ONE_WOOD_POSITION[i][0],ROUND_ONE_WOOD_POSITION[i][1],true);
            ObstacleWood wood = woodFactory.createObstacle();
            obstacleWoodList.add(wood);
        }
    }


}
