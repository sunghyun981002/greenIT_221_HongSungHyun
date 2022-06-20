package lmsMap;

import java.util.InputMismatchException;

public class RegistrationController {
	
	private RegistrationDAO regDao;
	private StudentDAO stuDao;
	private SubjectDAO subDao;
	
	public RegistrationController() {
		this.regDao = RegistrationDAO.getInstance();
		this.stuDao = StudentDAO.getInstance();
		this.subDao = SubjectDAO.getInstance();
	}
	
	public void createReg(int stuNum) {
		Lms.printMenu(subDao.getSubTitleList());
		try {
			System.out.print("과목선택 : ");
			int subKey = Lms.scan.nextInt();
			
			Student student = stuDao.getStudent(stuNum);
			Subject subject = subDao.getSubject(subKey);
			
			if(subject != null )
				regDao.addReg(new Registration(student , subject));
			else
				System.err.println("존재하지 않는 과목입니다. ");
		} catch (InputMismatchException e) {
			System.err.println("번호를 입력해주세요 .");
		}
	}
	public void deleteReg(int stuNum) {
		//내가 듣고있는 수업 보여주기 
		int cnt =0;
		Student student = stuDao.getStudent(stuNum);
		for(int i=0; i<student.getSubs().size(); i++) {
			cnt++;
			System.out.printf((i+1)+") %d / %s\n",student.getSubs().get(i).getRegCode() , student.getSubs().get(i).getSubject().getTitle());
		}
		try {
			System.out.print("과목번호 : ");
			int subKey = Lms.scan.nextInt()-1;
			Subject subject = subDao.getSubject(subKey);
			
			if(subKey>=0&&subKey<=cnt) {
				student.getSubs().remove(subKey);
				System.out.println("삭제 성공");
			}
			else {
				System.err.println("존재하지 않는 과목입니다. ");
			}		
			
		} catch (Exception e) {
			System.err.println("번호를 입력해주세요");
		}
	}

	public void updateReg(int stuNum) {
		int cnt =0;
		Student student = stuDao.getStudent(stuNum);
		for(int i=0; i<student.getSubs().size(); i++) {
			cnt++;
			System.out.printf((i+1)+") %d/%s : %d점\n",student.getSubs().get(i).getRegCode() , student.getSubs().get(i).getSubject().getTitle(),student.getSubs().get(i).getScore());
		}
		try {
			System.out.print("과목번호 : ");
			int subKey = Lms.scan.nextInt()-1;
			
			if(subKey>=0&&subKey<=cnt) {
				System.out.print("성적입력 : ");
				int num = Lms.scan.nextInt();
				student.getSubs().get(subKey).setScore(num);
				System.out.println("성적입력 완료!");
		
			}
			else {
				System.err.println("존재하지 않는 과목입니다. ");
			}		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
