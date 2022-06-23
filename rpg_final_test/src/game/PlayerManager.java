package game;

import java.util.ArrayList;

public class PlayerManager {
	public static PlayerManager instance = new PlayerManager();
	private int playerLog = -1;

	private String PlayerLogId;
	public int getUserLog() {
		return this.playerLog;
	}
	ArrayList<Player> playerList = new ArrayList<>();
	
	private PlayerManager(){
		
	}

	
	public void CreateUser() {
		int check =-1;
		System.out.print("[회원가입] id :");
		String id = Game.instance.scan.next();
		System.out.print("[회원가입] pw :");
		String pw = Game.instance.scan.next();
		
		for(int i=0; i<playerList.size(); i++) {
			if(playerList.get(i).getId().equals(id)) {
				check =1;
			}
			
		}
		if(check ==-1) {
			Player pl = new Player(id,pw);
			playerList.add(pl);
			Guild.instace.setGuild(id);
			System.out.println("[회원가입]성공!");
			
		}
		else {
			System.out.println("[회원가입]이미 존재하는 아이디입니다.");
		}
	}
	public boolean loginUser() {
		playerLog = -1;
		System.out.print("[로그인] id를 입력하세요 : ");
		String id = Game.instance.scan.next();
		System.out.print("[로그인] pw를 입력하세요 : ");
		String pw = Game.instance.scan.next();
		
		for(int i=0; i<playerList.size(); i++) {
			if(playerList.get(i).getId().equals(id)&&playerList.get(i).getPw().equals(pw)) {
				playerLog = i;
				Guild.instace.checkLogId(id);
				PlayerLogId =id;
				break;
			}
		}
		if(playerLog ==-1) {
			System.out.println("[로그인]id나pw를 확인해 주세요.");
			return false;
		}
		else {
			System.out.println("[로그인] "+playerList.get(playerLog).getId()+"님 로그인.");
			
			return true;
		}
		
	}

	public void deleteUser() {
		int delIdx = -1;
		System.out.print("[탈퇴]탈퇴할 id를 입력해주세요. : " );
		String delId = Game.instance.scan.next();
		System.out.print("[탈퇴]탈퇴할 pw를 입력해주세요. : " );
		String delpw = Game.instance.scan.next();
		for(int i=0; i<playerList.size(); i++) {
			if( playerList.get(i).getId().equals(delId)&&playerList.get(i).getPw().equals(delpw)) {
				delIdx = i;	
			}
		}
		if(delIdx != -1) {
			System.out.print("[탈퇴]탈퇴하시겠습니까? y/n : " );
			String ans = Game.instance.scan.next();
			
			if(ans.equals("y")) {
				playerList.remove(delIdx);
				playerLog =-1;
				System.out.println("[탈퇴]탈퇴되었습니다.");
			}		
		}
		else {
			System.out.println("[탈퇴]존재하지않는 아이디입니다.");
		}
	}
	public void printUserList() {
		System.out.println("[회원 목록]");
		for(int i=0; i<playerList.size(); i++) {
			System.out.print((i+1)+")  ID : "+playerList.get(i).getId()+"\n");
		}
	}
	public int playerLog() {
		return playerLog;
	}
	public String playerLogId() {
		return this.PlayerLogId;
	}

}
