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
			//���û�����Ϣ���浽session���������ʹ��
			HttpSession session=request.getSession();
			session.setAttribute("loginUser",e);//�ѵ�¼�ɹ����û���������Ϣ����session
			//��¼�ɹ���servlet�ض����б�����
			response.sendRedirect("emplist.html");
		}else{
			//��¼ʧ��,servletת����ʧ��ҳ
			request.setAttribute("msg", "��½ʧ�ܣ������µ�¼");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
}
