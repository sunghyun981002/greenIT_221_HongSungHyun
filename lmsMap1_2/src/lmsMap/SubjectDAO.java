package lmsMap;

import java.util.HashMap;
import java.util.Map;

public class SubjectDAO {
	
	// 고유번호, 과목
	private Map<Integer, Subject> subDb;
	
	private static SubjectDAO instance = new SubjectDAO();
	private SubjectDAO() {
		this.subDb = new HashMap<>();
		init();
	}
	
	public static SubjectDAO getInstance() {
		return instance;
	}

	private void init() {
		this.subDb.put(1, new Subject(1, "Java"));
		this.subDb.put(2, new Subject(2, "Python"));
		this.subDb.put(3, new Subject(3, "C"));
		this.subDb.put(4, new Subject(4, "JSP"));
		this.subDb.put(5, new Subject(5, "Spring"));
	}
	
	public String[] getSubTitleList() {
		String[] list = new String[this.subDb.size()];
		for(Integer i: this.subDb.keySet()) {
			list[i-1] = this.subDb.get(i).getTitle();
		}
		return list;
	}
	public Subject getSubject(int key) {
		return this.subDb.get(key);
	}


}
