package lmsMap;

import java.util.ArrayList;

public class Student {
	
	private int num;
	private String name;
	private ArrayList<Registration> subs;
	
	public Student(String name) {
		this.name = name;
	}
	public Student(int num ,String name) {
		this.name = name;
		this.num =num;
		this.subs =new ArrayList<>();
	}
	public int getNum() {
		return num;
	}
	public String getName() {
		return name;
	}
	

	public ArrayList<Registration> getSubs() {
		return subs;
	}

	@Override
	public String toString() {
		String str = String.format("[%d] %s (%d과목 수강중)\n", this.num, this.name, this.subs.size());
		for(Registration r : this.subs) {
			str += r.toString() + "\n";
		}
		str.substring(0, str.length() -1);
		return str;
	}
	
	public void addSubs(Registration newRegstration) {
		this.subs.add(newRegstration);
	}
}
