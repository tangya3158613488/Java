package com.Demo1.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Demo1.model.Chufang;
import com.Demo1.model.DAO;
import com.Demo1.model.Doctor;

/**
 * Servlet implementation class DoctorQuery
 */
@WebServlet("/doctor")
public class DoctorQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//�����û���������ƴ����
		String pym = request.getParameter("pym");
		//����ƴ�����ҵ�ҽ������Ϣ
		DAO doctorDao = new DAO();
		try {
			Doctor doc = doctorDao.findByPym(pym);
			if(doc == null){  //δ�ҵ�
				response.sendRedirect("select.jsp");
			}else{
				int docid = doc.getID();//�ҵ�ҽ����id
				DAO chufang = new DAO();
				List<Chufang> clist = chufang.findByDoctorId(docid);//����ҽ����id�ҵ�����
				
				request.setAttribute("doctor", doc);
				request.setAttribute("clist", clist);
				request.getRequestDispatcher("/select.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
