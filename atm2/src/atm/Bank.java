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
		System.out.println("1.로그인 2.회원가입 3.회원탈퇴 4.계좌생성 5.계좌철회 6.유저id확인 7.로그아웃");
	}
	private void selectMenu() {
		System.out.println("sel : ");
		int sel=scan.nextInt();
		if(sel==1) login();
		else if(sel==2) joinUser();
		else if(sel==3) dropoutUser();
		else if(sel==4 && log!= -1) createAcc();
		else if(sel==5&&log!= -1) deleteAcc();
		else if(sel==6) printUser();
		else if(sel ==7) log = -1;
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
		boolean success = AccountManager.instance.addAcc(log);
		if(success) 
			System.out.println("계좌생성 성공");
		else
			System.out.println("계좌생성 실패(이유 3개 이상임)");
	}
	private void deleteAcc() {
		//보유 계좌부터 출력 
		UserManager.instance.printAllUsersAccList(log);
		System.out.print("철회 대상 번호 : ");
		int delIdx = scan.nextInt()-1;
		
		boolean result = AccountManager.instance.deleteAcc(log, delIdx);
		if(result) {
			System.out.println("계좌철회 완료");
		}
		else
			System.out.println("계좌철회 실패");
		
	}
}
