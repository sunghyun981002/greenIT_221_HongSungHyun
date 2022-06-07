package shop1_1;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemManager {
	public static ItemManager instance = new ItemManager();

	Scanner scan = new Scanner(System.in);
	ArrayList<Item> itemList = new ArrayList<Item>();
	ArrayList<String> category = new ArrayList<String>();
	ArrayList<Cart> cartList = new ArrayList<Cart>();
	
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
	public void printCate() {
		for(int i=0; i<category.size(); i++) {
			System.out.println("["+i+"] "+category.get(i));
		}
	}
	public void printItemList(int cateIdx) {
		int n=0;
		for(int i=0; i<itemList.size(); i++) {
			if(category.get(cateIdx).equals(itemList.get(i).getCategory())) {
				System.out.print("["+n+"]");
				itemList.get(i).print();
				n++;
			}
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
	
}
