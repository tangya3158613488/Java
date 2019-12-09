package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

public class EmpToEditServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		int eId=Integer.parseInt(id);
		
		EmpDao dao=new EmpDao();
		Emp e=dao.selectOne(eId);
		
		request.setAttribute("e", e);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

}
