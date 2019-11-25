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
			pw.print("Ա��id: "+e.getId()+" ");
			pw.print("Ա������: "+e.getName()+" ");
			pw.print("Ա���ֻ�: "+e.getPhone()+" ");
			pw.print("Ա�����: "+e.getEmpNo()+" ");
			pw.print("Ա������: "+e.getAge()+" ");
			pw.print("Ա���Ա�: "+e.getGender()+" ");
			pw.print("Ա������: "+e.getDeptNo()+" ");
			pw.println("<br>");//���з�
		}*/
		request.setAttribute("emps", list);
		request.getRequestDispatcher("listEmp.jsp").forward(request,response);
	}
}
