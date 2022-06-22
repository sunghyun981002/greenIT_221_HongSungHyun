package game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Inventory {
	public static Inventory instance = new Inventory();
	ArrayList<Item> invenItemList = new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	private Inventory() {
		
	}
	
	public void addItem(Item item) {
		invenItemList.add(item);
	}
	
	public void invenMenu() {
		while(true) {
			System.out.println("============ [인벤메뉴] =============");
			System.out.println("[1.착용] [2.판매] [0.뒤로가기]");
			int sel = scan.nextInt();
			if(sel ==1) putOnItem();
			else if(sel ==2) sellInvenItem();
			else if(sel ==0)break;
			
		}
	}
	public void printIvenItemList() {
		System.out.println("============ [아이템 리스트] ============");
		for(int i=0; i<invenItemList.size(); i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print("[이름 : " + invenItemList.get(i).getName() + "]");
			System.out.print("[능력 : " + invenItemList.get(i).getPower() + "]");
			System.out.print("[가격 : " + invenItemList.get(i).getPrice() + "]");
			System.out.println("");
		}
	}
	
	public void putOnItem() {
		Guild.instace.printAllguildList();
		System.out.print("아이템을 착용할 길드원 선택 : ");
		int sel = scan.nextInt();
//		sel -=1;
		while(true) {
			Guild.instace.printUnitStatus(sel-1);
			Guild.instace.printCheckItem(sel-1);
			printIvenItemList();
			System.out.print("착용/사용할 아이템 번호를 입력하세요 [0. 종료]");
			int selEq = scan.nextInt();
			if(selEq==0)break;
			selEq -=1;
			if(invenItemList.get(selEq).getKind() == Item.WEAPON) {
				if(Player.instance.getGuildUnit(sel).getWeapon() !=null) {
					invenItemList.add(Player.instance.getGuildUnit(sel).getWeapon());
				}
				Player.instance.getGuildUnit(sel).setWeapon(invenItemList.get(selEq));
			}
			else if(invenItemList.get(selEq).getKind() == Item.ARMOR) {
				if(Player.instance.getGuildUnit(sel).getArmor() !=null) {
					invenItemList.add(Player.instance.getGuildUnit(sel).getArmor());
				}
				Player.instance.getGuildUnit(sel).setArmor(invenItemList.get(selEq));
			}
			else if(invenItemList.get(selEq).getKind() == Item.RING) {
				if(Player.instance.getGuildUnit(sel).getRing() !=null) {
					invenItemList.add(Player.instance.getGuildUnit(sel).getRing());
				}
				Player.instance.getGuildUnit(sel).setRing(invenItemList.get(selEq));
			}
			else if(invenItemList.get(selEq).getKind() == Item.POTION) {
				Guild.instace.guildList.get(sel).setPlusHp(invenItemList.get(selEq).getPower());
			}
			invenItemList.remove(selEq);
		}
	}
	public void sellInvenItem() {
		printIvenItemList();
		System.out.print("판매할 아이템 번호(세금 50%):  ");
		int sell = scan.nextInt();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Player.instance.money += (invenItemList.get(sell-1).getPrice()/2);
		invenItemList.remove(sell-1);
		System.out.println("판매완료 ! 잔액: "+Player.instance.money);
	}

}
