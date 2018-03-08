package com.example.alan.magictower;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;

import com.example.alan.magictower.callback.IDuelOverCallBack;
import com.example.alan.magictower.callback.IHeroPowerChangeCallBack;
import com.example.alan.magictower.factory.ObstacleFactory;
import com.example.alan.magictower.factory.RoleFactory;
import com.example.alan.magictower.factory.RoleHeroFactory;
import com.example.alan.magictower.obstacle.Obstacle;
import com.example.alan.magictower.role.BaseRole;
import com.example.alan.magictower.role.BaseRoleHero;
import com.example.alan.magictower.role.RoleType;
import com.example.alan.magictower.skill.SkillHeroFactory;
import com.example.alan.magictower.view.GamePanel;
import com.example.alan.magictower.view.MagicLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.alan.magictower.config.ConfigRole.ALIVE;
import static com.example.alan.magictower.config.ConfigRole.HEAR_ID;
import static com.example.alan.magictower.config.ConfigRole.HER0_ATTACK;
import static com.example.alan.magictower.config.ConfigRole.HERO_DEFENCE;
import static com.example.alan.magictower.config.ConfigRole.HERO_DES;
import static com.example.alan.magictower.config.ConfigRole.HERO_LIFE;
import static com.example.alan.magictower.config.ConfigRole.HERO_NAME;
import static com.example.alan.magictower.config.ConfigRole.HERO_SPEED;
import static com.example.alan.magictower.config.ConfigRole.HERO_X;
import static com.example.alan.magictower.config.ConfigRole.HERO_Y;
import static com.example.alan.magictower.config.ConfigRole.KEY_BLUE;
import static com.example.alan.magictower.config.ConfigRole.KEY_RED;
import static com.example.alan.magictower.config.ConfigRole.KEY_YELLOW;


/**
 * @author Alan
 */

public class MainActivity extends AppCompatActivity implements IHeroPowerChangeCallBack, IDuelOverCallBack {

    private static final String TAG = "MainActivity";
    private GamePanel gamePanel;
    private AppCompatTextView tv_hero_life;
    private AppCompatTextView tv_hero_attack;
    private AppCompatTextView tv_hero_defense;

    private AppCompatTextView tv_hero_yellow_key;
    private AppCompatTextView tv_hero_blue_key;
    private AppCompatTextView tv_hero_red_key;

    private AppCompatTextView tv_round;
    private int currentFloor = 1;

    private RoleHeroFactory roleHeroFactory;
    private BaseRoleHero hero;

    private List<BaseRole> baseRoleList = new ArrayList<>();

    private HashMap<Integer, List<Obstacle>> obstacleMap = new HashMap<>();
    private HashMap<Integer, List<BaseRole>> roleMap = new HashMap<>();

    public Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0x111:
                    updateHero();
                    break;
                case 0x120:
                    tv_hero_life.setText("LIFE:" + hero.getLife());
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initRole();
        initRoleMonster();
        initObstacle();
        initEvent();
    }


    @Override
    protected void onResume() {
        super.onResume();
        MagicLoader.getInstance().initDialogDuel(this);
    }

    private void initObstacle() {
        int round = ObstacleFactory.getInstance().getRound();
        for (int i = 0; i < round; i++) {
            obstacleMap.put(i + 1, ObstacleFactory.getInstance().getObstacle(i + 1));
        }
    }


    private void initRoleMonster() {
        int round = RoleFactory.getInstance().getRound();
        for (int i = 0; i < round; i++) {
            roleMap.put(i + 1, RoleFactory.getInstance().getRole(i + 1));
        }
        Log.e(TAG, "initRoleMonster: "+roleMap.size());
    }

    private void initViews() {

        gamePanel = findViewById(R.id.gamePanel);
        tv_hero_life = findViewById(R.id.tv_hero_life);
        tv_hero_attack = findViewById(R.id.tv_hero_attack);
        tv_hero_defense = findViewById(R.id.tv_hero_defense);
        tv_hero_yellow_key = findViewById(R.id.tv_hero_key_yellow);
        tv_hero_blue_key = findViewById(R.id.tv_hero_key_blue);
        tv_hero_red_key = findViewById(R.id.tv_hero_key_red);
        tv_round = findViewById(R.id.tv_round);
    }

    private void initRole() {
        roleHeroFactory = new RoleHeroFactory(HEAR_ID, HERO_NAME, HERO_DES, ALIVE,
                HER0_ATTACK, HERO_DEFENCE, HERO_LIFE, HERO_X, HERO_Y, HERO_SPEED, RoleType.HERO);
        hero = roleHeroFactory.createRole();
        hero.setYellowKey(KEY_YELLOW);
        hero.setBlueKey(KEY_BLUE);
        hero.setRedKey(KEY_RED);
    }

    private void initEvent() {
        gamePanel.setRole(hero);
        gamePanel.setListHashMap(obstacleMap);
        gamePanel.setRoleHashMap(roleMap);
        gamePanel.setRound(currentFloor);

        gamePanel.setHeroPowerChangeCallBack(this);

        hero.setSkillHeroFactory(SkillHeroFactory.getInstance());
        MagicLoader.getInstance().setiDuelOverCallBack(this);

        updateHero();
    }


    @Override
    public void updateHeroPower() {
        mHandler.sendEmptyMessage(0x111);
    }

    /**
     * 更新数值
     */
    private void updateHero() {
        tv_hero_defense.setText("DEFENSE:" + hero.getDefense());
        tv_hero_attack.setText("ATTACK:" + hero.getAttack());
        tv_hero_life.setText("LIFE:" + hero.getLife());
        tv_hero_yellow_key.setText("YELLOW KEY:" + hero.getYellowKey());
        tv_hero_blue_key.setText("BLUE KEY:" + hero.getBlueKey());
        tv_hero_red_key.setText("RED KEY:" + hero.getRedKey());
        tv_round.setText("Floor:" + gamePanel.getRound());
    }


    @Override
    public void updateHeroMessage() {
        mHandler.sendEmptyMessage(0x120);
    }
}
