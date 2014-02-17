package com.diros.util;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.diros.model.Paging;

//singleton和prototype和分别为request、session和 global session
public abstract class ServiceImpl<T> implements IService<T> {

	public ApplicationContext ctx= new ClassPathXmlApplicationContext("beans.xml");
	
	protected Imapper<T> mapper;//变量mapper  

	@Override
	public int add(T t) throws Exception {
		return mapper.insert(t);
	}

	@Override
	public void delete(Integer id) throws Exception {
		mapper.delete(id);
	}

	@Override
	public void update(T t) throws Exception {
		mapper.update(t);
	}

	@Override
	public int count() throws Exception {
		return mapper.count();
	}

	@Override
	public List<T> selectPage(Paging p) throws Exception {
		return mapper.selectPage(p);
	}

	@Override
	public List<T> selectAll() throws Exception {
		return mapper.selectAll();
	}

	@Override
	public T findById(Integer id) throws Exception{
		return mapper.findById(id);
	}

	public void setMapper(Imapper<T> mapper) {
		this.mapper = mapper;
	}
	
}
