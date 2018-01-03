package com.example.alan.magictower.duel;

public class MonsterAttackThread extends Thread{
	
	private RolesDuel rolesDuel;
	private double money;
	private String name;

	public MonsterAttackThread(RolesDuel rolesDuel, double money, String name) {
		this.rolesDuel = rolesDuel;
		this.money = money;
		this.name = name;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("------");
		for(int i =0;i<100;i++) {

		}
	}
	
	
}
