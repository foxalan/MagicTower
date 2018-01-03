package com.example.alan.magictower;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;

import com.example.alan.magictower.callback.IHeroPowerChangeCallBack;
import com.example.alan.magictower.factory.IRoleHeroFactory;
import com.example.alan.magictower.factory.ObstacleFactory;
import com.example.alan.magictower.obstacle.door.ObstacleDoor;
import com.example.alan.magictower.obstacle.jewel.ObstacleJewel;
import com.example.alan.magictower.obstacle.wood.ObstacleWood;
import com.example.alan.magictower.role.RoleHero;
import com.example.alan.magictower.skill.SkillHeroFactory;
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


/**
 * @author Alan
 */

public class MainActivity extends AppCompatActivity implements IHeroPowerChangeCallBack{

    private GamePanel gamePanel;
    private AppCompatTextView tv_hero_life;
    private AppCompatTextView tv_hero_attack;
    private AppCompatTextView tv_hero_defense;

    private AppCompatTextView tv_hero_yellow_key;
    private AppCompatTextView tv_hero_blue_key;
    private AppCompatTextView tv_hero_red_key;

    private IRoleHeroFactory roleHeroFactory;
    private RoleHero hero;
    public Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0x111:
                    updateHero();
                    break;
                default:
                    break;
            }
        }
    };

    private List<ObstacleWood> obstacleWoodList = new ArrayList<>();
    private List<ObstacleDoor> obstacleDoorList = new ArrayList<>();
    private List<ObstacleJewel> obstacleJewelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initRole();
        initWood();
        initDoor();
        initJewel();
        initEvent();
    }

    private void initViews() {
        gamePanel = findViewById(R.id.gamePanel);
        tv_hero_life = findViewById(R.id.tv_hero_life);
        tv_hero_attack = findViewById(R.id.tv_hero_attack);
        tv_hero_defense = findViewById(R.id.tv_hero_defense);
        tv_hero_yellow_key = findViewById(R.id.tv_hero_key_yellow);
        tv_hero_blue_key = findViewById(R.id.tv_hero_key_blue);
        tv_hero_red_key = findViewById(R.id.tv_hero_key_red);
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
        gamePanel.setObstacleDoorList(obstacleDoorList);
        gamePanel.setObstacleJewelList(obstacleJewelList);
        gamePanel.setHeroPowerChangeCallBack(this);

        hero.setSkillHeroFactory(SkillHeroFactory.getInstance());

        updateHero();
    }

    /**
     * 初始化木頭
     */
    private void initWood() {
       obstacleWoodList = ObstacleFactory.getInstance().createWood();
    }

    /**
     * 初始化门
     */
    private void initDoor() {
        obstacleDoorList = ObstacleFactory.getInstance().createDoor();
    }

    /**
     * 初始化宝石
     */
    private void initJewel() {
         obstacleJewelList = ObstacleFactory.getInstance().createJewel();
    }

    @Override
    public void updateHeroPower() {
        mHandler.sendEmptyMessage(0x111);
    }

    /**
     * 更新数值
     */
    private void updateHero(){
        tv_hero_defense.setText("DEFENSE:"+hero.getmDefense());
        tv_hero_attack.setText("ATTACK:"+hero.getmAttack());
        tv_hero_life.setText("LIFE:"+hero.getLife());
        tv_hero_yellow_key.setText("YELLOW KEY:"+hero.getYellowKey());
        tv_hero_blue_key.setText("BLUE KEY:"+hero.getBlueKey());
        tv_hero_red_key.setText("RED KEY:"+hero.getRedKey());
    }
}
