package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StuDao;
import entity.Stu;

public class StuToInsertServlet extends HttpServlet {
	protected void doGet(HttpServletRequest resquest, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(resquest, response);
	}
	
	public void doPost(HttpServletRequest resquest, HttpServletResponse response) throws ServletException, IOException {
		StuDao dao = new StuDao();
		ArrayList<Stu> list = dao.selectAll();
		resquest.setAttribute("list", list);
		resquest.getRequestDispatcher("stulist.html").forward(resquest, response);
	}
}
