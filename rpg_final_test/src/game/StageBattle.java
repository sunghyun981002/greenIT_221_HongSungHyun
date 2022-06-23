package game;

import java.util.ArrayList;

public class StageBattle extends Stage{
	BattleManager bm = new BattleManager();
	ArrayList<Unit> Pl=Guild.instace.partyList;
	ArrayList<Monster> monList;
	Guild guild=Guild.instace;
	private int monDead = 0;
	private int playerDead =0;
	
	
	@Override
	public void init() {
		bm.monsterList.clear();
		bm.monsterRandomSet(4);
		
	}
	
	
	void print_character() {
		System.out.println("======[BATTLE]======");
		// System.out.println(playerSize + " " + monSize);
		System.out.println("======[PLAYER]======");
		for (int i = 0; i < Pl.size(); i++) {
			guild.printParty();
		}
		System.out.println("======[MONSTER]======");
//		for (int i = 0; i < monList.size(); i++) {
//			monList.get(i).printData();
//		}
	}
	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}


}
