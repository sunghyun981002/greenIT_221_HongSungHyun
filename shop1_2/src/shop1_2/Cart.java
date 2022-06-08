package shop1_2;

public class Cart {

	private String userId;
	private String itemName;
	
//	Cart(String id , String name){
//		this.userId = id;
//		this.itemName = name;
//	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	void print() {
		System.out.println("[" + userId + "]" + "아이템 : " + itemName);
	}
	
	
}
