package zombi1_2;


// 보스인지 아닌지 구분해서 공격 

public class Hero extends Unit {
	private int power;
	private int count;
	
	public Hero(int pos, int hp, int max, int count) {
		super(pos, hp, max);
		this.count = count;
	}

	public void attack(Unit enemy) {
		
		if(enemy instanceof Boss) {
			Boss boss = (Boss)enemy;
			int a=r.nextInt(4)+1;
			if(a!=1) {
				power = r.nextInt(getMax()) + 1;
				if( boss.getShield() > 0) {
					int r = boss.getShield() - power;
					if(r >= 0) {
						boss.setShield(boss.getShield()- power);
					}else {
						boss.setShield(0);
						boss.setHp(boss.getHp() + r);
					}
				}	
				else {
					boss.setHp(boss.getHp() - power);
				}
				
				if(boss.getHp() <= 0) {
					boss.setHp(0);
				}
				System.out.println(">> 히어로의 기본공격! (" + power  + ")  / 현재 Boss hp : " + boss.getHp() + " / 현재 Boss Shield : " + boss.getShield());				
			}
			else {
				power = 3*(r.nextInt(getMax()) + 1);
				if( boss.getShield() > 0) {
					int r = boss.getShield() - power;
					if(r >= 0) {
						boss.setShield(boss.getShield()- power);
					}else {
						boss.setShield(0);
						boss.setHp(boss.getHp() + r);
					}
				}	
				else {
					boss.setHp(boss.getHp() - power);
				}
				
				if(boss.getHp() <= 0) {
					boss.setHp(0);
				}
				System.out.println(">> 히어로의 크리트컬공격!! (" + power  + ")  / 현재 Boss hp : " + boss.getHp() + " / 현재 Boss Shield : " + boss.getShield());				

			}
		}else {
		
			power = r.nextInt(getMax()) + 1;
			enemy.setHp(enemy.getHp() - power);
			if(enemy.getHp() <= 0) {
				enemy.setHp(0);
			}
			System.out.println(">> 히어로의 기본공격! (" + power  + ")  / 현재 Zombie hp : " + enemy.getHp());
		}
	}



	public void recovery() {
		if(count > 0) {
			setHp(getHp() + 100);
			System.out.println("체력 회복해서" + getHp() + "이 되었습니다");
			count -= 1;
		}else if(count == 0) {
			System.out.println("모두 사용했습니다. ");
		}
		
	}


}