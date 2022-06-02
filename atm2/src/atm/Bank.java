package atm;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
	public static Bank instance = new Bank();
	
	private Scanner scan =new Scanner(System.in);
	ArrayList<User> us = new ArrayList<>();
	private static String name;
	private Bank() {
		
	}
	public String getName() {
		return this.name;
	}
	public static void setName(String name) {
		
		System.out.println(name);
	}
	//1. 회원가입/ 탈퇴

	public void run() {
		//실행 로직
		while(true) {
			printMenu();
			selectMenu();
			
		}
	}
	private void printMenu() {
		System.out.println("1.로그인 2.회원가입 3.회원탈퇴 4.계좌생성 5.계좌철회");
	}
	private void selectMenu() {
		System.out.println("sel : ");
		int sel=scan.nextInt();
		if(sel==1) {}
		else if(sel==2) joinUser();
		else if(sel==3) {}
		else if(sel==4) {}
		else if(sel==5) {}
	}
	private void joinUser() {
		//아이디 만들기 
		System.out.print("[가입]id : ");
		String id =scan.next();
		System.out.print("[가입]pw : ");
		String pw =scan.next();
		System.out.print("[가입]name : ");
		String name =scan.next();
		
		User user = new User(id,pw,name);
		
		boolean success = UserManager.instance.addUser(user);
		if(success)
			System.out.println("가입완료");
		else
			System.out.println();
	}
}
