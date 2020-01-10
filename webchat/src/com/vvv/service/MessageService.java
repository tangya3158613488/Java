package com.vvv.service;
import java.util.List;
import com.vvv.po.Message;
public interface MessageService {
	public void insert(Message message) throws Exception;
	public void update(Message message) throws Exception;
	public void delete(int id) throws Exception;
	public Message selectById(int id) throws Exception;
	public List findAllMessage() throws Exception;
}
