package zombi1_1;

public class Hero extends Unit{
	int power;
	int count;
	
	public Hero(int pos, int hp, int Max, int count) {
		super(pos,hp,Max);
		this.count =count;
	}
	// 공격
	public void attack(Unit enemy) {
		
		if(enemy instanceof Boss) {
			Boss boss = (Boss) enemy;
			power = r.nextInt(max)+1;
			if(boss.getShield()>0) {
				int a =boss.getShield() - power;
				if(a>=0) {
					boss.setShield(a);
				}
				else {
					boss.setShield(0);
					boss.setHp(boss.getHp()+a);
				}
			}
			else {
				boss.setHp(boss.getHp() -power);
			}
			
			if(boss.getHp() <=0) {
				boss.setHp(0);
			}
		}
	}
	
	
	// 회복 

}
