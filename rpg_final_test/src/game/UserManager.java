package game;

import java.util.ArrayList;

public class UserManager {
	public static UserManager instance = new UserManager();
	private int userLog = -1;

	public int getUserLog() {
		return this.userLog;
	}
	ArrayList<User> userList = new ArrayList<>();
	
	private UserManager(){
		
	}

	
	public void CreateUser() {
		int check =-1;
		System.out.print("[회원가입] id :");
		String id = Game.instance.scan.next();
		System.out.print("[회원가입] pw :");
		String pw = Game.instance.scan.next();
		
		for(int i=0; i<userList.size(); i++) {
			if(userList.get(i).getId().equals(id)) {
				check =1;
			}
			
		}
		if(check ==-1) {
			User us = new User(id,pw);
			userList.add(us);
			Guild.instace.setGuild(id);
			System.out.println("[회원가입]성공!");
			
		}
		else {
			System.out.println("[회원가입]이미 존재하는 아이디입니다.");
		}
	}
	public boolean loginUser() {
		userLog = -1;
		System.out.print("[로그인] id를 입력하세요 : ");
		String id = Game.instance.scan.next();
		System.out.print("[로그인] pw를 입력하세요 : ");
		String pw = Game.instance.scan.next();
		
		for(int i=0; i<userList.size(); i++) {
			if(userList.get(i).getId().equals(id)&&userList.get(i).getPw().equals(pw)) {
				userLog = i;
				Guild.instace.checkLogId(id);
				break;
			}
		}
		if(userLog ==-1) {
			System.out.println("[로그인]id나pw를 확인해 주세요.");
			return false;
		}
		else {
			System.out.println("[로그인] "+userList.get(userLog).getId()+"님 로그인.");
			
			return true;
		}
		
	}

	public void deleteUser() {
		int delIdx = -1;
		System.out.print("[탈퇴]탈퇴할 id를 입력해주세요. : " );
		String delId = Game.instance.scan.next();
		System.out.print("[탈퇴]탈퇴할 pw를 입력해주세요. : " );
		String delpw = Game.instance.scan.next();
		for(int i=0; i<userList.size(); i++) {
			if( userList.get(i).getId().equals(delId)&&userList.get(i).getPw().equals(delpw)) {
				delIdx = i;	
			}
		}
		if(delIdx != -1) {
			System.out.print("[탈퇴]탈퇴하시겠습니까? y/n : " );
			String ans = Game.instance.scan.next();
			
			if(ans.equals("y")) {
				userList.remove(delIdx);
				userLog =-1;
				System.out.println("[탈퇴]탈퇴되었습니다.");
			}		
		}
		else {
			System.out.println("[탈퇴]존재하지않는 아이디입니다.");
		}
	}
	public void printUserList() {
		System.out.println("[회원 목록]");
		for(int i=0; i<userList.size(); i++) {
			System.out.print((i+1)+")  ID : "+userList.get(i).getId()+"\n");
		}
	}
	
}
