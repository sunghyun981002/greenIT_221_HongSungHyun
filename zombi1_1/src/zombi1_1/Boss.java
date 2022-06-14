package zombi1_1;

import java.util.*;

public class Boss extends Zombi{
	
	Random r =new Random();
	
	private int shield;

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	public Boss(int pos, int hp, int max , int shield) {
		super(pos, hp, max);
		this.shield = shield;
	}
	
	
	public void attack(Unit hero) {
		int a= r.nextInt(4)+1;
		if(a==1) {
			System.out.println("Critical Hit!!");
			int power = 2*(r.nextInt(max)+1);
			hero.setHp(hero.getHp()-power);
			if(hero.getHp() <= 0) {
				hero.setHp(0);
			}
			System.out.println("보스가 " + power + "의 공격력으로 공격 :" + " 현재 Hero hp : " + hero.getHp());
		}
		else {
			System.out.println("Hit!");
			int power = r.nextInt(max)+1;
			hero.setHp(hero.getHp()-power);
			if(hero.getHp() <= 0) {
				hero.setHp(0);
			}
			System.out.println("보스가 " + power + "의 공격력으로 공격 :" + " 현재 Hero hp : " + hero.getHp());
			
		}
	}

}
