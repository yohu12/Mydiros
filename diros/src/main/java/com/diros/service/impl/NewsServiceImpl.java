package com.diros.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.diros.mapper.NewsMapper;
import com.diros.model.News;
import com.diros.service.NewsService;
import com.diros.util.Imapper;
import com.diros.util.ServiceImpl;

@Scope("prototype")
@Service
public class NewsServiceImpl extends ServiceImpl<News> implements NewsService {


	@Autowired
	public void setMapper(NewsMapper newsMapper) {
		this.mapper = newsMapper;
	}

	

}
