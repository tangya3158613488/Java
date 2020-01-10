package com.vvv.service;
import java.util.List;
import com.vvv.po.User;
public interface UserService {
	public void insert(User user) throws Exception;
	public void update(User user) throws Exception;
	public void delete(int id) throws Exception;
	public User selectById(int id) throws Exception;
	public User login(String loginname,String loginpwd) throws Exception;
	public List findAllUser() throws Exception;
}
