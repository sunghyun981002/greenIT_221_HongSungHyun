package shop1_1;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {
	ArrayList<User> userList = new ArrayList<User>();
	public static UserManager instance = new UserManager();
	Scanner scan = new Scanner(System.in);
	
	private int userLog = -1;
	
	public void joinUser() {
		int check = -1;
		System.out.print("[ȸ������] id�� �Է��ϼ��� : ");
		String id = scan.next();
		for(int i=0; i<userList.size(); i++) {
			if(userList.get(i).getId().equals(id)) {
				check =1;
			}
			
		}
		if(check ==-1) {
			User us = new User(id,0);
			userList.add(us);
			System.out.println("[ȸ������] ���Լ���! ");			
		}
		else {
			System.out.println("[ȸ������] �̹� �����ϴ� ���̵��Դϴ�.");
		}
		
	}
	public void deleteUser() {
		int delIdx = -1;
		System.out.print("[Ż��]Ż���� id : " );
		String delId = scan.next();
		for(int i=0; i<userList.size(); i++) {
			if( userList.get(i).getId().equals(delId)) {
				delIdx = i;		
			}
		}
		System.out.print("[Ż��]Ż���Ͻðڽ��ϱ�? y/n : " );
		String ans = scan.next();

		if(ans.equals("y")) {
			userList.remove(delIdx);
			userLog =-1;
			System.out.println("[Ż��]Ż��Ǿ����ϴ�.");
		}
		

		
		
	}
	public boolean loginUser() {
		userLog = -1;
		System.out.print("[�α���] id�� �Է��ϼ��� :");
		String id = scan.next();
		
		for(int i=0; i<userList.size(); i++) {
			if( userList.get(i).getId().equals(id)) {
				userLog = i;
				break;
			}
		}
		if(userLog ==-1) {
			System.out.println("[�α���]id�� Ȯ���� �ּ���.");
			return false;
		}
		else {
			System.out.println("[�α���] "+userList.get(userLog).getId()+"�� �α���.");
			return true;
		}
		
	}
	public void logoutUser() {
		if(userLog != -1) {
			System.out.println("[�α׾ƿ�] �α׾ƿ� ����!");
			userLog =-1;
		}
		else {
			System.out.println("[�α׾ƿ�] �α��� �� �̿����ּ���.");
		}
	
	}
}
