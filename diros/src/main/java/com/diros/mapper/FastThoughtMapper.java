package com.diros.mapper;

import java.util.List;

import com.diros.model.Comments;
import com.diros.model.FastThought;
import com.diros.model.Message;
import com.diros.model.Post;
import com.diros.util.Imapper;

public interface FastThoughtMapper extends Imapper<FastThought>{
	public List<FastThought> getAllComments() throws Exception;	
	public int reply(FastThought comments) throws Exception;
	public List<FastThought> selectByPost(int postId) throws Exception;
	
}
