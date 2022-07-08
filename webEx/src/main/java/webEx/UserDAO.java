package webEx;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;

public class UserDAO {

	
	private ArrayList<UserDTO> list = null;
	
	private UserDAO() {
		list = new ArrayList<UserDTO>();
	}
	
	private static UserDAO instance = new UserDAO();
	
	public static UserDAO getInstance() {
		return instance;
	}
	
	
	private Connection conn =null;
	private ResultSet rs =null;
	private PreparedStatement pstmt = null;
	
	private String url ="jdbc:mysql://localhost:3306/firstJsp";
	private String user="root";
	private String password="1234";
	
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn =DriverManager.getConnection(url,user,password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	
	// ���⼭���� ���ڵ�  
	 public boolean insertUsers(UserDTO userDto){ //�Է°� ->sql
			Date date = new Date(userDto.getYear()-1900,userDto.getMonth(),userDto.getDay());
			Timestamp birthDate = new Timestamp(date.getTime());
	        //������ �غ�
			conn =getConnection();
		 //insert into users values("banana","1234","ȫ����","19981002","1","abc@ abc.com","KOR","010-3058-5532"); 
	        String sql = "insert into users values(?,?,?,?,?,?,?,?)";
	        
	        try {
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, userDto.getId());
	            pstmt.setString(2, userDto.getPw());
	            pstmt.setString(3, userDto.getName());
	            pstmt.setTimestamp(4, birthDate);
	            pstmt.setInt(5, userDto.getGender());
	            pstmt.setString(6, userDto.getEmail());
	            pstmt.setString(7, userDto.getNation());
	            pstmt.setString(8, userDto.getMobile());
	            
	            int result = pstmt.executeUpdate(); //���ϰ��� ResultSet �� ��쿡�� true, �� ���� ��쿡�� false �� ��µ˴ϴ�(  �� �����ϱ�)
	            //(1) INSERT, DELETE, UPDATE�� ���� ��  (2) �ƹ� ������ ������ 0
	            if(result==1) {
	                System.out.println("users������ ���� ����!");
	                //�������� ������
	                return true;
	            }
	            return false;
	            
	        } catch (Exception e) {
	            System.out.println("users������ ���� ����!");
	            e.printStackTrace();
	            return false;
	            //�ٽ� �������� ������ 
	        }    finally {
	            try {
	                if(pstmt!=null && !pstmt.isClosed()) {
	                    pstmt.close();
	                }
	            } catch (Exception e2) {}
	        }
	        
	        
	    }  
	 
//	 public void removeUser(String checkUserId) {
//		 conn=getConnection();
//		 pstmt = null;
//		 
//		 try {
//			 String sql ="delete from users where id = ?";
//			 pstmt = conn.prepareStatement(sql);
//			 pstmt.setString(1, checkUserId);
//			 rs =pstmt.executeQuery();
//			 System.out.println("�����Ϸ�");
//			 
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	 }
	
	 public int selectUsers(String checkUserId,String checkUserpw) {// sql���� �ҷ��ͼ� ���̵� �ߺ�ó�� �� ���������� �� ��  
		 conn=getConnection();
		 
		 UserDTO getSqlUser ;
		 String sql ="select * from users where id = ?";
		 pstmt = null;
		 
		 try {
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, checkUserId);
			 rs =pstmt.executeQuery(); //��ü ����� ���
			 
			 while(rs.next()) {
				 String id =rs.getString(1);
				 String pw =rs.getString(2);
				 String name =rs.getString(3);
				 Timestamp birthdate =rs.getTimestamp(4);
				 int gender =rs.getInt(5);
				 String email =rs.getString(6);
				 String nation =rs.getString(7);
				 String mobile =rs.getString(8);
				 
				 
				 System.out.println(checkUserId);
				 getSqlUser = new UserDTO(id,pw,name,birthdate.getYear(),birthdate.getMonth()+1,birthdate.getDay(),gender,email,nation,mobile);
				 System.out.println(getSqlUser.getId());
				 if(checkUserId.equals(getSqlUser.getId())&&checkUserpw.equals(getSqlUser.getPw())) {
					 return 1;
				 }
			 }
			 
			 return -1;
			 
			 
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
	 }

}
