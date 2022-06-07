package shop1_1;

import java.util.Scanner;

public class Shop {

	public static Shop instance = new Shop();
	private Scanner scan = new Scanner(System.in);
	private int log = -1;
	UserManager um = UserManager.instance;
	
	private Shop(){
		
	}
	public void menu() {
		while(true) {
			System.out.println("1.가입\n2.탈퇴\n3.로그인\n4.로그아웃\n100.관리자\n0.종료");
			System.out.print("메뉴선택 : ");
			int sel=scan.nextInt();
			
			if(sel==1) um.joinUser();
			else if(sel==2) um.deleteUser();
			else if(sel==3) loginMenu();
			else if(sel==4) um.logoutUser();
			else if(sel==100) {}
			else if(sel==0) break;
			
		}
	}

	public void loginMenu() {
		if(um.loginUser()) {
			while(true) {
				System.out.println("1.쇼핑하기\n2.장바구니 목록\n0.종료하기 ");
				int sel =scan.nextInt();
			}			
			
		}
		
	}
	
}
