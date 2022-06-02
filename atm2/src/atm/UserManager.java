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
	public void loginUser(String id, String pw) {
		for (int i = 0; i < this.users.size(); i++) {
			if(users.get(i).getId().equals(id)&&users.get(i).getPw().equals(pw)) {
				Bank.instance.log(users.get(i).getName());
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

}
