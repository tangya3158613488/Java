package com.vvv.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vvv.mapper.MessageMapper;
import com.vvv.mapper.MessageMapperCustome;
import com.vvv.mapper.UserMapper;
import com.vvv.po.Message;
import com.vvv.po.MessageExample;
import com.vvv.service.MessageService;
public class MessageServiceImpl implements MessageService{
	@Autowired
	private MessageMapper messageMapper;
	@Autowired
	private MessageMapperCustome messageMapperCustome;
	public void delete(int id) throws Exception {
		
	}
	public void insert(Message message) throws Exception {
		messageMapper.insert(message);
	}
	public Message selectById(int id) throws Exception {
		return null;
	}
	public void update(Message message) throws Exception {
		
	}
	@Override
	public List findAllMessage() throws Exception {
		return messageMapperCustome.findAllMessage();
	}
}
