package game;

import java.util.ArrayList;

public class BattleManager {
	ArrayList<Unit> partyList = new ArrayList<>();
	ArrayList<Monster> monsterList = new ArrayList<>();
	String Path ="game.";
	String mons[] = { "MonsterBat", "MonsterZombie" ,"MonsterWolf"};
	private int cnt=-1;
	

	public void monsterRandomSet(int size) {
		cnt++;
		
		for(int i=0; i<size; i++) {
			try {
				Class<?> clazz = Class.forName(Path+mons[cnt]);
				Object obj =clazz.getDeclaredConstructor().newInstance();
				Monster temp = (Monster) obj;
				int hp = Guild.instace.ran.nextInt(100)+(20*cnt);
				int pow = Guild.instace.ran.nextInt(50)+(20*cnt);
				temp.init(hp,pow);
				monsterList.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
