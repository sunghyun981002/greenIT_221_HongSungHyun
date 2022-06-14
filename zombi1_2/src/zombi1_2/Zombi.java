package zombi1_2;


public class Zombi extends Unit {
	private int power;
	
	public Zombi(int pos,int hp,int max) {
		super(pos,hp,max);
	}
	
	public void attack(Unit hero) {
		power = r.nextInt(getMax())+1;
		
		hero.setHp(hero.getHp()-power);
		if(hero.getHp() <= 0) {
			hero.setHp(0);
		}
		
		this.setHp(this.getHp()+power/2);
		
		System.out.println("좀비의 기본 공격!! ("+ power + ") / 현재 Hero hp : "+ hero.getHp());
		System.out.println("좀비 체력 회복 -> " + this.getHp() );
		
		
	}

}