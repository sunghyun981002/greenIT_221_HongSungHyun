package atm;

import java.util.ArrayList;

public class User {
	private int code , accCnt;
	private String id, pw;
	private String name;
	
	private ArrayList<Account> accs;
	
	public User(int cnt, String id2, String pw2, String name2) {
		this.code = cnt;
		this.id =id2;
		this.pw = pw2;
		this.name=name2;
	}
	public int getCode() {
		return this.code;
	}
	public int getAccCnt() {
		return this.accCnt;
	}
	public String getId() {
		return this.id;
	}
	public String getPw() {
		return this.pw;
	}
	public String getName() {
		return this.name;
	}
	public void setCode(int code) {
		this.code= code;
	}
	public void setAccCnt(int accCnt) {
		this.accCnt= accCnt;
	}
	public void setId(String id) {
		this.id= id;
	}
	public void setPw(String pw) {
		this.pw= pw;
	}
	public void setName(String name) {
		this.name =name;
	}

}
