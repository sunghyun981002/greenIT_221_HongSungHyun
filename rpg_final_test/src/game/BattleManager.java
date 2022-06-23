package game;

import java.util.ArrayList;

public class BattleManager {
	ArrayList<Unit> partyList = new ArrayList<>();
	ArrayList<Monster> monsterList = new ArrayList<>();
	String Path ="game.";
	String mons[] = {"Wolf" ,"zombie" , "Bat"};
	

	public void monsterRandomSet(int size) {
		for(int i=0; i<size; i++) {
			int num = Guild.instace.ran.nextInt(mons.length);
			try {
				Class<?> clazz = Class.forName(Path+mons[num]);
				Object obj =clazz.getDeclaredConstructor().newInstance();
				Monster temp = (Monster) obj;
				int hp = Guild.instace.ran.nextInt(100)+200;
				int pow = Guild.instace.ran.nextInt(10)+15;
				temp.init(hp,pow);
				monsterList.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
