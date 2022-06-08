package shop1_2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class FileManager {

	public static FileManager instance = new FileManager();
	
	String fileName1="shopData.txt";
	String fileName2 ="itemListData.txt";
	
	public void saveData() {
		UserManager userManager = UserManager.instance;
		ItemManager itemManager =ItemManager.instance;  
		ArrayList<User> um = userManager.userList;
		ArrayList<Cart> cl = itemManager.cartList;
		if(um.size() ==0) return;
		
		String data="";
		data +=um.size();
		data += "\n";
		
		for(int i=0; i<um.size(); i++) {
			data += um.get(i).getId(); data+="/";
			data += um.get(i).getMoney(); 
			
			if(cl.size()>0) {
				data +="/";
				for(int j=0; j<cl.size(); j++) {
					if(um.get(i).getId().equals(cl.get(j).getUserId())) {
						data += cl.get(j).getItemName();
						if(j!=cl.size()-1 ) {
							data +="/";
						}
					}					
				}

			}
			if(i!=um.size()-1) {
				data += "\n";
			}
			
		}
		FileWriter fw =null;
		try {
			fw = new FileWriter(fileName1);
			fw.write(data);
			System.out.println("파일저장완료");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fw != null) {try {fw.close();} catch (IOException e) {}}
		}
		
	}
	public void saveItemList() {
		ItemManager itemManager =ItemManager.instance; 
		ArrayList<String> Ic = itemManager.category;
		ArrayList<Item> Iil =itemManager.itemList;
		if(Ic.size()==0)return;
		
		String data="";
		data +=Ic.size();
		data += "\n";
		
		for(int i=0; i<Ic.size(); i++) {
			data+=Ic.get(i); 
		}
		
	}
}
