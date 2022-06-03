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
			
		}
	}
	public void menu() {
		while(true) {			
			System.out.println("[Green Bank]\n1.로그인 \n2.회원가입 \n3.회원탈퇴 \n4.종료");
			
			System.out.println("메뉴선택 : ");
			int sel=scan.nextInt();
			if(sel==1) login();
			else if(sel==2) joinUser();
			else if(sel==3) dropoutUser();
			else if(sel ==4) {
				System.out.println("[메세지]프로그램 종료");
				break;
			}
		}
	}
	private void loginMenu() {
		while(true) {
			System.out.println("["+UserManager.instance.getName(log)+"님, 로그인 ]");
			UserManager.instance.printAllUsersAccList(log);
			System.out.println("1.계좌생성\n2.입금하기\n3.출금하기\n4.이체하기\n5.계좌조회\n6.계좌삭제\n7.회원탈퇴\n0.삭제");
			System.out.print("메뉴선택 : ");
			int choice = scan.nextInt();
			if(choice==1) createAcc();
			else if(choice ==2) {}
			else if(choice ==3) {}
			else if(choice ==4) {}
			else if(choice ==5) {}
			else if(choice ==6) deleteAcc();
			else if(choice ==7) {}
			else if(choice ==0) {
				log = -1;
				System.out.println("[메세지] 로그아웃 완료");
			}
		}
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
		if(success) {
			System.out.println("가입완료");
		}
		
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
			System.out.println("[메세지]회원정보 확인 바람.");
		}
		else{
			System.out.println("[메세지]"+UserManager.instance.getName(log) + "님 반갑습니다.");
			
			loginMenu();
			
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
		if(success) { 
			System.out.println("계좌생성 성공 , 1000원 지금");
			
		}
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
