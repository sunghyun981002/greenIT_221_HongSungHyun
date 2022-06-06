package atm;

public class Main {

	public static void main(String[] args) {
		//atm
		//ㄴ 회원 한 명 당, 계좌를 최대 3개까지 개설이 가능함 

		//1. 회원가입/ 탈퇴
		//ㄴ User
		//ㄴ UserManager
		//2. 계좌개설/ 해지
		//ㄴ Account
		//ㄴ AccountMananger
		
		//3.atm운영
		// ㄴ Bank(run())

		
//		Bank.setName("Green");
		

		Bank.instance.menu(); 
	}

}
