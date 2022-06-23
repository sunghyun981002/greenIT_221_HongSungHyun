package game;

public abstract class Monster {

	int curhp;
	int maxhp;
	int power;
	String name;
	String stage = "노말";
	
	
	Monster(){
		
	}
			
	Monster(String na, int max, int pw) {
		name = na;
		maxhp = max;
		curhp = max;
		power = pw;
	}
	
	void init(int max, int pw) {
		maxhp = max;
		curhp = max;
		power = pw;
	}
	void init(String na, int max, int pw) {
		name = na;
		maxhp = max;
		curhp = max;
		power = pw;
	}
	void attack(Unit target) {
		target.setMinusHp(power/(target.getDef()/10)); 
		System.out.println("[" + target.getName() + "]  <<<<" + "[" + name + "] <" + power + "> ");
		if (target.getHp() <= 0) {
			System.out.println("[" + target.getName() + "] 을 쳐치했습니다.");
			target.setHp(0);
		}
	}

	void printData() {
		System.out.println("[" + name + "] [" + curhp + "/" + maxhp + "] [" + power + "]");
	}
			
}
