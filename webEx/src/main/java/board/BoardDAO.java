package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import webEx.UserDTO;
import util.DBManager;

public class BoardDAO {
	
	private BoardDAO() {}
	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	private Random ran = new Random();
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public Map getMap() {
		Map<Integer, BoardDTO> boardData = new HashMap<>();

		conn = DBManager.getConnection("firstJsp");
		String sql = "select * from board";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int no, code, viewCnt, likeCnt;
			Date date = new Date();
			Timestamp createdAt = new Timestamp(date.getDate());
			Timestamp modifiedAt = new Timestamp(date.getDate());
			String title, content;

			while (rs.next()) {
				no = rs.getInt(1);
				code = rs.getInt(2);
				title = rs.getString(3);
				content = rs.getString(4);
				viewCnt = rs.getInt(5);
				likeCnt = rs.getInt(6);
				createdAt = rs.getTimestamp(7);
				modifiedAt = rs.getTimestamp(8);

				BoardDTO bd = new BoardDTO(no, code, title, content, viewCnt, likeCnt, createdAt, modifiedAt);
				boardData.put(no, bd);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardData;
	}

	public int getMapSize() {
		return getMap().size();
	}

	// �Խñ��� PK�� �������� 4�� ��ȯ���ִ� �޼ҵ�
	public int getRanNum() { // = primary key code 
		Random ran = new Random();

		Map<Integer, BoardDTO> temp = getMap();
		Object[] keySet = temp.keySet().toArray();

		while (true) {
			int r = ran.nextInt(8999) + 1000;
			boolean check = true;

			for (Object k : keySet) {
				if (temp.get(k).getCode() == r)
					check = false;
			}
			if (check)
				return r;
		}
	}

	// �Խñ� �߰� �޼ҵ�
	public boolean addBoard(BoardDTO bDTO) {
		conn = DBManager.getConnection("firstJsp");

		try {
			String sql = "insert into board(no, code, title, content, viewCnt, likeCnt)values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bDTO.getNo());
			pstmt.setInt(2, bDTO.getCode());
			pstmt.setString(3, bDTO.getTitle());
			pstmt.setString(4, bDTO.getContent());
			pstmt.setInt(5, bDTO.getViewCnt());
			pstmt.setInt(6, bDTO.getLikeCnt());
			pstmt.execute();
			System.out.println("�۾��� ����");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�۾��� ����");
			return false;
		} finally {
			try {
				conn.close();
				pstmt.close();
				System.out.println("finally done!");
			} catch (Exception e2) {
			}
		}
	}
	
	// setBoard() �޼ҵ� ���� ���� �� : �ۼ��� �Խñ� �������ִ� �޼ҵ�
//	public boolean setBoard(BoardDTO bDTO) {
//		conn = DBManager.getConnection("firstJsp");
//		try {
//			String sql = "update board set content = '���� �� ����' where  title = '��� ������'";
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
}
