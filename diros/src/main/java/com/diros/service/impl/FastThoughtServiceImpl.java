package com.diros.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.diros.mapper.CommentsMapper;
import com.diros.mapper.FastThoughtMapper;
import com.diros.model.FastThought;
import com.diros.service.FastThoughtService;
import com.diros.util.ServiceImpl;
@Scope("prototype")
@Service
public class FastThoughtServiceImpl extends ServiceImpl<FastThought> implements FastThoughtService{

	@Autowired
	public void setMapper(FastThoughtMapper fastThoughtMapper) {
		this.mapper = fastThoughtMapper;
	}
	@Override
	public List<FastThought> getAllPost() throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

	@Override
	public int reply(FastThought fastThought) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FastThought> getByPost(int postId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
