package rpg;

import java.util.ArrayList;
import java.util.Random;

public class Hunt {
	
	public static Hunt instance =new Hunt();
	
	//파티원들끼리 사냥을 나가서 경험치가(50/level)0이하면 1올리기)  올라가고 경험치가 100이 되면 레벨이 1 올라가고 
	// 레벨이 1 올라가면 스탯hp,att,def중 하나가 5 오르는거로 하자 
	
	
	public void partyHunt() {
		Random ran = new Random();
		ArrayList<Unit> Pl=Guild.instace.partyList;
		for(int i=0; i<Pl.size(); i++) {
			//파티원들 exp넣어주고 100이상이면 100빼고 레벨 1 올리기 
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
					Pl.get(i).setHp(5);
					Pl.get(i).setMaxHp(5);
				}
			
				
			}
			
		}
		System.out.println("사냥완료!");
	}
}
