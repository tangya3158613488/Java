package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StuDao;
import entity.Stu;

public class StuListServlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StuDao dao = new StuDao();
		
		
		String tmp = request.getParameter("current");
		int current;
		if(tmp==null){
			current = 1;
		}
		else{
			current = Integer.parseInt(tmp);
		}
		ArrayList<Stu> list = dao.selectAll(current, 2);
	
		
		
		
		//携带数据key----value
		request.setAttribute("stus", list);
		request.getRequestDispatcher("listStu.jsp").forward(request, response);
		//转发listEmp.jsp文件
		
		
		
	/*	
		response.setContentType("text/html;charset=utf-8");
		//修改字符集
		
		PrintWriter pw = response.getWriter();
		for(Emp e:list){
			pw.print("员工id "+e.getId()+" ");
			pw.print("姓名name "+e.getName()+" ");
			pw.print("gender "+e.getGender()+" ");
			pw.print("电话phone "+e.getPhone()+" ");
			pw.print("编码empno "+e.getEmpNo()+" ");
			pw.print("部门dpetno "+e.getDeptNo()+" ");
			pw.print("年龄age "+e.getAge());
			
			pw.println("<br>");
		}
	}
	
	*/
	}	
}
