package com.vvv.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.vvv.mapper.UserMapper;
import com.vvv.mapper.UserMapperCustome;
import com.vvv.po.Message;
import com.vvv.po.User;
import com.vvv.service.MessageService;
import com.vvv.service.UserService;
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserMapperCustome userMapperCustome;
	public void delete(int id) throws Exception {
		userMapper.deleteByPrimaryKey(id);
	}
	public void insert(User user) throws Exception {
		userMapper.insert(user);
	}
	public User selectById(int id) throws Exception {
		return null;
	}
	public void update(User user) throws Exception {
		userMapper.updateByPrimaryKey(user);
	}
	public User login(String loginname, String loginpwd) throws Exception {
		//这里使用了Map作为输入参数，也可以直接po做参数
		HashMap map=new HashMap();
		map.put("loginname", loginname);
		map.put("loginpwd", loginpwd);
		return userMapperCustome.login(map);
	}
	public List findAllUser() throws Exception {
		return userMapperCustome.findAllUser();
	}
}
