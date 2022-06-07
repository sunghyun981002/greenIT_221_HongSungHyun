package shop1_1;

public class Item {
	private String name;
	private int price;
	private String category;
	
	
	
	Item(String name ,int price, String cate){
		this.name = name;
		this.price = price; 
		this.category = cate;
	}
	
	public void print() {
		System.out.println("[" + name + "]" + "[" + price + "]" + "[" + category + "]");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
