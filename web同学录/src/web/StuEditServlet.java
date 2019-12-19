package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StuDao;
import entity.Stu;

public class StuEditServlet extends HttpServlet{
@Override
protected void service(HttpServletRequest resquest, HttpServletResponse response) throws ServletException, IOException {
	String id = resquest.getParameter("id");
	String name = resquest.getParameter("name");
	String gender = resquest.getParameter("gender");
	String birth = resquest.getParameter("birth");
	String classes = resquest.getParameter("classes");
	String phone = resquest.getParameter("phone");
	String qq = resquest.getParameter("qq");
	String address = resquest.getParameter("address");
	String message = resquest.getParameter("message");
	
	int eId = Integer.parseInt(id);
	
	Stu e = new Stu(eId,name,gender,birth,classes,phone,qq,address,message);
	
	StuDao dao = new StuDao();
	int result = dao.updateById(e);
	response.sendRedirect("stulist.html");
}
	
}
