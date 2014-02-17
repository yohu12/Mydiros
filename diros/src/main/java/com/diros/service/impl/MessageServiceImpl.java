package com.diros.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.diros.mapper.MessageMapper;
import com.diros.mapper.PostMapper;
import com.diros.mapper.UserMapper;
import com.diros.model.Message;
import com.diros.model.Post;
import com.diros.model.User;
import com.diros.service.MessageService;
import com.diros.service.PostService;
import com.diros.service.UserService;
import com.diros.util.ServiceImpl;

@Scope("prototype")
@Service
public class MessageServiceImpl extends ServiceImpl<Message> implements MessageService  {
	

	@Autowired
	public void setMapper(MessageMapper messageMapper) {
		this.mapper = messageMapper;
	}
	@Override
	public List<Message> getAllMessages() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Message> findByReceiveUser(int userId) throws Exception {
		List<Message> messageList=((MessageMapper)mapper).findByReceiveUser(userId);
		return messageList;
	}
	@Override
	public List<Message> findBySendUser(int userId) throws Exception {
		List<Message> messageList=((MessageMapper)mapper).findBySendUser(userId);
		return messageList;
	}
	@Override
	public Message getMessageInfo(int messageId) throws Exception {
		Message message=((MessageMapper)mapper).getMessageInfo(messageId);
		return message;
	}

	
	
}
