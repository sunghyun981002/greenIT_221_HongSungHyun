package atm;

import java.util.ArrayList;

public class User {
	private int code , accCnt;
	private String id, pw;
	private String name;
	
	private ArrayList<Account> accs;
	
	//사용자를 통해 입력받은 데이터 -> 가 객체 생성 용도
	public User( String id, String pw, String name) {
		this.id =id;
		this.pw = pw;
		this.name=name;
	}
	
	//검증이 완료된 객체에 대하여 -> 실 데이터화하는 용도 
	public User(int code, String id, String pw, String name) {
		this.code=code;
		this.id =id;
		this.pw = pw;
		this.name=name;
		
		accs = new ArrayList<Account>();	
	}

	public int getCode() {
		return code;
	}


	public int getAccCnt() {
		return accCnt;
	}

	public void setAccCnt(int accCnt) {
		this.accCnt = accCnt;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}


	

}
