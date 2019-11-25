package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

public class EmpListServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDao dao=new EmpDao();
		String tmp=request.getParameter("current");
		int current;
		if(tmp == null){
			current=1;
		}else{
			current=Integer.parseInt(tmp);
		}
		ArrayList<Emp> list=dao.selectAll(current, 10);
		/*response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		for(Emp e:list){
			pw.print("员工id: "+e.getId()+" ");
			pw.print("员工姓名: "+e.getName()+" ");
			pw.print("员工手机: "+e.getPhone()+" ");
			pw.print("员工编号: "+e.getEmpNo()+" ");
			pw.print("员工年龄: "+e.getAge()+" ");
			pw.print("员工性别: "+e.getGender()+" ");
			pw.print("员工部门: "+e.getDeptNo()+" ");
			pw.println("<br>");//换行符
		}*/
		request.setAttribute("emps", list);
		request.getRequestDispatcher("listEmp.jsp").forward(request,response);
	}
}
