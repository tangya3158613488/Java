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
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Login")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("username");
		String upwd = request.getParameter("userpwd");
		DbUtil db = new DbUtil();
		User user = new User(uname,upwd);
		DAO dao = new DAO();
		
		Connection con = (Connection)db.getConnection();
		try {
			if(dao.login(con, user)!= null){
				response.sendRedirect("welcome.jsp");
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
