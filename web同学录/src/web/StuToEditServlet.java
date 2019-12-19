package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StuDao;
import entity.Stu;

public class StuToEditServlet extends HttpServlet{
@Override
protected void service(HttpServletRequest resquest, HttpServletResponse response) throws ServletException, IOException {

	String id = resquest.getParameter("id");
	int eId = Integer.parseInt(id);
	
	StuDao dao = new StuDao();
	Stu e = dao.selectOne(eId);
	resquest.setAttribute("e", e);
	resquest.getRequestDispatcher("edit.jsp").forward(resquest, response);
	
	
	
	}
}
