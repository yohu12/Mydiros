package com.diros.service;

import java.util.List;

import com.diros.model.FastThought;
import com.diros.util.IService;

public interface FastThoughtService extends IService<FastThought>{

	/**
	 * 功能：登录验证
	 * @param user
	 * @return User
	 * @throws Exception
	 */
	public List<FastThought> getAllPost() throws Exception; 
	
	public int reply(FastThought fastThought) throws Exception;
	public List<FastThought> getByPost(int postId) throws Exception;
}
