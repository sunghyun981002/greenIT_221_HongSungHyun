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
 * Servlet implementation class LoginAction
 */
//@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//doGet() 메소드 : reauest method - GET
		UserDAO dao = UserDAO.getInstance();
		UserDTO user = null;

		request.setCharacterEncoding("utf-8");


		String id = request.getParameter("id");
		String pw = request.getParameter("pw");


		String url="";


		if(dao.selectUsers(id,pw) == 1){
			url = "_04.main.jsp";
//			url ="./board";
//			session.setAttribute("log", id);
		}
		else{
			url="_00.index.jsp";
			request.setAttribute("again",true);
		}
		
		//페이지이동처리 
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request, response);
		
		
		//doGet() 메소드 : reauest method - GET
	}

}
