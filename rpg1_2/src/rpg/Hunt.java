package rpg;

import java.util.ArrayList;
import java.util.Random;

public class Hunt {
	
	public static Hunt instance =new Hunt();
	Random ran = new Random();
	ArrayList<Unit> Pl=Guild.instace.partyList;
	private int deadMem =-1;
	
	
	//파티원들끼리 사냥을 나가서 경험치가(50/level)0이하면 1올리기)  올라가고 경험치가 100이 되면 레벨이 1 올라가고 
	// 레벨이 1 올라가면 스탯hp,att,def중 하나가 5 오르는거로 하자 
	
	
	public void partyHunt() {
		if(Pl.size() !=0) {
			if(checkHp()) {
				for(int i=0; i<Pl.size(); i++) {				
					levelup(i);
					huntDemege();	
				}
				System.out.println("사냥완료!");
			}
			else {
				System.out.println("파티원이 상태 이상으로 사냥진행불가.");
			}
			try {
				Thread.sleep(500);
				Guild.instace.printParty();
				if(deadMem!= -1) {
					System.out.println(Pl.get(deadMem).getName() +" 님 사망. hp를 회복해주세요.");		
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		else {
			System.out.println("파티가 형성되지 않았습니다.");
		}
	}
	public void levelup(int i) {
		Pl.get(i).setExp(50/Pl.get(i).getLevel());
		if(Pl.get(i).getExp()>=100) {
			System.out.print(Pl.get(i).getName() +" 레벨업!!(");
			Pl.get(i).setLevel(1);
			Pl.get(i).setExp(-100);
			int ranNum = ran.nextInt(3);
			if(ranNum ==0) {
				System.out.println("att +5");
				Pl.get(i).setAtt(5);
			}
			else if(ranNum ==1) {
				System.out.println("def +5)");
				Pl.get(i).setDef(5);
			}
			else if(ranNum ==2) {
				System.out.println("Hp +5)");
				Pl.get(i).setPlusHp(5);
				Pl.get(i).setMaxHp(5);
			}
		}
	}
	public void huntDemege() {
		int ranMem = ran.nextInt(4);
	    int ranHp = ran.nextInt(10);
		Pl.get(ranMem).setMinusHp(ranHp);
		for(int i=0; i<Pl.size(); i++) {
			if(Pl.get(i).getHp()<=0) {
				Pl.get(i).setHp(0);
				deadMem = i;	
			}
		}

	
	}
	public boolean checkHp() {
		for(int i=0; i<Pl.size(); i++) {
			if(Pl.get(i).getHp()<=0) {
				return false;
			}
		}
		return true;
	}
}
