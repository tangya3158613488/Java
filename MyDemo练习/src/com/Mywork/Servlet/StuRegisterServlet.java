package com.Mywork.Servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Mywork.model.DAO;
import com.Mywork.model.DbUtil;
import com.Mywork.model.Student;



/**
 * Servlet implementation class StuRegisterServlet
 */
@WebServlet("/StuRegister")
public class StuRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stuid = request.getParameter("stuId");
		String stupwd = request.getParameter("stuPwd");
		DbUtil db = new DbUtil();
		Student stu = new Student(stuid,stupwd);
		DAO dao = new DAO();
		try {
		Connection con = (Connection)db.getConnection();
		
			if(dao.regist(con, stu)){
				response.sendRedirect("stulogin.jsp");
			}
			else
			{
				response.sendRedirect("sturegister.jsp");
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
		doGet(request, response);
	}

}
