package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FilterLogin implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse reponse=(HttpServletResponse)arg1;
		
		String uri=request.getRequestURI();//��ȡ�����ַ
		System.out.println(uri);
		if("/web2/login.html".equals(uri) || "/web2/emplogin.html".equals(uri)){
			//����
			chain.doFilter(arg0,arg1);
			return;
		}
		
		//�ж��Ƿ���֤��
		HttpSession session=request.getSession();
		Object o=session.getAttribute("loginUser");
		if(o==null){
			//����
			chain.doFilter(arg0,arg1);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
