package lmsMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// 실데이터 + 변경 처리 
public class StudentDAO {

	// <학번, 학생>
	private Map<Integer, Student> stuDb;

	private static StudentDAO instance = new StudentDAO(); //static으로 만들고 private 처리 
	private StudentDAO() {
		this.stuDb = new HashMap<>();
	}
	
	public static StudentDAO getInstance() {
		return instance;
	}
	public int addStudent(Student student) {
		int num =randomNum(); 
		Student newStudent = new Student(num,student.getName());
		this.stuDb.put(num, newStudent);
		return num;
	}
	public void removeStudent(int num) {
		this.stuDb.remove(num);
	}
	
	private int randomNum() {
	     Set<Integer> keyset = this.stuDb.keySet();
	     
	     while(true) { //keyset(전체 값을 돌면서 key값이 있는지 확인 후 없다면 return key;
	    	 int key = Lms.ran.nextInt(8999)+1000;
	    	 if(!keyset.contains(key)) // 존재여부를 true /false로 알려줌
	    		 return key;
	     }
	}

	public Object getSize() {
		return this.stuDb.size();
	}
	public Iterator<Integer> getKeyset(){
		return this.stuDb.keySet().iterator();
	}
	public Student getStudent(Integer key) {
		return this.stuDb.get(key);
	}

	

}
