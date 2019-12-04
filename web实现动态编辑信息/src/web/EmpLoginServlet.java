package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

public class EmpLoginServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String empno=request.getParameter("empno");
		
		EmpDao dao=new EmpDao();
		Emp e=dao.selectOne(name, empno);
		if(e==null){
			request.setAttribute("msg", "”√ªß√˚√‹¬Î¥ÌŒÛ");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}else{
			response.sendRedirect("emplist.html");
		}
	}
}
