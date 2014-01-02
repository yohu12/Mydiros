package com.diros.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.diros.mapper.NewsCommentMapper;
import com.diros.model.NewsComment;
import com.diros.service.NewsCommentService;
import com.diros.util.Imapper;
import com.diros.util.ServiceImpl;

@Scope("prototype")
@Service
public class NewsCommentServiceImpl extends ServiceImpl<NewsComment> implements NewsCommentService{

	@Autowired
	public void setMapper(NewsCommentMapper newsCommentMapper) {
		this.mapper = newsCommentMapper;
	}

	public List<NewsComment> selectByNewsId(int newsId) throws Exception{	
		return ((NewsCommentMapper)mapper).selectByNewsId(newsId);		
	}
	
	public List<NewsComment> selectByRootId(int rootId) throws Exception{	
		return ((NewsCommentMapper)mapper).selectByNewsId(rootId);		
	}
	
	
}
