package com.diros.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.diros.mapper.CommentsMapper;
import com.diros.model.Comments;
import com.diros.service.CommentsService;
import com.diros.util.ServiceImpl;

@Scope("prototype")
@Service
public class CommentsServiceImpl extends ServiceImpl<Comments> implements CommentsService  {

	
	@Autowired
	public void setMapper(CommentsMapper commentsMapper) {
		this.mapper = commentsMapper;
	}
	
	public List<Comments> getAllPost() throws Exception {
		 List<Comments> CommentsList=mapper.selectAll();
		 for (Comments comments:CommentsList) {
			 System.out.println("comments==="+comments);
		}		
		 return CommentsList;
	}
	public List<Comments> getByPost(int postId) throws Exception {
		 List<Comments> CommentsList=((CommentsMapper)mapper).selectByPost(postId);
		 	
		 return CommentsList;
	}
	public int reply(Comments comments) throws Exception {
		((CommentsMapper)mapper).reply(comments);
		return 0;
	}

//	@Override
//	public int replyComments(Comments comments) throws Exception {
//		((CommentsMapper)mapper).replyComments(comments);		
//		return 0;
//	}
//	
}
