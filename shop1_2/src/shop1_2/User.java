package shop1_2;

public class User {

	private String id;
	private int money;
	
	User(String id, int money){
		this.id = id;
		this.money = money;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMoney() {
		return money;
	}

	public void addMoney(int money) {
		this.money += money;
	}
	public void minusMoney(int money) {
		this.money -= money;
	}


}
