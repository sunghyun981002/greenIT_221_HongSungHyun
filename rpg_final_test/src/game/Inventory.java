package game;

import java.util.ArrayList;

public class Inventory { // player마다 가지고 있다. (상점에서 산 아이템 가지고 있음 (착용,섭취 할 수 있어야함))
	public static Inventory instance= new Inventory();
	
	ArrayList<Item> inventory = new ArrayList<>();

	
	private Inventory(){
		
	}
	// 상점에서 산 거 아이템 리스트에 넣기
	public void addInvenItem(Item item) {
		inventory.add(item);
	}
	public void invenMenu(String PlayerLog) {
		while(true) {
			printInvenList(PlayerLog);
			System.out.println("============ [인벤메뉴] =============");
			System.out.println("[1.착용] [2.해제] [0.뒤로가기]");
			int sel = Guild.instace.scan.nextInt();
			if(sel ==1) putOnItem(PlayerLog);
			else if(sel ==2)takeOffItem(PlayerLog);
			else if(sel ==0)break;
		}
	}
	public void printInvenList(String PlayerLog) {
		int cnt =0;
		System.out.println("============ [아이템 리스트] ============");
		for(int i=0; i<inventory.size(); i++) {
			if(inventory.get(i).getUserId() != PlayerLog)continue;
			System.out.print("[" + (cnt + 1) + "번]");
			System.out.print("[이름 : " + inventory.get(i).getName() + "]");
			System.out.print("[능력 : " + inventory.get(i).getPower() + "]");
			System.out.print("[가격 : " + inventory.get(i).getPrice() + "]");
			System.out.println();
			cnt++;
		}
	}
	public void putOnItem(String PlayerLog) {
		Guild.instace.printAllguildList();
		System.out.print("아이템을 착용할 길드원 선택 : ");
		int sel =Guild.instace.scan.nextInt()+((Guild.instace.getGuildAllNum()-1)-Guild.instace.getGuildUserNum());
		while(true) {
			Guild.instace.printUnitStatus(sel);
			Guild.instace.printCheckItem(sel);
			printInvenList(PlayerLog);
			System.out.print("착용할 아이템 번호를 입력하세요 [0.종료]");
			int selEq = Guild.instace.scan.nextInt();
			if(selEq ==0)break;
			int cnt =0 ; 
			Player pl=PlayerManager.instance.playerList.get(PlayerManager.instance.playerLog()); // 현재로그인중인 플레이어 
			for(int i=0; i<inventory.size(); i++) {
				if(inventory.get(i).getUserId().equals(PlayerLog)) {
					cnt++;
					if(cnt==selEq) {
						if(inventory.get(i).getKind() == Item.WEAPON) {
							if(pl.getGuildUnit(sel).getWeapon() !=null) {
								System.out.println("이미 아이템이 착용되어있습니다.");
							}
							else {
								pl.getGuildUnit(sel).setWeapon(inventory.get(i));
								pl.getGuildUnit(sel).setAtt(inventory.get(i).getPower());
								System.out.println("착용완료!");
								inventory.remove(i);
								
							}
							
							
						}
						else if(inventory.get(i).getKind() == Item.ARMOR) {
							if(pl.getGuildUnit(sel).getArmor() !=null) {
								System.out.println("이미 아이템이 착용되어있습니다.");
							}
							else {
								pl.getGuildUnit(sel).setArmor(inventory.get(i));
								System.out.println("착용완료!");		
								inventory.remove(i);
							}
							
						}
						else if(inventory.get(i).getKind() == Item.RING) {
							if(pl.getGuildUnit(sel).getRing() !=null) {
								System.out.println("이미 아이템이 착용되어있습니다.");
								inventory.add(pl.getGuildUnit(sel).getRing());
							}
							else {
								pl.getGuildUnit(sel).setRing(inventory.get(i));
								pl.getGuildUnit(sel).setPlusHp(inventory.get(i).getPower());
								pl.getGuildUnit(sel).setMaxHp(inventory.get(i).getPower());
								System.out.println("착용완료!");	
								inventory.remove(i);
							}
							
						}
						
					}
				}
			}
		}
	}
	public void takeOffItem(String PlayerLog) {
		Guild.instace.printAllguildList();
		System.out.print("아이템을 해체할 길드원 선택 : ");
		int sel =Guild.instace.scan.nextInt()+((Guild.instace.getGuildAllNum()-1)-Guild.instace.getGuildUserNum());
		while(true) {
			Guild.instace.printTakeOffItemUnitStatus(sel);
			Guild.instace.printCheckItem(sel);
			System.out.print("해제할 아이템 종류를 입력하세요 [1.웨폰 2.아머 3.링 0.종료]");
			int takeOffsel = Guild.instace.scan.nextInt();
			if(takeOffsel == 0)return;
			Player pl=PlayerManager.instance.playerList.get(PlayerManager.instance.playerLog()); // 현재로그인중인 플레이어 

			if(takeOffsel ==Item.WEAPON ) {
				if(pl.getGuildUnit(sel).getWeapon() !=null) {
					inventory.add(pl.getGuildUnit(sel).getWeapon());
					pl.getGuildUnit(sel).setminuseAtt(pl.getGuildUnit(sel).getWeapon().getPower());
					pl.getGuildUnit(sel).setWeapon(null);
				}
				else {
					System.out.println("착용된 아이템이 없습니다.");
				}
			}
			else if(takeOffsel == Item.ARMOR) {
				if(pl.getGuildUnit(sel).getArmor() !=null) {
					inventory.add(pl.getGuildUnit(sel).getArmor());
					pl.getGuildUnit(sel).setminuseAtt(pl.getGuildUnit(sel).getArmor().getPower());
					pl.getGuildUnit(sel).setArmor(null);
				}
				else {
					System.out.println("착용된 아이템이 없습니다.");
				}
				
			}
			else if(takeOffsel == Item.RING) {
				if(pl.getGuildUnit(sel).getRing() !=null) {
					inventory.add(pl.getGuildUnit(sel).getRing());
					pl.getGuildUnit(sel).setminuseAtt(pl.getGuildUnit(sel).getRing().getPower());
					pl.getGuildUnit(sel).setRing(null);
				}
				else {
					System.out.println("착용된 아이템이 없습니다.");
				}
			}
		}
	}

	
	
}
