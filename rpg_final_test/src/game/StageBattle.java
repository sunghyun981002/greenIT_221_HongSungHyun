package game;

import java.util.ArrayList;

public class StageBattle extends Stage{

	ArrayList<Unit> Pl=Guild.instace.partyList;
	
	Guild guild=Guild.instace;
	private int monDead = 0;
	private int playerDead =0;
	
	
	
	
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

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
