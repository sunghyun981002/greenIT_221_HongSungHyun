package zombi1_2;

import java.util.*;


public class Boss extends Zombi {

	Random r = new Random();

	private int shield;
	
	public void setShield(int value) {
		shield = value;
	}
	public int getShield() {
		return shield;
	}
	
	
	public Boss(int pos, int hp, int max, int shield) {
		super(pos, hp, max);
		this.shield = shield;
	}

	public void attack(Unit hero) {

		int a = r.nextInt(4) + 1;
		if (a == 1) {
			int power = 2 * (r.nextInt(getMax()) + 1);
			hero.setHp(hero.getHp() - power);
			if(hero.getHp() <= 0) {
				hero.setHp(0);
			}
			System.out.println("<< 보스의 크리티컬공격! (" + power + ") / 현재 Hero hp : " + hero.getHp());
		} else {
			int power = r.nextInt(getMax()) + 1;
			hero.setHp(hero.getHp() - power);
			if(hero.getHp() <= 0) {
				hero.setHp(0);
			}
			System.out.println("<< 보스의 기본공격! (" + power + ") / 현재 Hero hp : " + hero.getHp());
		}
	}

}