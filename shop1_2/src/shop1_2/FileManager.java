package shop1_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class FileManager {

	public static FileManager instance = new FileManager();
	
	String fileName1="shopData.txt";
	String fileName2 ="itemListData.txt";
	
	public void saveUserData() {
		UserManager userManager = UserManager.instance;
		ItemManager itemManager =ItemManager.instance;  
		ArrayList<User> um = userManager.userList;
		ArrayList<Cart> cl = itemManager.cartList;
		if(um.size() ==0) return;
		
		String data="";

		
		for(int i=0; i<um.size(); i++) {
			data += um.get(i).getId(); data+="/";
			data += um.get(i).getMoney(); 
			
			if(cl.size()>0) {
				for(int j=0; j<cl.size(); j++) {
					if(um.get(i).getId().equals(cl.get(j).getUserId())) {
						data +="/";
						data += cl.get(j).getItemName();
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
			System.out.println("UserList/CartList파일저장완료");

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fw != null) {try {fw.close();} catch (IOException e) {}}
		}
		
	}
	public void saveItemList() {
		ItemManager itemManager =ItemManager.instance; 
		ArrayList<String> Ic = itemManager.category;
		ArrayList<Item> Il =itemManager.itemList;
		if(Ic.size()==0)return;
		
		String data="";

		
		for(int i=0; i<Ic.size(); i++) {
			data+=Ic.get(i);
			
			if(Il.size()>0) {
				for(int j=0; j<Il.size(); j++) {
					if(Ic.get(i).equals(Il.get(j).getCategory())) {
						data +="/";
						data +=Il.get(j).getName(); 
						data +="/";
						data +=Il.get(j).getPrice();
						

						
					}
				}
			}
			if(i!= Ic.size() -1) {
				data += "\n";
			}
		}
		FileWriter fw =null;
		try {
			fw = new FileWriter(fileName2);
			fw.write(data);
			System.out.println("Category/itemList파일저장완료");

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fw != null) {try {fw.close();} catch (IOException e) {}}
		}
		
	}
	public void loadUserData() {
		UserManager userManager = UserManager.instance;
		ItemManager itemManager =ItemManager.instance;
		ArrayList<User> um = userManager.userList;
		ArrayList<Cart> cl = itemManager.cartList;
		
		File file = new File(fileName1);
		FileReader fr = null;
		BufferedReader br = null;
		
		um.clear();
		cl.clear();
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			while(true) {
				String line = br.readLine();
				if(line == null) break;
				
				User user = new User(line.split("/")[0],Integer.parseInt(line.split("/")[1]));
				//us==new user(0,1)해서
				um.add(user);
				for(int i=2; i<line.split("/").length; i++) {
					Cart cart = new Cart(line.split("/")[0],line.split("/")[i]);
					cl.add(cart);
				}
				
				
			}
			System.out.println("Userdata 로드 성공!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fr != null) {try {fr.close();} catch (IOException e) {}}
			if(br != null) {try {br.close();} catch (IOException e) {}}
		}
	}
	public void loadItemListData() {
		ItemManager itemManager =ItemManager.instance; 
		ArrayList<String> Ic = itemManager.category;
		ArrayList<Item> Il =itemManager.itemList;
		if(Ic.size()==0)return;
		
		File file = new File(fileName2);
		FileReader fr = null;
		BufferedReader br = null;
		
		Ic.clear();
		Il.clear();
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			while(true) {
				String line = br.readLine();
				if(line == null) break;
				
				itemManager.category.add(line.split("/")[0]);
				
				for(int i=1; i<line.split("/").length-1; i+=2) {
					Item it = new Item(line.split("/")[i],Integer.parseInt(line.split("/")[i+1]),line.split("/")[0]);
					Il.add(it);
				}
			}
			System.out.println("itemList로드 성공!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fr != null) {try {fr.close();} catch (IOException e) {}}
			if(br != null) {try {br.close();} catch (IOException e) {}}
		}
		
	}
}
