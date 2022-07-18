package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webEx.UserDAO;
import webEx.UserDTO;

/**
 * Servlet implementation class JoinPro
 */
//@WebServlet("/JoinAction")
public class JoinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		UserDAO dao = UserDAO.getInstance();
		UserDTO user = null;

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String checkpw = request.getParameter("checkpw");
		String name = request.getParameter("name");
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		int day = Integer.parseInt(request.getParameter("day"));
		int gender = Integer.parseInt(request.getParameter("gender"));
		String email = request.getParameter("email");
		String nation = request.getParameter("nation");
		String mobile = request.getParameter("mobile");

		
		System.out.println("����� ���οɼ�");
		user = new UserDTO(id, pw, checkpw, name, year, month, day, gender, email, nation, mobile);
		String url = "";
		
			//ȸ�� ���� ���� 
			//login.jsp�� �������� �̵� 
			if(dao.insertUsers(user)){
			url = "_00.index.jsp";			
			}
			else{

			url = "_02.join.jsp";
			request.setAttribute("again",true);
			 }
		
		//1.�ܼ� �����̷�Ʈ
		// response.sendRedirect(url);
		//2. ���� ���������� ������ �� request & response ��ü�� �״�� ������������ ���� 
		//request.setAttribute("log", user.getId());    
		// request.getRequestDispatcher(url).forward(request, response);

		//3. ��Ĺ ������ Ȱ���� session �� �α� ���� �ֱ� 
		//session.setAttribute("log",user.getId());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
