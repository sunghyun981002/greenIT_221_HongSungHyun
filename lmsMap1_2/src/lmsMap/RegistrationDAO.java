package lmsMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RegistrationDAO {
	
	// <regCode, 수강정보 객체>
	private Map<Integer, Registration> regDb;
	
	private static RegistrationDAO instance = new RegistrationDAO();
	
	private RegistrationDAO() {
		this.regDb = new HashMap<>();
	}
	public static RegistrationDAO getInstance() {
		return instance;
	}
	
	public void addReg(Registration reg) {
		int regCode = ranCode();
		Registration newRegistration = new Registration(regCode , reg.getStudent(), reg.getSubject());
		this.regDb.put(regCode, newRegistration);
		newRegistration.getStudent().addSubs(newRegistration);
	}
//	public void removeReg(int num) {
//		this.regDb.remove(num);
//	}
	
	private int ranCode() {
		Set<Integer> keys = this.regDb.keySet();	
		//전체 값 접근
		// ㄴ keySet 활용
		while(true) {
			int code = Lms.ran.nextInt(8999)+1000;
			if(!keys.contains(code))
				return code;
		}
	}

}
