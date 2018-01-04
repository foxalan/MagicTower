package com.example.alan.magictower.duel;

import android.os.Message;
import android.util.Log;

import com.example.alan.magictower.role.Role;
import com.example.alan.magictower.view.MagicLoader;

/**
 * @author Alan
 */

public class RolesDuel {

	private static final String TAG = "RolesDuel";
	private boolean flag = true;

	public RolesDuel() {
	}

	public synchronized void heroAttack(Role monster,int loseLife) {
		
		if(flag) {
			Log.e(TAG, "heroAttack: "+"====" );
			if (loseLife>monster.getLife()){
				monster.setLife(0);
			}else {
				monster.setLife(monster.getLife()-loseLife);
			}
			int life = monster.getLife();
			Message message = new Message();
			message.what = 0x122;
			message.obj = life;
			MagicLoader.mHandler.sendMessage(message);
			flag = !flag;
			notifyAll();

		}else{
			Log.e(TAG, "heroWait: "+"====" );
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public synchronized void monsterAttack(Role hero,int loseLife) {
		
		if(!flag) {
			hero.setLife(hero.getLife()-loseLife);
			Log.e(TAG, "monsterAttack: " + "=====");
			int life = hero.getLife();
			Message message = new Message();
			message.what = 0x123;
			message.obj = life;
			MagicLoader.mHandler.sendMessage(message);

			flag = !flag;
			notifyAll();

		}else {
			Log.e(TAG, "monsterWait: " + "=====");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
