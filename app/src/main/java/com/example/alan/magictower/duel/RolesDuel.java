package com.example.alan.magictower.duel;

import android.os.Message;

import com.example.alan.magictower.role.Role;
import com.example.alan.magictower.view.MagicLoader;

/**
 * @author Alan
 */

public class RolesDuel {
	

	private boolean flag = true;

	public RolesDuel() {
	}

	public synchronized void heroAttack(Role monster,int loseLife) {
		
		if(flag) {
			monster.setLife(monster.getLife()-loseLife);
			int life = monster.getLife();
			Message message = new Message();
			message.what = 0x122;
			message.obj = life;
			MagicLoader.mHandler.sendMessage(message);
			flag = !flag;
			notifyAll();

		}else{
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

			int life = hero.getLife();
			Message message = new Message();
			message.what = 0x123;
			message.obj = life;
			MagicLoader.mHandler.sendMessage(message);

			flag = !flag;
			notifyAll();

		}else {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
