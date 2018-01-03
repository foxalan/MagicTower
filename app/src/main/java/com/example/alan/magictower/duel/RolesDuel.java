package com.example.alan.magictower.duel;

import android.support.v7.widget.AppCompatTextView;

import com.example.alan.magictower.role.Role;

/**
 * @author Alan
 */

public class RolesDuel {
	

	private boolean flag = true;

	public RolesDuel() {
	}

	public synchronized void heroAttack(Role monster,int loseLife, AppCompatTextView tv_monster_life) {
		
		if(flag) {
			
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
		
		System.out.println("------"+toString());
	}
	
	public synchronized void MonsterAttack(double money,String name) {
		
		if(!flag) {

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
