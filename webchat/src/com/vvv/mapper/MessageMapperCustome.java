package com.vvv.mapper;
import com.vvv.po.Message;
import com.vvv.po.MessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
public interface MessageMapperCustome {
	public List<Message> findAllMessage() throws Exception;
}