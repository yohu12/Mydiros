package com.diros.service;

import java.util.List;

import com.diros.model.Message;
import com.diros.model.Post;
import com.diros.model.User;
import com.diros.util.IService;

public interface MessageService extends IService<Message> {
	
	/**
	 * 功能：登录验证
	 * @param user
	 * @return User
	 * @throws Exception
	 */
	public List<Message> getAllMessages() throws Exception; 
	
	public List<Message> findByReceiveUser(int userId) throws Exception;
	public List<Message> findBySendUser(int userId) throws Exception;
	public Message getMessageInfo(int messageId) throws Exception;
}
