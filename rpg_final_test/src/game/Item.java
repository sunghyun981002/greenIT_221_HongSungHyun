package game;

public class Item {
	
	static final int WEAPON =1;
	static final int ARMOR =2;
	static final int RING =3;
	static final int POTION =4;
	
	private int kind,power,price;
	private String name;
	
	public Item(int k,String n, int p, int pr) {
		kind =k;
		name =n;
		power = p;
		price = pr;
	}
	
	public void setItem(int k,String n, int p, int pr) {
		kind =k;
		name =n;
		power = p;
		price = pr;
	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWEAPON() {
		return WEAPON;
	}

	public int getARMOR() {
		return ARMOR;
	}

	public int getRING() {
		return RING;
	}
}
