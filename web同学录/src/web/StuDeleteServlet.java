package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StuDao;
import entity.Stu;

public class StuDeleteServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id = request.getParameter("id");
	int  eId = Integer.parseInt(id);
	StuDao dao=new StuDao();
	int result=dao.deleteById(eId);
	//����ɾ���ɹ�����ʧ�ܣ�servlet�ض����б�����
	response.sendRedirect("stulist.html");
}
}
