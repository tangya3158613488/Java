package com.vvv.controller;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vvv.po.MessageCustome;
import com.vvv.po.User;
import com.vvv.service.UserService;
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	//获得用户列表(ajax)
	@RequestMapping("/showUser")
	public void showUser(HttpServletResponse response,User user) throws Exception {
		String html="";
		List list=userService.findAllUser();
		for (Object o : list) {
			User u=(User)o;
			html+="<div class='chat-user'>";
			if(u.getIsonline()==1){
				html+="<span class='pull-right label label-primary'>在线</span>";
			}
			html+="<img class='chat-avatar' src='img/a.jpg'>";
			html+="<div class='chat-user-name'>";
			html+="<a>"+u.getNickname()+"</a>";
			html+="</div>";
			html+="</div>";
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println(html);
	}
	//注册
	@RequestMapping("/reg")
	public void reg(HttpServletResponse response,User user) throws Exception {
		user.setIsonline(0);//注册默认不在线
		userService.insert(user);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<script>alert('注册成功！请登录后操作！');location='login.jsp';</script>");
	}
	//退出
	@RequestMapping("/logout")
	public void logout(HttpSession session,HttpServletResponse response) throws Exception {
		User u=(User)session.getAttribute("user");
		u.setIsonline(0);
		userService.update(u);
		session.invalidate();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<script>alert('您的账号已安全退出！');location='login.jsp';</script>");
	}
	//登录
	@RequestMapping("/login")
	public ModelAndView login(HttpSession session,HttpServletResponse response,String loginname,String loginpwd) throws Exception {
		User user=userService.login(loginname, loginpwd);
		if(user==null){
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>alert('账号或密码有误，请重新尝试！');location='login.jsp';</script>");
			return null;
		}else{
			//设定其在线
			user.setIsonline(1);
			userService.update(user);
			session.setAttribute("user", user);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("redirect:/chatroom.jsp");
			return modelAndView;
		}
	}
}
