package com.diros.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.diros.mapper.ForumMapper;
import com.diros.model.Forum;
import com.diros.service.ForumService;
import com.diros.util.Imapper;
import com.diros.util.ServiceImpl;
@Scope("prototype")
@Service
public class ForumServiceImpl extends  ServiceImpl<Forum> implements ForumService {
	
	@Autowired
	public void setMapper(ForumMapper forumMapper) {
		this.mapper = forumMapper;
	}

}
