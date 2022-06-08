package shop1_1;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemManager {
	public static ItemManager instance = new ItemManager();

	Scanner scan = new Scanner(System.in);
	ArrayList<Item> itemList = new ArrayList<Item>();
	ArrayList<String> category = new ArrayList<String>();
	ArrayList<Cart> cartList = new ArrayList<Cart>();
	private int cnt = 0;
	private ItemManager(){
		init();
	}
	
	public void init() {
		category.add("과자");
		category.add("음료수");
		category.add("어류");
		category.add("육류");
		
		Item it = new Item("허니터버칩",3000,category.get(0));
		itemList.add(it);
		it = new Item("홈런볼",2000,category.get(0));
		itemList.add(it);
		it = new Item("빼빼로",1000,category.get(0));
		itemList.add(it);
		it = new Item("제로콜라",1500,category.get(1));
		itemList.add(it);
		it = new Item("스프라이트",1500,category.get(1));
		itemList.add(it);
		it = new Item("에비앙",1500,category.get(1));
		itemList.add(it);
		it = new Item("[한우]채끝살",30000,category.get(3));
		itemList.add(it);
		it = new Item("[한우]부채살",25000,category.get(3));
		itemList.add(it);
		it = new Item("[한우]새우살",29000,category.get(3));
		itemList.add(it);
		it = new Item("무늬 오징어",20000,category.get(2));
		itemList.add(it);
		it = new Item("고등어",6000,category.get(2));
		itemList.add(it);
		it = new Item("참치",12000,category.get(2));
		itemList.add(it);
	}
	public void printCate() { // 카테고리 보여주기 
		for(int i=0; i<category.size(); i++) {
			System.out.println("["+i+"] "+category.get(i));
		}
	}
	public void printItemList(int cateIdx) { // 구매과정에서 보여지는 아이템 리스트
		int n=0;
		for(int i=0; i<itemList.size(); i++) {
			if(category.get(cateIdx).equals(itemList.get(i).getCategory())) {
				System.out.print("["+n+"]");
				itemList.get(i).print();
				n++;
			}
		}
		cnt =n;
		
	}
	public int getCnt() {
		return cnt;
	}
	public void printItemList() { // 아이템 관리 과정에서 보여지는 아이템 리스트 
		for(int i=0; i<itemList.size(); i++) {
			System.out.print("["+i+"]"); 
			itemList.get(i).print();
		}
	}
	public void printCart(User u) {
		for(int i=0; i<cartList.size(); i++) {
			if(u.getId().equals(cartList.get(i).getUserId())){
				cartList.get(i).print();
			}
		}
	}
	public void clearCart(User u) {
		for(int i=0; i<cartList.size(); i++) {
			if(u.getId().equals(cartList.get(i).getUserId())){
				cartList.remove(i);
			}
		}
	}
	public int buyCart(User u) {
		int payMoney =0;
		for(int i=0; i<cartList.size(); i++) {
			if(u.getId().equals(cartList.get(i).getUserId())){
				for(int j=0; j<itemList.size(); j++) {
					if(cartList.get(i).getItemName().equals(itemList.get(j).getName())) {
						payMoney += itemList.get(j).getPrice();
					}
					
				}
			}
			
		}
		return payMoney;
		
	}
	public void addCart(String id, int cateIdx, int itemId) {
		int n=0;
		Cart ct = new Cart();
		ct.setUserId(id);
		
		for(int i =0; i<itemList.size(); i++) {
			if(category.get(cateIdx).equals(itemList.get(i).getCategory())) {
				if(itemId ==n) {
					ct.setItemName(itemList.get(i).getName());					
				}
				n++;
			}
		}
		cartList.add(ct);
	}
	public void administrateItem() {
		printItemList(); // 일단 아이템리스트 보여주고 
		System.out.println("[아이템 관리] 1.추가하기 2.삭제하기");
		System.out.print("선택 : ");
		int sel =scan.nextInt();
		
		if(sel ==1) {
			System.out.print("[아이템 추가]제품명 : ");
			String name = scan.next();
			System.out.print("[아이템 추가]제품가격 :");
			int price =scan.nextInt();
			printCate();
			System.out.print("[아이템 추가]카테고리 선택:");
			int cateNum =scan.nextInt();
			
			Item it = new Item(name,price,category.get(cateNum));
			itemList.add(it);
			System.out.println("[아이템 추가]추가 완료!");
		}
		else if(sel ==2) {
			System.out.print("[아이템 삭제]삭제할 번호: ");
			int delNum = scan.nextInt();
			itemList.remove(delNum);
			System.out.println("[아이템 삭제]삭제 완료!: ");
		}
	}
	public void administrateCate() {
		printCate();
		System.out.println("[카테고리 관리] 1.추가하기 2.삭제하기");
		System.out.print("선택 : ");
		int sel =scan.nextInt();
		if(sel ==1) {
			System.out.print("[카테고리 추가]카테고리명 : ");
			String cateName=scan.next();
			category.add(cateName);
			System.out.println("[카테고리 추가]추가 완료!");
		}
		else if(sel==2) {
			System.out.print("[카테고리 삭제]카테고리명 : ");
			String delcateName=scan.next();
			System.out.println("[카테고리 삭제]카테고리를 삭제하시면 해당 제품들도 삭제 됩니다. 진행하시겠습니까 ? y/n");
			System.out.print("선택 : ");
			String ans = scan.next();
			
			if(ans.equals("y")) {
				for(int i=0; i<itemList.size(); i++) {
					if(itemList.get(i).getName().equals(delcateName)) {
						itemList.remove(i);
					}
				}
				for(int i=0; i<category.size(); i++) {
					if(category.get(i).equals(delcateName)) {
						category.remove(i);
					}
				}
				System.out.println("[카테고리 삭제]삭제 완료!");
				
			}
			else {
				System.out.println("[카테고리 삭제]취소하셨습니다.");
			}
		}
		
	}
	
}
