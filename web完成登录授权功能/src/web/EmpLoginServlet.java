package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmpDao;
import entity.Emp;

public class EmpLoginServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String empno=request.getParameter("empno");
		
		EmpDao dao=new EmpDao();
		Emp e=dao.selectOne(name, empno);
		if(e==null){
			//把用户名信息保存到session里，供过滤器使用
			HttpSession session=request.getSession();
			session.setAttribute("loginUser",e);//把登录成功的用户的所有信息交给session
			//登录成功，servlet重定向到列表请求
			response.sendRedirect("emplist.html");
		}else{
			//登录失败,servlet转发到失败页
			request.setAttribute("msg", "登陆失败，请重新登录");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
}
