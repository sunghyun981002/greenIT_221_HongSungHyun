package atm;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UserManager {
	private Scanner scan = new Scanner(System.in);
	private int cnt = 0;
	public static UserManager instance = new UserManager(); 
	private int checkPay = -1;
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
	public int userSize() {
		return users.size();
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
	public String getName(int idx) {
		return users.get(idx).getName();
	}
	public String getId(int idx) {
		return users.get(idx).getId();
	}
	public String getPw(int idx) {
		return users.get(idx).getPw();
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
			System.out.printf("[%d] accNum: %s money: %d원\n", (i+1), list.get(i).getAccNum(),list.get(i).getMoney());
		}
	}
//	public ArrayList<Account> usersAccGetAccNum(int idx) {
//		 return getUserAccList(idx);
//	}
//	public void usersAccGetMoney(int idx) {
//		
//	}
	public void setUserPlusMoney(int Useridx, int accNum ,int money) {
		ArrayList<Account> list = getUserAccList(Useridx);

		list.get(accNum).setAddMoney(money);
	}
	public void setUserMinusMoney(int Useridx, int accNum ,int money) {
		checkPay =-1;
		ArrayList<Account> list = getUserAccList(Useridx);
		if(list.get(accNum).getMoney() >= money) {
			list.get(accNum).setMinMoney(money);
			checkPay =0;
		}
		else {
			System.out.println("금액부족");
			checkPay =-1;
		}
	}
	public void transferMoneyForUser(int log) {
		ArrayList<Account> list1 = getUserAccList(log);
		if(users.size()>=2 &&list1.size()>0) {
			System.out.println("[User List]");
			for(int i=0; i<users.size(); i++) {
				if(i!=users.size()-1) {
					System.out.print((i+1) +"."+ users.get(i).getName() + "/ ");				
				}
				else {
					System.out.print((i+1) +"."+users.get(i).getName());
				}
			}
			System.out.println();
			System.out.print("보내실 user의 번호를 입력해주세요.");
			int sel =scan.nextInt()-1;
			if(sel != log) {
				System.out.println("[User "+ users.get(sel).getName()+"님의 Acc List]");
				printAllUsersAccList(sel);
				ArrayList<Account> list2 = getUserAccList(sel);
				if(list2.size()>0) {
					System.out.print("이체할 계좌 Num : ");
					int accNum = scan.nextInt()-1;
					if(accNum<getUserAccList(sel).size()) {
						
						System.out.print("이체 금액 : ");
						int money = scan.nextInt();
						
						printAllUsersAccList(log);
						System.out.print("몇 번째 계좌에서 이체해주시겠습니까? :");
						int selectNum = scan.nextInt()-1;
						if(selectNum<getUserAccList(log).size()) {
							setUserMinusMoney(log,selectNum,money);
							if(checkPay ==0) {
								setUserPlusMoney(sel,accNum,money);
								System.out.println("이체 완료!");
							}										
						}
						else {
							System.out.println("존재하지않는 accnum입니다.");
						}
					}
					else {
						System.out.println("존재하지않는 accnum입니다.");
					}
				}
				else {
					System.out.println("상대방이 계좌가 존재하지않습니다.");
				}
			}
			else {
				System.out.println("자기 자신에게는 보낼 수 없습니다");
			}
		}
		else {
			System.out.println("user와 acc부터 생성해주시고 이용해주세요.");
		}
		
		
	}


}
