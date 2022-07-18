package user;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


import util.DBManager;

public class UserDAO {

	private UserDAO() {
	}

	private static UserDAO instance = new UserDAO();

	public static UserDAO getInstance() {
		return instance;
	}

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	
	// 회원추가
		public boolean addUser(UserDTO dto) {
			
				try {
					conn = DBManager.getConnection();
					String sql = "insert into users(custno,custname,phone,address,joindate,grade,city) values(?,?,?,?,'20220718','C',?)";
					int custno = getCustno();
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, custno);
					pstmt.setString(2, dto.getCustname());
					pstmt.setString(3, dto.getPhone());
					pstmt.setString(4, dto.getAddress());
					pstmt.setString(5, dto.getCity());
			
					boolean result = pstmt.execute();

					System.out.println("회원가입 성공 DB");
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("회원가입 실패 DB");
				}
			
			return false;
		}
		
		public int getCustno() {
			int custno =0;
			custno ++;
			System.out.println(custno);
			return custno;
			
		}
		public String getJoindate() {
			Date today = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			String result = df.format(today);
			System.out.println(result);
			return result;
		}
		
		
		public ArrayList<UserDTO> getAllrow(){
			try {
				conn = DBManager.getConnection();
				String sql = "select * from users";
				pstmt = conn.prepareStatement(sql); 
				rs = pstmt.executeQuery();
				ArrayList<UserDTO> arrList = new ArrayList<>();
				while(rs.next()) {
					UserDTO dto = new UserDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				
					arrList.add(dto);
					System.out.println(dto.getCustname());
					
				}
				return arrList;
				
			} catch (Exception e) {
				e.printStackTrace();
				return null; 
			}
		}
		
		
}
