package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StuDao;
import entity.Stu;

public class StuLoginServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String classes=request.getParameter("classes");
		StuDao dao = new StuDao();
		Stu e = dao.selectOne(name, classes);
		if(e == null){
			response.sendRedirect("stulist.html");

		}
		else{
			request.setAttribute("msg", "µÇÂ¼Ê§°Ü£¬ÇëÖØÐÂµÇÂ¼£¡");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
}
