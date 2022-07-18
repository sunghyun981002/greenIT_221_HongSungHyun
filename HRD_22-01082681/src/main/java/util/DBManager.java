package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	public static Connection getConnection() {
		
		Connection conn = null;
		
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user="c##system";
		String password="1234";
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,user,password);
			if(conn != null) {
				System.out.println("db연동 성공!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db연동 실패.");
		}
		return null;
	}

}
