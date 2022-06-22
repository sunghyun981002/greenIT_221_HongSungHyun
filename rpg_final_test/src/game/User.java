package game;

import java.util.ArrayList;

public class User {
	private String id,pw;
	ArrayList<Unit> guildList;
	ArrayList<Unit> partyList; 
	
	User(String id , String pw){
		this.id= id;
		this.pw = pw;
		guildList =Guild.instace.guildList;
		partyList = Guild.instace.partyList;
	}

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

	public ArrayList<Unit> getGuildList() {
		return guildList;
	}

	public void setGuildList(ArrayList<Unit> guildList) {
		this.guildList = guildList;
	}

	public ArrayList<Unit> getPartyList() {
		return partyList;
	}

	public void setPartyList(ArrayList<Unit> partyList) {
		this.partyList = partyList;
	}

}
