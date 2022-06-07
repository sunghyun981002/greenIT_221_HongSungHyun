package shop1_1;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {
	ArrayList<User> userList = new ArrayList<User>();
	public static UserManager instance = new UserManager();
	Scanner scan = new Scanner(System.in);
	
	private int userLog = -1;
	private UserManager(){
		
	}
	public int userLog() {
		return userLog;
	}
	
	public void joinUser() {
		int check = -1;
		System.out.print("[회원가입] id를 입력하세요 : ");
		String id = scan.next();
		for(int i=0; i<userList.size(); i++) {
			if(userList.get(i).getId().equals(id)) {
				check =1;
			}
			
		}
		if(check ==-1) {
			User us = new User(id,0);
			userList.add(us);
			System.out.println("[회원가입] 가입성공! ");			
		}
		else {
			System.out.println("[회원가입] 이미 존재하는 아이디입니다.");
		}
		
	}
	public void deleteUser() {
		int delIdx = -1;
		System.out.print("[탈퇴]탈퇴할 id : " );
		String delId = scan.next();
		for(int i=0; i<userList.size(); i++) {
			if( userList.get(i).getId().equals(delId)) {
				delIdx = i;		
			}
		}
		System.out.print("[탈퇴]탈퇴하시겠습니까? y/n : " );
		String ans = scan.next();

		if(ans.equals("y")) {
			userList.remove(delIdx);
			userLog =-1;
			System.out.println("[탈퇴]탈퇴되었습니다.");
		}
		

		
		
	}
	public boolean loginUser() {
		userLog = -1;
		System.out.print("[로그인] id를 입력하세요 :");
		String id = scan.next();
		
		for(int i=0; i<userList.size(); i++) {
			if( userList.get(i).getId().equals(id)) {
				userLog = i;
				break;
			}
		}
		if(userLog ==-1) {
			System.out.println("[로그인]id를 확인해 주세요.");
			return false;
		}
		else {
			System.out.println("[로그인] "+userList.get(userLog).getId()+"님 로그인.");
			return true;
		}
		
	}
	public void logoutUser() {
		if(userLog != -1) {
			System.out.println("[로그아웃] 로그아웃 성공!");
			userLog =-1;
		}
		else {
			System.out.println("[로그아웃] 로그인 후 이용해주세요.");
		}
	
	}
}