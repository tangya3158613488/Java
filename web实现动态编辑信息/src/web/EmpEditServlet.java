package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

public class EmpEditServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String gender=request.getParameter("gender");
		String empNo=request.getParameter("empNo");
		String phone=request.getParameter("phone");
		
		int eId=Integer.parseInt(id);
		int eAge=Integer.parseInt(age);
		//int id, String name, String gender,String phone, String empNo, int age
		Emp e=new Emp(eId,name,gender,phone,empNo,eAge);
		
		EmpDao dao=new EmpDao();
		int result=dao.updateById(e);
		response.sendRedirect("emplist.html");
	}
}
