package com.diros.mapper;

import java.util.List;

import com.diros.model.Message;
import com.diros.model.Post;
import com.diros.util.Imapper;

public interface MessageMapper extends Imapper<Message>{
	public List<Message> getAllMessages() throws Exception;	
	public List<Message> findByReceiveUser(int userId) throws Exception;
	public List<Message> findBySendUser(int userId) throws Exception;
	public Message getMessageInfo(int messageId) throws Exception;
}
