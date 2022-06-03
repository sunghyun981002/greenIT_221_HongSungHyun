package atm;

import java.util.ArrayList;
import java.util.Random;

public class AccountManager {
	public static AccountManager instance = new AccountManager();

	private AccountManager() {

	}

	private static ArrayList<Account> accs = new ArrayList<Account>();

	public boolean addAcc(int userIdx) { //0
		// userCode를 통해 -> 해당 회원의보유 계좌수를 -> 검증
		int accCnt = UserManager.instance.getAccCnt(userIdx); //0
		int userCode = UserManager.instance.getUserCode(userIdx); //1
		if (accCnt < 3) {
			Account newAcc = new Account(userCode, createAccCode());
			accs.add(newAcc);
			// 사용자의 바로가기 리스트에 추가
			UserManager.instance.getUserAccList(userIdx).add(newAcc);
			UserManager.instance.setAccCnt(userIdx, accCnt + 1);
			return true;
		}
		return false;

	}

	private int createAccCode() {
		Random ran =new Random();
		int code = ran.nextInt(1000)+1;
		return code;
	}
	public boolean deleteAcc(int userIndex, int delAccIdx) {
		ArrayList<Account> list = UserManager.instance.getUserAccList(userIndex);
		Account delAcc = list.get(delAccIdx);
		
		try {
			list.remove(delAcc);
			this.accs.remove(delAcc);
			UserManager.instance.setAccCnt(userIndex, list.size());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
