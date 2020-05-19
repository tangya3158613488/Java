package com.Demo1.Servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Demo1.model.DAO;
import com.Demo1.model.DbUtil;
import com.Demo1.model.User;

/**
 * Servlet implementation class Registservlet
 */
@WebServlet("/Regist")
public class Registservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uName = request.getParameter("username");
		String uPwd = request.getParameter("userpwd");
		DbUtil db = new DbUtil();
		User user = new User(uName,uPwd);
		DAO dao = new DAO();
		try {
		Connection con = (Connection)db.getConnection();
		
			if(dao.regist(con, user)){
				response.sendRedirect("login.jsp");
			}
			else
			{
				response.sendRedirect("regist.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
