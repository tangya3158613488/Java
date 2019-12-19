package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StuDao;
import entity.Stu;

public class StuSelectServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String classes=request.getParameter("classes");
		StuDao dao = new StuDao();
		Stu e = dao.selectOne(name, classes);
		
		
		
		if(e == null){
			request.setAttribute("e", e);
			request.getRequestDispatcher("listStu.jsp").forward(request, response);
		}
		else{
			request.setAttribute("msg", "没有该同学的信息");
			
		}
		
		
	
	}
}
