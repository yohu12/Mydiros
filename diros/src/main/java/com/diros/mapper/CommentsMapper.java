package com.diros.mapper;

import java.util.List;

import com.diros.model.Comments;
import com.diros.model.Message;
import com.diros.model.Post;
import com.diros.util.Imapper;

public interface CommentsMapper extends Imapper<Comments>{
	public List<Comments> getAllComments() throws Exception;	
	public int reply(Comments comments) throws Exception;
	public List<Comments> selectByPost(int postId) throws Exception;
	
}
