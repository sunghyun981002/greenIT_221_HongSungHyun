package user;

import java.util.Date;

public class UserDTO {
	
//	create table users(
//			custno number(6) not null primary key,
//			custname varchar2(20),
//			phone varchar2(13),
//			address varchar2(4),
//			joindate date,
//			grade char(1),
//			city char (2)
//			);
	private int custno;
	private String custname,phone,address,grade,city, joindate;
	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}



	public UserDTO(int num ,String name, String phone, String address, String joindate, String grade, String city) {
		custno=num;
		custname=name;
		this.phone=phone;
		this.address =address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	public UserDTO(String name, String phone, String address, String city) {
		this.custname =name;
		this.phone =phone;
		this.address = address;
		this.city = city;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
