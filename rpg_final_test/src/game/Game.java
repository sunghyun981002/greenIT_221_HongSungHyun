package game;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game {
	public static Game instance = new Game();
	HuntManager hm = new HuntManager();
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
//	Player curPlayer = PlayerManager.instance.playerList.get(PlayerManager.instance.playerLog());

	// 샵 인벤토리 파일데이터 
	private Game(){
		
	}
	public void printGameMenu() {
		while(true) {
			System.out.println("=============== [RPG GAME] ================");
			System.out.println("[1.회원가입] [2.로그인] [3.아이디삭제] ");
			System.out.println("[4.회원목록조회] [5.저장] [6.로드] [0.게임종료] ");
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			if(sel == 1)PlayerManager.instance.CreateUser();
			else if (sel==2) {
				if(PlayerManager.instance.loginUser()) {
					MainGame();
				}
			}
			else if (sel==3) PlayerManager.instance.deleteUser();
			else if (sel==4) PlayerManager.instance.printUserList();
			else if (sel==5) {}
			else if (sel==6) {}
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
			System.out.println("[4.던전입장] [0.게임메뉴로 돌아가기(로그아웃)]");
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			if(sel ==1) Guild.instace.guildMenu();
			else if(sel==2) Shop.instance.shopMenu();
			else if(sel==3) Inventory.instance.invenMenu(PlayerManager.instance.playerLogId());
			else if(sel==4) {
				boolean run = true;
				while(true) {
					run =hm.changeStage();
					if(run==false)
						break;
				}
				System.out.println("메인 메뉴로 이동");
			}
			else if(sel==0) {
				System.out.println("게임메뉴로 이동!");
				break;
			}
		}
		
	}
}
