package atm;

import java.util.ArrayList;

public class AccountManager {
	public static AccountManager instance = new AccountManager();
	
	private AccountManager(){
		
	}
	private static ArrayList<Account> accs = new ArrayList<Account>();
	
	
	public boolean addAcc(int userIdx) {
		//userCode를 통해 -> 해당 회원의보유 계좌수를 -> 검증
		int accCnt = UserManager.instance.getAccCnt(userIdx);
		int userCode = UserManager.instance.getUserCode(userIdx);

	}

	private int createAccCode() {
		return 0;
	}
}
