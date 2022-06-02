package atm;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
	public static Bank instance = new Bank();
	private Scanner scan =new Scanner(System.in);
	ArrayList<User> us = new ArrayList<>();
	private int cnt=1;
	private Bank() {
		
	}
	//1. 회원가입/ 탈퇴
	public void makeId() {
		//아이디 만들기 
		System.out.print("[가입]id : ");
		String id =scan.next();
		System.out.print("[가입]pw : ");
		String pw =scan.next();
		System.out.print("[가입]name : ");
		String name =scan.next();
		
		User user = new User(cnt,id,pw,name);
		us.add(user);
		

	}
	public void run() {
		//실행 로직
	}
}
