package com.diros.mapper;

import java.util.List;
import java.util.Map;

import com.diros.model.Post;
import com.diros.util.Imapper;

public interface PostMapper extends Imapper<Post>{
	public List<Post> getAllPost() throws Exception;	
	public List<Post> findByUser(int userId)	throws Exception;
	public List<Post> findByFavouriteUser(Map<String, Object> map)	throws Exception;
	public int findPostCollection(int postId) throws Exception;
}
