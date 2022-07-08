package webEx;

public class UserDTO {
//	id
//	pw
//  checkpw
//	name
//	year
//	month
//	day
//	gender
//	email
//	nation
//	mobile
	
	private String id, pw,checkpw, name;
	private int year,month,day,gender;
	private String email,nation,mobile;
	
	
	//constructor
	public UserDTO(String id,String pw,String checkpw,String name ,int year,int month,int day,int gender,String email,String nation,String mobile ) {
		this.id =id;
		this.pw= pw;
		this.checkpw= checkpw;
		this.name= name;
		this.year= year;
		this.month= month;
		this.day= day;
		this.gender= gender;
		this.email= email;
		this.nation= nation;
		this.mobile= mobile;
		
	}
	
	
	public UserDTO(String id, String pw, String name, int year, int month, int day, int gender, String email,
			String nation, String mobile) {
		this.id =id;
		this.pw= pw;
		this.name= name;
		this.year= year;
		this.month= month;
		this.day= day;
		this.gender= gender;
		this.email= email;
		this.nation= nation;
		this.mobile= mobile;
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
	public String getCheckpw() {
		return checkpw;
	}
	public void setCheckpw(String checkpw) {
		this.checkpw = checkpw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
