package atm;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UserManager {
	private Scanner scan = new Scanner(System.in);
	private int cnt = 0;
	public static UserManager instance = new UserManager(); // 이 부분이 이해가 잘안된다 .

	private UserManager() {

	}

	private static ArrayList<User> users = new ArrayList<User>();

	public boolean addUser(User user) {
		// 중복검사 -> users.add{}
		boolean check = true;
		for (User u : this.users) {
			if (u.getId().equals(user.getId())) {
				check = false;
			}
		}
		if (check) { // 검증완료됨
			User newUser = new User(createCod(), user.getId(), user.getPw(), user.getName());
			this.users.add(newUser);
			return true;
		}
		return false;
	}

	public void removeUser(String id) {
		boolean check = true;
		int n = -1;
		for (int i = 0; i < this.users.size(); i++) {
			if (users.get(i).getId().equals(id)) {
				System.out.print("[탈퇴]pw : ");
				String pw = scan.next();
				if (users.get(i).getPw().equals(pw)) {
					users.remove(i);
					cnt--;
				}
			}

		}
	}

	private int createCod() {
		// 중복되지않는 고유코드 발급
		cnt++;

		return cnt;
	}

	public String toString(int i) {
		return users.get(i).getId();
	}

	public int getCnt() {
		return cnt;
	}
	public int checkLog(User user) {
		for(int i=0; i<users.size(); i++) {
			User u = users.get(i);
			if(u.getId().equals(user.getId())&&u.getPw().equals(user.getPw())) {
				return i;
			}
		}
		return -1;
	}
	public int getUserCode(int idx) {
		return users.get(idx).getCode();
	}
	public int getAccCnt(int idx) {
		User u = users.get(idx);
		return u.getAccCnt();
	}
	public void setAccCnt(int useridx , int accCnt) {
		this.users.get(useridx).setAccCnt(accCnt);
	}
	public void checkCode(String log) {
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).getName().equals(log)) {
				
			}
		}
	}
	public ArrayList<Account> getUserAccList(int idx){ //이거 쫌 어렵군 
		return this.users.get(idx).getAccs();
	}
	public void setUsersAccList(int index) {
		
	}
	public void printAllUsersAccList(int idx) {
		ArrayList<Account> list = getUserAccList(idx);
		for(int i=0; i<list.size(); i++) {
			System.out.printf("[%d] accNum: %s\n", (i+1), list.get(i).getAccNum());
		}
	}


}
