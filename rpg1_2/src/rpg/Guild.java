package rpg;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Guild {
	public static Guild instace = new Guild();
	private final int PARTY_SIZE =4;
	ArrayList<Unit> guildList = new ArrayList<>();
	ArrayList<Unit> partyList = new ArrayList<>();
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);
	private Guild() {
		
	}
	
	public void setGuild() {
		Unit temp = new Unit("성현",100,100,100,100,99);
		guildList.add(temp);
		temp = new Unit("하늘",10,10,10,10,10);
		guildList.add(temp);
		temp = new Unit("수지",3,50,10,30,1);
		guildList.add(temp);
		temp = new Unit("태연",5,80,20,10,1);
		guildList.add(temp);
		temp = new Unit("혜리",7,90,20,3,1);
		guildList.add(temp);
		temp = new Unit("이현",17,80,30,30,2);
		guildList.add(temp);
		
		// party =True 부여 
		for(int i=0; i<4; i++) {
			guildList.get(i).setParty(true);
		}
		setPartyList();
	}
	public void setPartyList() {
		// partyList에 넣어주기 
		for(int i=0; i<guildList.size();i++) {
			if(guildList.get(i).isParty()==true){// 파티가 트루일때 영입
				partyList.add(guildList.get(i));
			}	
		}
		
	}
	
	public Unit getGuildUnit(int num) { // 길드원 호출 
		return guildList.get(num);
	}
	
	public void printAllguildList() { //길드원 플레이 
		System.out.println("======================================");
		System.out.println("[골드 : " + Player.instance.money + "]"); //플레이어 만들어주고 다시오기
		System.out.println("============= [길드원] =================");
		for(int i=0; i<guildList.size(); i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + guildList.get(i).getName() + "]");
			System.out.print(" [레벨 : " + guildList.get(i).getLevel() + "]");
			System.out.print(" [체력 : " + guildList.get(i).getHp());
			System.out.println(" / " + guildList.get(i).getMaxHp() + "]");
			System.out.print("[공격력 : " + guildList.get(i).getAtt() + "]");
			System.out.print(" [방어력 : " + guildList.get(i).getDef() + "]");
			System.out.println(" [파티중 : " + guildList.get(i).isParty() + "]");
			System.out.println("");
		}
		System.out.println("=================================");
		
	}
	
	public void addUnit() { // 길드원 생성 
		if(Player.instance.money <5000)return;
		
		
		String[] n1 = {"시","주","성","기","재","수","지","정",};
		String[] n2 = {"현","민","진","찬","준","연","영","윤",};
		
		String name =n1[ran.nextInt(n1.length)];
		name +=n2[ran.nextInt(n2.length)];
		int ranN = ran.nextInt(8)+2;
		int hp = ranN *10;
		int att = ranN+2;
		int def = ranN;
		Unit temp = new Unit(name,1,hp,att,def,0);
		
		System.out.println("=====================================");
		System.out.print("[이름 : " + name + "]");
		System.out.print(" [레벨 : " + 1 + "]");
		System.out.print(" [체력 : " + hp);
		System.out.println(" / " + hp + "]");
		System.out.print("[공격력 : " + att + "]");
		System.out.println(" [방어력 : " + def + "]");
		System.out.println("길드원을 추가합니다.");
		System.out.println("=====================================");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		guildList.add(temp);
		Player.instance.money -=5000;
	}
    public void removeUnit() { // 길드원 삭제
    	printAllguildList();
    	System.out.println("삭제할 번호 입력하세요 .");
    	int sel = scan.nextInt();
    	
    	if(guildList.get(sel-1).isParty()) {
    		System.out.println("파티중인 멤버는 삭제 불가.");
    	}
    	else {
    		guildList.remove(sel-1);
    		System.out.println("삭제 완료.");
    	}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    public void printParty() {
    	System.out.println("============= [파티원] =================");
    	for(int i=0; i<partyList.size(); i++) {
    		System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + partyList.get(i).getName() + "]");
			System.out.print(" [레벨 : " + partyList.get(i).getLevel() + "]");
			System.out.print(" [체력 : " + partyList.get(i).getHp());
			System.out.println(" / " + partyList.get(i).getMaxHp() + "]");
			System.out.print("[공격력 : " + partyList.get(i).getAtt() + "]");
			System.out.print(" [방어력 : " + partyList.get(i).getDef() + "]");
			System.out.println(" [파티중 : " + partyList.get(i).isParty() + "]");
			System.out.println("");
    	}
    	System.out.println("=====================================");
    }
    
    public void changeParty() {
    	boolean check =true;
    	printParty();
    	System.out.print("교체할 번호 입력: ");
    	int partyNum = scan.nextInt();
    	printAllguildList();
    	System.out.print("참가할 번호 입력: ");
    	int guildNum = scan.nextInt();
    	for(int i=0; i<partyList.size(); i++) {
    		if(partyList.get(i).getName().equals(guildList.get(guildNum-1).getName())) {
    			check =false;
    		}
    	}
    	if(check) {
    		guildList.get(guildNum-1).setParty(true);
    		guildList.get(partyNum-1).setParty(false);
//    	partyList.get(partyNum-1).setParty(false);
    		
    		partyList.remove(partyNum-1);
    		partyList.add(guildList.get(guildNum-1));
    		
    		System.out.println("====================================");
    		System.out.print("[이름 : " + guildList.get(partyNum - 1).getName() + "]");
    		System.out.print("에서 ");
    		System.out.print("[이름 : " + guildList.get(guildNum - 1).getName() + "]");
    		System.out.println("으로 교체 합니다. ");
    		System.out.println("====================================");
    		
    		try {
    			Thread.sleep(1000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    		
    	}
    	else {
    		System.out.println(guildList.get(guildNum-1).getName()+"님은 이미 파티에 속해있습니다.");
    	}
    }
    public void sortGuildList() {
    	for(int i=0; i<guildList.size(); i++) {
    		for(int j=i; j<guildList.size(); j++) {
    			if(guildList.get(i).getName().compareTo(guildList.get(j).getName())>0) {
    				Unit temp = guildList.get(i);
    				guildList.set(i, guildList.get(j));
    				guildList.set(j,temp);
    			}
    			
    		}
    	}
    }
    public void guildMenu() {
    	while(true) {
			System.out.println("=============== [길드관리] ================");
			System.out.println("[1.길드목록] [2.길드원추가] [3.길드원삭제]\n" + "[4.파티원목록] [5.파티원교체] [6.정렬]  [0.뒤로가기]");
			int sel = scan.nextInt();
			
			if(sel==1) printAllguildList();
			else if(sel==2) addUnit();
			else if(sel==3) removeUnit();
			else if(sel==4) printParty();
			else if(sel==5) changeParty();
			else if(sel==6) sortGuildList(); // 정렬 
			else if(sel==0) break;
			

    	}
    }
    public void printUnitStatus(int num){
    	guildList.get(num).printAfterItem();
    }
    public void printCheckItem(int num) {
    	guildList.get(num).printCheckItem();
    }
    
    


}
