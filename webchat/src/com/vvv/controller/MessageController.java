package com.vvv.controller;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
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
import com.vvv.po.Message;
import com.vvv.po.MessageCustome;
import com.vvv.po.User;
import com.vvv.service.MessageService;
import com.vvv.service.UserService;
@Controller
public class MessageController {
	@Autowired
	private MessageService messageService;
	//发送消息
	@RequestMapping("/addMsg")
	public void addMsg(HttpSession session,String contents) throws Exception{
		System.out.println(contents);
		Message m=new Message();
		m.setCreatetime(new Date());
		User user=(User)session.getAttribute("user");
		m.setUserid(user.getId());
		m.setContents(contents);
		messageService.insert(m);
	}
	//获得消息列表(ajax)
	@RequestMapping("/showMsg")
	public void showMsg(HttpServletResponse response) throws Exception {
		String html="";
		List list=messageService.findAllMessage();
		//System.out.println(Arrays.toString(list.toArray()));
		for (Object o : list) {
			MessageCustome mc=(MessageCustome)o;
			html+="<div class='chat-message'>";
			html+="<img class='message-avatar' src='img/a.jpg'>";
			html+="<div class='message'>";
			html+="<a class='message-author'>"+mc.getUserNickName()+"</a>";
			html+="<span class='message-date'>"+mc.getCreatetime().toLocaleString()+"</span>";
			html+="<span class='message-content'>"+mc.getContents()+"</span>";
			html+="</div>";
			html+="</div>";
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println(html);
	}
}
