package lmsMap;

import java.util.InputMismatchException;
import java.util.Iterator;

// 변경 요청 처리 
public class StudentController {

	private StudentDAO dao;

	private RegistrationController rc;

	public StudentController() {
		this.dao = StudentDAO.getInstance();
		this.rc = new RegistrationController();
	}

	public void saveData() {

	}
	public void loadData() {
		
	}

	public void printStudents() {
		Iterator<Integer> keys = dao.getKeyset(); // StudentDAO.stuDb.keySet().iterator();
		while (keys.hasNext()) {
			System.out.println(dao.getStudent(keys.next()));
		}
	}



	public void updateStudent() {
		System.out.print("학번입력: ");
		try {
			int num = Lms.scan.nextInt();
			Student target = dao.getStudent(num);

			if (target != null) {
				selectSubMenu(num);
			} else {
				System.err.println("존재하지않는 학번입니다.");
			}
		} catch (Exception e) {
			System.err.println("잘못된 입력입니다.");
		}
	}

	private void selectSubMenu(int stuNum) {
		String[] subMenu = { "수강신청", "수강철회", "성적입력", "뒤로가기" };

		while (true) {
			Lms.printMenu(subMenu);
			System.out.print("sel: ");
			try {
				int sel = Lms.scan.nextInt();
				if (sel == 1) rc.createReg(stuNum);
				else if (sel == 2) rc.deleteReg(stuNum);
				else if (sel == 3) rc.updateReg(stuNum);
				else if (sel == 4)
					break;
			} catch (InputMismatchException e) {
				System.err.println("번호를 입력해주세요.");
			}
		}
	}
	public void createStudent() {
		System.out.print("학생명: ");
		String name = Lms.scan.next();
		Student student = new Student(name);
		int result = dao.addStudent(student);
		System.out.printf("학번발급: %d\n", result);
	}
	public void deleteStudent() {
		System.out.print("학번입력: ");
		try {
			int num = Lms.scan.nextInt();
			Student target = dao.getStudent(num);
			
			if (target != null) {
				dao.removeStudent(target.getNum());
//				System.out.println(target.getName());
				System.out.println("삭제 완료 ");
			} else {
				System.err.println("존재하지않는 학번입니다.");
			}
		} catch (Exception e) {
			System.err.println("잘못된 입력입니다.");
		}

	}
	
}
