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
			System.out.println("1.����\n2.Ż��\n3.�α���\n4.�α׾ƿ�\n100.������\n0.����");
			System.out.print("�޴����� : ");
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
				System.out.println("1.�����ϱ�\n2.��ٱ��� ���\n0.�����ϱ� ");
				int sel =scan.nextInt();
			}			
			
		}
		
	}
	
}
