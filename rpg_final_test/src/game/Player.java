package game;

import java.util.ArrayList;


public class Player {
	public static Player instance = new Player();
	public int money;
	public String UserId;
	
    private Player(){
		
	}
	
	//Guild 
	public void guildMenu() {
		Guild.instace.guildMenu();
	}
	
	public ArrayList<Unit> getGuildList(){
		return Guild.instace.guildList;
	}
	public ArrayList<Item> getItemList() {
		return Inventory.instance.invenItemList;
	}

	public int getItemSize() {
		return Inventory.instance.invenItemList.size();
	}

	public Unit getGuildUnit(int num) {
		return Guild.instace.getGuildUnit(num);
	}
}
