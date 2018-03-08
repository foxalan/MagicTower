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

import java.lang.ref.WeakReference;
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
    private AppCompatTextView mHeroLife;
    private AppCompatTextView mHeroAttack;
    private AppCompatTextView mHeroDefense;

    private AppCompatTextView mYellowKey;
    private AppCompatTextView mBlueKey;
    private AppCompatTextView mRedKey;

    private AppCompatTextView mRound;
    private int currentFloor = 1;

    private RoleHeroFactory mRoleHeroFactory;
    private BaseRoleHero hero;

    private HashMap<Integer, List<Obstacle>> obstacleMap = new HashMap<>();
    private HashMap<Integer, List<BaseRole>> roleMap = new HashMap<>();

    public  Handler mHandler = new MyHandler(this);

    private static class MyHandler extends Handler{

        WeakReference<MainActivity> mainActivityWeakReference;

        private MyHandler(MainActivity mainActivity){
            mainActivityWeakReference = new WeakReference<>(mainActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            MainActivity mainActivity = mainActivityWeakReference.get();
            if (mainActivity!=null){
                switch (msg.what) {
                    case 0x111:
                        mainActivity.updateHero();
                        break;
                    case 0x120:
                        mainActivity.mHeroLife.setText(String.valueOf("LIFE:" + mainActivity.hero.getLife()));
                        break;
                    default:
                        break;
                }
            }
        }
    }

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
        mHeroLife = findViewById(R.id.tv_hero_life);
        mHeroAttack = findViewById(R.id.tv_hero_attack);
        mHeroDefense = findViewById(R.id.tv_hero_defense);
        mYellowKey = findViewById(R.id.tv_hero_key_yellow);
        mBlueKey = findViewById(R.id.tv_hero_key_blue);
        mRedKey = findViewById(R.id.tv_hero_key_red);
        mRound = findViewById(R.id.tv_round);
    }

    private void initRole() {
        mRoleHeroFactory = new RoleHeroFactory(HEAR_ID, HERO_NAME, HERO_DES, ALIVE,
                HER0_ATTACK, HERO_DEFENCE, HERO_LIFE, HERO_X, HERO_Y, HERO_SPEED, RoleType.HERO);
        hero = mRoleHeroFactory.createRole();
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
        mHeroDefense.setText(String.valueOf("DEFENSE:" + hero.getDefense()));
        mHeroAttack.setText(String.valueOf("ATTACK:" + hero.getAttack()));
        mHeroLife.setText(String.valueOf("LIFE:" + hero.getLife()));
        mYellowKey.setText(String.valueOf("YELLOW KEY:" + hero.getYellowKey()));
        mBlueKey.setText(String.valueOf("BLUE KEY:" + hero.getBlueKey()));
        mRedKey.setText(String.valueOf("RED KEY:" + hero.getRedKey()));
        mRound.setText(String.valueOf("Floor:" + gamePanel.getRound()));
    }


    @Override
    public void updateHeroMessage() {
        mHandler.sendEmptyMessage(0x120);
    }
}
