package com.example.alan.magictower.duel;

public class HeroAttackThread extends Thread{
	
	public RolesDuel rolesDuel;
	public int count;
	
	public HeroAttackThread(RolesDuel rolesDuel, int count, int loseLife) {
		this.rolesDuel = rolesDuel;
		this.count = count;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		for(int i =0;i<count;i++) {

		}
	}

}
