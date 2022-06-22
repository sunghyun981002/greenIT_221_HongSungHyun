package game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Guild {
	public static Guild instace = new Guild();
	ArrayList<Unit> guildList = new ArrayList<>();
	ArrayList<Unit> partyList = new ArrayList<>();
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);
	private String checkLogId;
	private int guildAllNum=-1;
	private int partyAllNum=-1;
	private int guildUserNum=0;
	private int partyUserNum=4;
	private Guild() {
		
	}
	public void checkLogId(String id) {
		checkLogId =id;
		
	}
	public void setGuild(String id) {
		Unit temp = new Unit(id,"성현",100,100,100,100,99);
		guildList.add(temp);
		temp = new Unit(id,"하늘",10,10,10,10,10);
		guildList.add(temp);
		temp = new Unit(id,"수지",3,50,10,30,1);
		guildList.add(temp);
		temp = new Unit(id,"태연",5,80,20,10,1);
		guildList.add(temp);
		temp = new Unit(id,"혜리",7,90,20,3,1);
		guildList.add(temp);
		temp = new Unit(id,"이현",17,80,30,30,2);
		guildList.add(temp);
		
		// party =True 부여 
		

		for(int j=guildList.size()-6; j<guildList.size()-2; j++) { //생성될떄마다 1~4번쨰 친구한테 부여(길드 사이즈 -6
			guildList.get(j).setParty(true);					
		}
			
		
		setPartyList();
	}
	public void partyTrue() {
		
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
		int n=0;
		guildUserNum=-1;
		guildAllNum=-1;
		for(int i=0; i<guildList.size(); i++) {
			if(guildList.get(i).getUserId().equals(checkLogId)) {
				guildUserNum++;
				guildAllNum = i;
				System.out.print("[" + (n + 1) + "번]");
				System.out.print(" [이름 : " + guildList.get(i).getName() + "]");
				System.out.print(" [레벨 : " + guildList.get(i).getLevel() + "]");
				System.out.print(" [체력 : " + guildList.get(i).getHp());
				System.out.println(" / " + guildList.get(i).getMaxHp() + "]");
				System.out.print("[공격력 : " + guildList.get(i).getAtt() + "]");
				System.out.print(" [방어력 : " + guildList.get(i).getDef() + "]");
				System.out.println(" [파티중 : " + guildList.get(i).isParty() + "]");
				System.out.println("");		
				n++;
					
			}
			
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
		Unit temp = new Unit(checkLogId,name,1,hp,att,def,0);
		
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
    	System.out.println(guildAllNum);
    	System.out.println(guildUserNum);
    	int sel = scan.nextInt()+((guildAllNum-1)-guildUserNum);
    	
    		if(guildList.get(sel).getUserId().equals(checkLogId)) {
    			if(guildList.get(sel).isParty()) {
    				System.out.println("파티중인 멤버는 삭제 불가.");
    			}
    			else {
    				guildList.remove(sel);
    				System.out.println("삭제 완료.");
    			}
    			try {
    				Thread.sleep(1000);
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			} 		
    			
    		}
    		
    	
  
    

    	
    }
    public void printParty() {
    	System.out.println("============= [파티원] =================");
    	int n=0; 
    	for(int i=0; i<partyList.size(); i++) {
    		partyAllNum =-1;
    		if(partyList.get(i).getUserId().equals(checkLogId)) {
    			
    			partyAllNum =i;
    			System.out.print("[" + (n + 1) + "번]");
    			System.out.print(" [이름 : " + partyList.get(i).getName() + "]");
    			System.out.print(" [레벨 : " + partyList.get(i).getLevel() + "]");
    			System.out.print(" [체력 : " + partyList.get(i).getHp());
    			System.out.println(" / " + partyList.get(i).getMaxHp() + "]");
    			System.out.print("[공격력 : " + partyList.get(i).getAtt() + "]");
    			System.out.print(" [방어력 : " + partyList.get(i).getDef() + "]");
    			System.out.println(" [파티중 : " + partyList.get(i).isParty() + "]");
    			System.out.println("");
    			n++;
    			
    		}
    	}
    	System.out.println("=====================================");
    }
//    public void serchGuildPeople(int idx) {
//    	for(int i=0; i<guildList.size(); i ++) {
//    		if(guildList.get(i).getUserId().equals(checkLogId)) {
//    			
//    		}
//    	}
//    }
    
    public void changeParty() {
    	boolean check =true;
    	printParty();
    	System.out.print("교체할 번호 입력: ");
    	System.out.println(partyAllNum);
    	System.out.println(partyUserNum);
    	int partyNum = scan.nextInt()+((partyAllNum)-partyUserNum);
    	printAllguildList();
    	System.out.print("참가할 번호 입력: ");
    	int guildNum = scan.nextInt()+((guildAllNum)-guildUserNum);

    	
    		guildList.get(guildNum-1).setParty(true);
    		guildList.get(partyNum).setParty(false);
//    	partyList.get(partyNum-1).setParty(false);
    		
    		partyList.remove(partyNum);
    		partyList.add(guildList.get(guildNum-1));
    		
    		System.out.println("====================================");
    		System.out.print("[이름 : " + guildList.get(partyNum).getName() + "]");
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


    public void guildMenu() {
    	while(true) {
			System.out.println("=============== [길드관리] ================");
			System.out.println("[1.길드목록] [2.길드원추가] [3.길드원삭제]\n" + "[4.파티원목록] [5.파티원교체] [0.뒤로가기]");
			int sel = scan.nextInt();
			
			if(sel==1) printAllguildList();
			else if(sel==2) addUnit();
			else if(sel==3) removeUnit();
			else if(sel==4) printParty();
			else if(sel==5) changeParty();

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
