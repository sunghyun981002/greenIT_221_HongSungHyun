package atm;

import java.util.ArrayList;

public class UserManager {
	public static UserManager instance = new UserManager(); //이 부분이 이해가 잘안된다 .
	private UserManager() {
		
	}
	private static ArrayList<User> users = new ArrayList<User>();
	
	
	public boolean addUser(User user) {
		//중복검사 -> users.add{}
		boolean check =true;
		for(User u : this.users) {
			if(u.getId().equals(user.getId())) {
				check =false;
			}
		}
		if(check) { //검증완료됨
			User newUser = new User(createCod(),user.getId(), user.getPw(), user.getName());
			this.users.add(newUser);
			return true;
		}
		return false;
	}
	
	private int createCod() {
		//중복되지않는 고유코드 랜덤 발급
		return 0;
	}

}
