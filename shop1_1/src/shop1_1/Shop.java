package shop1_1;

import java.util.Scanner;

public class Shop {

	public static Shop instance = new Shop();
	private Scanner scan = new Scanner(System.in);
	ItemManager im = ItemManager.instance;
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
			else if(sel==100) managerMenu(); // 관리자 메뉴 만들어서 하기 
			else if(sel==0) break;
			
		}
	}

	public void loginMenu() {
		if(um.loginUser()) { //true일때 로그인 됌
			while(true) {
				System.out.println("1.쇼핑하기\n2.장바구니 목록\n0.종료하기");
				int sel =scan.nextInt();
				if(sel==1) shopMenu();
				else if(sel==2) cartMenu();
				else if(sel==0) break;
			}			
			
		}
		
	}
	public void shopMenu() {
		// 아이템 만들고 / 아이템 카테고리 보이게 해주고 / 선택하면 cart에 추가 
		while(true) {
			im.printCate();
			System.out.print("[카테고리]번호를 입력하세요(종료 -1): ");
			int cateIdx = scan.nextInt();
			if(cateIdx ==-1) {
				break;
			}
			im.printItemList(cateIdx);
			System.out.print("[아이템리스트]번호를 입력하세요: ");
			int buyNum = scan.nextInt();
			im.addCart(um.userList.get(um.userLog()).getId(), cateIdx, buyNum);
			
		}
		
	}
	public void cartMenu() {
		while(true) {
			System.out.println("1.장바구니 확인\n2.목록삭제\n3.구매하기\n0.종료");
			int sel= scan.nextInt();
			
			if(sel ==1 ) {
				im.printCart(um.userList.get(um.userLog()));
			}
			else if(sel==2) {
				im.clearCart(um.userList.get(um.userLog()));
			}
			else if(sel==3) {
				System.out.println("총 금액 : "+im.buyCart(um.userList.get(um.userLog()))+"원");
				System.out.print("지불 금액: ");
				int pay= scan.nextInt();
				
				if(pay>=im.buyCart(um.userList.get(um.userLog()))) {
					System.out.println("결제완료! 거스르돈 :"+(pay-im.buyCart(um.userList.get(um.userLog())))+"원");
					im.clearCart(um.userList.get(um.userLog()));
				}
				else {
					System.out.println("금액부족");
				}
			}
			else if(sel==0)break;
		}
	}
	public void managerMenu() {
		while(true) {
			System.out.println("1.아이템관리\n2.카테고리관리\n3.유저관리\n0.종료");
			int sel = scan.nextInt();
			
			if(sel==1) {
				
			}
		}
	}
	
}
