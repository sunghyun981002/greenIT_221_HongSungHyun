package rpg;

import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;
public class Shop {
	public static Shop instance = new Shop();
	
	ArrayList<Item> itemList = new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	
	
	private Shop() {
		//weapon
		Item temp = new Item(Item.WEAPON,"나무검",2,1000);
		itemList.add(temp);
		temp = new Item(Item.WEAPON,"철검",6,2000);
		itemList.add(temp);
		temp = new Item(Item.WEAPON,"티타늄검",8,3000);
		itemList.add(temp);
		
		// armor
		temp = new Item(Item.ARMOR,"1렙조끼",1,1000);
		itemList.add(temp);
		temp = new Item(Item.ARMOR,"2렙조끼",5,2000);
		itemList.add(temp);
		temp = new Item(Item.ARMOR,"3렙조끼",8,3000);
		itemList.add(temp);
		
		//ring
		temp = new Item(Item.RING,"은반지",7,4000);
		itemList.add(temp);
		temp = new Item(Item.RING,"금반지",15,10000);
		itemList.add(temp);
		temp = new Item(Item.RING,"다이아반지",34,21000);
		itemList.add(temp);
		
		
		//potion
		temp = new Item(Item.POTION,"초급포션",5,1000);
		itemList.add(temp);
		temp = new Item(Item.POTION,"중급포션",10,2000);
		itemList.add(temp);
		temp = new Item(Item.POTION,"고급포션",20,2500);
		itemList.add(temp);
			
		
	}
	public void shopMenu(){
		while(true) {
			System.out.println("=================== [상점] ===================");
			System.out.println("[1.무기] [2.갑옷] [3.반지] [4.포션] [0.뒤로가기]");
			int sel =scan.nextInt(); 
			if(sel ==0)return;
			while(true) {
				if(sel==Item.WEAPON) 
					System.out.println("=========== [무기] ============");
				else if(sel==Item.ARMOR)
					System.out.println("=========== [방어구] ============");
				else if(sel ==Item.RING)
					System.out.println("=========== [반지] ============");
				else if(sel ==Item.POTION)
					System.out.println("=========== [포션] ============");
				
				printItems(sel);
				System.out.println("[보유 골드 : "+ Player.instance.money +"]");
				System.out.println("구입할 아이템 번호를 입력하세요 [0.뒤로가기]");
				int selNum =scan.nextInt();
				if (selNum ==0)break;
				int cnt =0;
				for(int i=0; i<itemList.size(); i++) {
					if(itemList.get(i).getKind() ==sel) {
						cnt+=1;
						if(cnt ==selNum) {
						    Inventory.instance.addItem(itemList.get(i));
							Player.instance.money -=itemList.get(i).getPrice();
							System.out.println("[" + itemList.get(i).getName() + "] 을 구입했습니다.");
							try {
								Thread.sleep(1000);
							} catch (Exception e) {
								e.printStackTrace();
							}
							break;
						}
					}
				}
				
				
			}
		}
	}
	public void printItems(int kind) {
		int cnt = 0;
		for(int i =0; i<itemList.size(); i++) {
			if(itemList.get(i).getKind() != kind)continue; // 같은 카인드 일때만 띄워주기위해 
			System.out.print("[" + (cnt + 1) + "번]");
			System.out.print("[이름 : " + itemList.get(i).getName() + "]");
			System.out.print("[능력 : " + itemList.get(i).getPower() + "]");
			System.out.print("[가격 : " + itemList.get(i).getPrice() + "]");
			System.out.println("");
			cnt += 1;
		}
	}
}
