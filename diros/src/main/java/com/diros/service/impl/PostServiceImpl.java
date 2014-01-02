package com.diros.service.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.diros.mapper.PostMapper;
import com.diros.mapper.UserMapper;
import com.diros.model.Post;
import com.diros.model.User;
import com.diros.service.PostService;
import com.diros.service.UserService;
import com.diros.util.ServiceImpl;

@Scope("prototype")
@Service
public class PostServiceImpl extends ServiceImpl<Post> implements PostService  {

	
	@Resource
	private PostMapper postMapper;
	@Autowired
	public void setMapper(PostMapper postMapper) {
		this.mapper = postMapper;
	}
	@Override
	public List<Post> getAllPost() throws Exception {
		 List<Post> postList=postMapper.selectAll();
				
		 return postList;
	}
	@Override
	public List<Post> findByUser(int userId) throws Exception {
		 List<Post> postList=postMapper.findByUser(userId);
				
		 return postList;
	}
	
	@Override
	public int findPostCollectionUser(int postId) throws Exception {
		 int postCollection=postMapper.findPostCollection(postId);
		 		
		 return postCollection;
	}
	@Override
	public List<Post> findByFavouriteUser(Map<String, Object> map) throws Exception {
		List<Post> postList=postMapper.findByFavouriteUser(map);
		
		 return postList;
	}
}
