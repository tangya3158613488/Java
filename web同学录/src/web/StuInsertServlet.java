package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StuDao;
import entity.Stu;

public class StuInsertServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest resquest, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(resquest, response);
	}
	@Override
	public void doPost(HttpServletRequest resquest, HttpServletResponse response) throws ServletException, IOException {
		//String id = resquest.getParameter("id");
		String name = resquest.getParameter("name");
		String gender = resquest.getParameter("gender");
		String birth = resquest.getParameter("birth");
		String classes = resquest.getParameter("classes");
		String phone = resquest.getParameter("phone");
		String qq = resquest.getParameter("qq");
		String address = resquest.getParameter("address");
		String message = resquest.getParameter("message");
		
		//int eId = Integer.parseInt(id);
		
		Stu stu = new Stu();
	//	stu.setId(eId);
		stu.setName(new String(name.getBytes("IOS-8859-1"),"UTF-8"));
		stu.setGender(new String(gender.getBytes("IOS-8859-1"),"UTF-8"));
		stu.setBirth(new String(birth.getBytes("IOS-8859-1"),"UTF-8"));
		stu.setClasses(new String(classes.getBytes("IOS-8859-1"),"UTF-8"));
		stu.setPhone(new String(phone.getBytes("IOS-8859-1"),"UTF-8"));
		stu.setQq(new String(qq.getBytes("IOS-8859-1"),"UTF-8"));
		stu.setAddress(new String(address.getBytes("IOS-8859-1"),"UTF-8"));
		stu.setMessage(new String(message.getBytes("IOS-8859-1"),"UTF-8"));
		
		StuDao dao = new StuDao();
		dao.insertInto(stu);
		resquest.getRequestDispatcher("StuToInsertServlet").forward(resquest, response);
		
		
		
	}
}
