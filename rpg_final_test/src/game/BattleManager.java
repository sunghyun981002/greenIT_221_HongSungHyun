package game;

import java.util.ArrayList;

public class BattleManager {
	ArrayList<Unit> partyList = new ArrayList<>();
	ArrayList<Monster> monsterList = new ArrayList<>();
	String Path ="game.";
	String mons[] = { "MonsterBat", "MonsterZombie" ,"MonsterWolf"};
	private int cnt=-1;
	private int aftercnt=1;
	//사냥까지 완성(아이템 빼기 기능 , 유저별 파티 리스트 부분 수정해야함)


	public void monsterRandomSet(int size) {
		cnt++;
		
		for(int i=0; i<size; i++) {
			try {
				if(cnt>=3) {
					cnt =2;
					aftercnt++;
				}
				Class<?> clazz = Class.forName(Path+mons[cnt]);
				Object obj =clazz.getDeclaredConstructor().newInstance();
				Monster temp = (Monster) obj;
				int hp = Guild.instace.ran.nextInt(100)+(20*cnt*aftercnt);
				int pow = Guild.instace.ran.nextInt(50)+(20*cnt*aftercnt);
				temp.init(hp,pow);
				monsterList.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
