package lmsMap;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

// Learning Management System
public class Lms {
	public static Scanner scan = new Scanner(System.in);
	public static Random ran = new Random();
	
	
	private String name;
	
	private StudentController sc;
	
	private boolean isRun;
	
	private String[] menuList = {"등록","수정","삭제","조회","불러오기","종료"};
	
	public Lms(String name) { //생성자 (이름받고, sc는 컨트롤러 받아오고 런은 트류)
		this.name = name; 
		this.sc = new StudentController();
		this.isRun =true;
	}
	
	public void run() {
		while(isRun) {
			System.out.printf("[%s (%d)]\n",this.name ,StudentDAO.getInstance().getSize());
			printMenu(this.menuList);
			selectMenu();
		}
		System.err.println("Shutting Down");
	}
	
	private void selectMenu() {
		System.out.print("sel: ");
		try {
			int sel =Lms.scan.nextInt();
			
			if(sel==1) sc.createStudent();
			else if(sel==2) sc.updateStudent();
			else if(sel==3) sc.deleteStudent();
			else if(sel==4) sc.printStudents();
			else if(sel==5) sc.loadData();
			else if(sel==6) {
				sc.saveData();
				this.isRun = false;
			}
			
		} catch (InputMismatchException e) {
			System.err.println("번호를 입력해주세요.");
		}
	}
	public static void printMenu(String[] list) {
		for(int i=0; i<list.length; i++) {
			System.out.printf("%d) %s\n",i+1,list[i]);
		}
	}
	
}
