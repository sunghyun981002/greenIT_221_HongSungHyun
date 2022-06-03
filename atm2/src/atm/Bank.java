package atm;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
	public static Bank instance = new Bank();
	
	private Scanner scan =new Scanner(System.in);
	private static String name;
	private int log = -1;
	public void log(int code) {
		this.log = code;
	}
	private Bank() {
		
	}
	public String getName() {
		return this.name;
	}
	public static void setName(String name) {
		
		System.out.println(name);
	}
	public void printUser() {
		for(int i=0; i<UserManager.instance.getCnt();i++) {
			System.out.print(UserManager.instance.toString(i)+" ");
		}
		System.out.println();
	}

	public void run() {
		//실행 로직
		while(true) {
			printLog();
			printMenu();
			selectMenu();
			
		}
	}
	private void printMenu() {
		System.out.println("1.로그인 2.회원가입 3.회원탈퇴 4.계좌생성 5.계좌철회 6.유저id확인");
	}
	private void selectMenu() {
		System.out.println("sel : ");
		int sel=scan.nextInt();
		if(sel==1) login();
		else if(sel==2) joinUser();
		else if(sel==3) dropoutUser();
		else if(sel==4) createAcc();
		else if(sel==5) {}
		else if(sel==6) printUser();
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
			System.out.println("가입실패");
	}
	private void dropoutUser() {
		System.out.print("[탈퇴]id : ");
		String id =scan.next();
		 UserManager.instance.removeUser(id);
	}
	private void login() {
		System.out.print("[로그인]id : ");
		String id =scan.next();
		System.out.print("[로그인]pw : ");
		String pw =scan.next();
		
		log = UserManager.instance.checkLog(new User(id,pw));
		if(log ==-1) {
			System.out.println("회원정보 확인 바람.");
		}
		else{
			System.out.println("로그인 완료");
			
		}
	}
	private void printLog() {
		if(log!=-1) {
			System.out.println("["+ log+"]님 로그인중" );
		}
		else {
			System.out.println("아직 로그인 전");
		}
	}
	private void createAcc() {
		// 로그 지금 이름받아오고있으니까 이름에 맞는 code번호 받아서 해야함		
		AccountManager.instance.addAcc(log);
				
		
	}
}
