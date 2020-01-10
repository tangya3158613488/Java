package com.vvv.mapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.vvv.po.User;
public interface UserMapperCustome {
	public User login(HashMap map) throws Exception;
	public List findAllUser() throws Exception;
}
