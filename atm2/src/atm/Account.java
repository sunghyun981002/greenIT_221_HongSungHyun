package atm;

public class Account {

	private int userCode;
	private int accNum;
	private int money;
	
	
	public Account(int log, int accNum) {
		this.userCode =log;
		this.accNum =accNum;

	}



	public int getUserCode() {
		return userCode;
	}
	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	public int getAccNum() {
		return accNum;
	}
	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
}
