package game;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game {
	public static Game instance = new Game();
	
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();

	private Game(){
		
	}
	public void printGameMenu() {
		while(true) {
			System.out.println("=============== [RPG GAME] ================");
			System.out.println("[1.회원가입] [2.로그인] [3.아이디삭제] ");
			System.out.println("[4.회원목록조회] [0.게임종료] ");
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			if(sel == 1)UserManager.instance.CreateUser();
			else if (sel==2) {
				if(UserManager.instance.loginUser()) {
					MainGame();
				}
			}
			else if (sel==3) UserManager.instance.deleteUser();
			else if (sel==4) UserManager.instance.printUserList();
			else if (sel==0) {
				System.out.println("게임을 종료합니다.");
				break;
			}
			
			
		}
	}
	public void MainGame() {
		while(true) {
			System.out.println("=============== [메인메뉴] ================");
			System.out.println("[1.길드관리] [2.상점] [3.인벤토리]");
			System.out.println("[4.저장] [5.로드] [6.사냥] [0.게임메뉴로 돌아가기]");
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			if(sel ==1) Player.instance.guildMenu();
			else if(sel==2) Shop.instance.shopMenu();
			else if(sel==3) Inventory.instance.invenMenu();
			else if(sel==4) {
				try {
					FileData.instance.save();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} 
			else if(sel==5) {
				try {
					FileData.instance.loadData();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if(sel==6) Hunt.instance.partyHunt();
			else if(sel==0) {
				System.out.println("게임메뉴로 이동!");
				break;
			}
		}
		
	}
}
