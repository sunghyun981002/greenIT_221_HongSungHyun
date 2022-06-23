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
		monList =null;
		monList = bm.monsterList;
		monDead = monList.size();
		playerDead = Pl.size();
		
	}
	
	
	public void print_character() {
		System.out.println("======[BATTLE]======");
		 System.out.println("어두컴컴하고 기분 나쁜 던전");
		System.out.println("======[PLAYER]======");
		guild.printParty();
		System.out.println(Pl.size());
		System.out.println("======[MONSTER]======");
		for (int i = 0; i < monList.size(); i++) {
			monList.get(i).printData();
		}
		System.out.println("=====================");
	}
	public void player_attack(int idx) {
		Unit u =Pl.get(idx);
		if(u.getHp()<=0)return;
		System.out.println("=====[메뉴 선택]=====");
		System.out.println("["+u.getName()+"] [1.공격] [2.포션마시기]");
		int sel = guild.scan.nextInt();
		if(sel ==1) {
			while(true) {
				int index =guild.ran.nextInt(monList.size());
				
				if(monList.get(index).curhp >0) {
					u.attack(monList.get(index));
					break;
				}
			}
		}
		else if(sel ==2) {
			u.drinlPotion();
		}
	}
	public void monster_attack(int idx) {

		Monster m = monList.get(idx);
		if(m.curhp <=0)return;
		while(true) {
			int index = guild.ran.nextInt(Pl.size());
			if(Pl.get(index).getHp()>0) {
				m.attack(Pl.get(index));
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			}
		}
	}
	public void check_live() {
		int num =0;
		for(int i =0; i<Pl.size(); i++) {
			if(Pl.get(i).getHp()<=0) {
				num++;
			}
		}
		playerDead = Pl.size() - num;
		num = 0;
		for (int i = 0; i < monList.size(); i++) {
			if (monList.get(i).curhp <= 0) {
				num ++;
			}
		}
		monDead = monList.size() - num;
	}
	public void PlusExp() {
		for(int i=0; i<Pl.size(); i++) {
			Pl.get(i).setExp(100/Pl.get(i).getLevel());
			if(Pl.get(i).getExp()>=100) {
				System.out.print(Pl.get(i).getName() +" 레벨업!!(");
				Pl.get(i).setLevel(1);
				Pl.get(i).setExp(-100);
				int ranNum = guild.ran.nextInt(3);
				if(ranNum ==0) {
					System.out.println("att이"+50/Pl.get(i).getLevel()+" 올랐습니다.");
					Pl.get(i).setAtt(50/Pl.get(i).getLevel());
				}
				else if(ranNum ==1) {
					System.out.println("def가"+50/Pl.get(i).getLevel()+" 올랐습니다.");
					Pl.get(i).setDef(50/Pl.get(i).getLevel());
				}
				else if(ranNum ==2) {
					System.out.println("Hp가"+80/Pl.get(i).getLevel()+" 올랐습니다.");
					Pl.get(i).setPlusHp(80/Pl.get(i).getLevel());
					Pl.get(i).setMaxHp(80/Pl.get(i).getLevel());
				}
			}
		}
	}
	
	@Override
	public boolean update() {
		boolean run = true;
		int p_idx =0;
		int m_idx =0;
		boolean turn =true;
		
		while(run) {
			if(turn) {
				print_character();
				if(p_idx<Pl.size()) {
					player_attack(p_idx);
					
					p_idx +=1;
				}
				else {
					turn = !turn; //  불리언 타입에선 같은의미 turn = turn == true ? false : true; 
					p_idx =0;
				}
			}
			else if(!turn) {
				if(m_idx < monList.size()) {
					monster_attack(m_idx);
					m_idx ++;
				}
				else {
					turn = !turn;
					m_idx =0;
				}
			}
			check_live();
			if (monDead <= 0 || playerDead <= 0)
				break;
		}
		PlusExp();
		HuntManager.nextStage ="LOBBY";
		return false;
	}


}
