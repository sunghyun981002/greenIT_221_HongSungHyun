package game;

import java.util.ArrayList;


public class Player {

	private int money;
	
    private String id,pw;
    
//    private ArrayList<Item> inventory = new ArrayList<>(); 
 
	
	Player(String id , String pw){
		this.id= id;
		this.pw = pw;
		money =100000;

	}

//	public ArrayList<Item> getInventory() {
//		return inventory;
//	}
//
//	public void setInventory(Item item) {
//		this.inventory.add(item);
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	//Guild 
	public void guildMenu() {
		Guild.instace.guildMenu();
	}
	
	public ArrayList<Unit> getGuildList(){
		return Guild.instace.guildList;
	}
	

	public Unit getGuildUnit(int num) {
		return Guild.instace.getGuildUnit(num);
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
}
