package com.diros.service;

import java.util.List;

import com.diros.model.Comments;
import com.diros.util.IService;

public interface CommentsService extends IService<Comments> {
	
	/**
	 * 功能：登录验证
	 * @param user
	 * @return User
	 * @throws Exception
	 */
	public List<Comments> getAllPost() throws Exception; 
	
	public int reply(Comments comments) throws Exception;
	public List<Comments> getByPost(int postId) throws Exception;
}
