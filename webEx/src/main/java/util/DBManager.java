package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	
	
	
	//DBManager.getConnection();
	// �� �ܺ� Ŭ�������� ��� ������ �ʿ��� ��. Connection�� �� �� ���� 
	public static Connection getConnection(String database) {
		Connection conn =null;
		
		String url ="jdbc:mysql://localhost:3306/";
		String user="root";
		String password="1234";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url+database, user, password);
			System.out.println("DB���� ����!");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
