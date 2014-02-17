package com.diros.service;

import java.util.List;
import java.util.Map;

import com.diros.model.Post;
import com.diros.model.User;
import com.diros.util.IService;

public interface PostService extends IService<Post> {
	
	/**
	 * 功能：登录验证
	 * @param user
	 * @return User
	 * @throws Exception
	 */
	public List<Post> getAllPost() throws Exception; 
	
	public List<Post> findByUser(int userId)	throws Exception;
	public List<Post> findByFavouriteUser(Map<String, Object> map)	throws Exception;
	public int findPostCollectionUser(int postId) throws Exception;
}
