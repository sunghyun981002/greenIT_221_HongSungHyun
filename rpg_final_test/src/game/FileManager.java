package game;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class FileManager{
	public static FileManager instance = new FileManager();
	
	String fileName = "rpgGame.txt";
	
	public void saveUserData() {
		Guild guild = Guild.instace;
		PlayerManager pm = PlayerManager.instance;
		Inventory inven = Inventory.instance;
		ArrayList<Player> pl  = pm.playerList;
		ArrayList<Unit> gl = guild.guildList; 
		ArrayList<Unit> party = guild.partyList;
		
		if(gl.size() ==0) return;
		
		String data = "";
		
		
		
		for(int i=0; i<pl.size(); i++) {
			data += pl.get(i).getId(); data+="/";
			data += pl.get(i).getPw(); data+="/";
			data += pl.get(i).getMoney(); 
			
			// id/pw/guildlist(id)/partylist(id)/inven(id)   
			for(int j=0; j<gl.size(); j++) {
				if(gl.get(j).getUserId().equals(pl.get(i).getId())) {
					data += "/";
					data +=gl.get(j).getUserId(); data += "/";
					data +=gl.get(j).getName(); data += "/";
					data +=gl.get(j).getLevel(); data += "/";
					data +=gl.get(j).getHp(); data += "/";
					data +=gl.get(j).getMaxHp(); data += "/";
					data +=gl.get(j).getAtt(); data += "/";
					data +=gl.get(j).getDef(); data += "/";
					data +=gl.get(j).getExp(); data += "/";
					data +=gl.get(j).isParty(); data += "/";
					data +=gl.get(j).getWeapon(); data += "/";
					data +=gl.get(j).getArmor(); data += "/";
					data +=gl.get(j).getRing(); data += "/";
						
				}
					
			}
			for(int j=0; j<party.size(); j++) {
				if(party.get(j).getUserId().equals(pl.get(i).getId())&&party.get(j).isParty() ==true) {
					data +=gl.get(j).getUserId(); data += "/";
					data +=gl.get(j).getName(); data += "/";
					data +=gl.get(j).getLevel(); data += "/";
					data +=gl.get(j).getHp(); data += "/";
					data +=gl.get(j).getMaxHp(); data += "/";
					data +=gl.get(j).getAtt(); data += "/";
					data +=gl.get(j).getDef(); data += "/";
					data +=gl.get(j).getExp(); data += "/";
					data +=gl.get(j).isParty(); data += "/";
					data +=gl.get(j).getWeapon(); data += "/";
					data +=gl.get(j).getArmor(); data += "/";
					data +=gl.get(j).getRing(); 
				}
				
			}
			if(inven.inventory.size() >0) {
				for(int j =0; j<inven.inventory.size(); j++) {
					if(inven.inventory.get(j).getUserId().endsWith(pl.get(i).getId())) {
						data+="/";
						data +=inven.inventory.get(j).getUserId(); data+="/";
						data +=inven.inventory.get(j).getKind(); data+="/";
						data +=inven.inventory.get(j).getName(); data+="/";
						data +=inven.inventory.get(j).getPower(); data+="/";
						data +=inven.inventory.get(j).getPrice(); 
					}
				}
			}
			if(i!= pl.size() -1) {
				data +="\n";
			}
			
		}
		FileWriter fw =null;
		try {
			fw = new FileWriter(fileName);
			fw.write(data);
			
			System.out.println("파일저장완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fw != null) {try {fw.close();} catch (IOException e) {}}
		}
		
		
		
	}

}
