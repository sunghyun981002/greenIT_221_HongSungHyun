package zombi1_1;

public class Zombi extends Unit{
	int power;

	public Zombi(int pos, int hp, int max) {
		super(pos, hp, max);
	}
	
	//공격 
	public void attack(Unit hero) {
		power = r.nextInt(max)+1;
		
		//공격 
		hero.setHp(hero.getHp() -power);
		if(hero.getHp()<=0) {
			hero.setHp(0);
		}
		//회복
		super.setHp(super.getHp()+(power/2));
		
		
		System.out.println("좀비가 "+ power + "의 공격력으로 공격 :"
				+ " 현재 Hero hp : "+ hero.getHp()+",좀비 체력 회복 " + this.getHp()); 
	}

}
