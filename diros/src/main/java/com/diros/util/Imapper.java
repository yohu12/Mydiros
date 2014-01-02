package com.diros.util;

import java.util.List;

import com.diros.model.Paging;

public interface Imapper<T> {
	
	/**
	  * 公司：云南双翊
	  * 功能:公共添加方法
	  * @param t
	  * @throws Exception
	  * @author FB	
	  * 2013-3-20
	  */
	 int insert(T t) throws Exception;
	 
	 /**
	  * 
	  * 公司：云南双翊
	  * 功能:公共删除方法
	  * @param t
	  * @throws Exception
	  * @author FB	
	  * 2013-3-20
	  */
	 int delete(Integer id)throws Exception;
	 
	 /**
	  * 
	  * 公司：云南双翊
	  * 功能:公共修改方法
	  * @param t
	  * @throws Exception
	  * @author FB	
	  * 2013-3-20
	  */
	 int update(T t) throws Exception;
	 
	 /**
	  * 
	  * 公司：云南双翊
	  * 功能:查询总条数
	  * @return
	  * @throws Exception
	  * @author FB	
	  * 2013-3-20
	  */
	 int count() throws Exception;
	 
	 /**
	  * 
	  * 公司：云南双翊
	  * 功能:分页查询方法
	  * @param p
	  * @return
	  * @throws Exception
	  * @author FB	
	  * 2013-3-20
	  */
	 List<T> selectPage(Paging p) throws Exception;
	 
	 /**
	  * 
	  * 公司：云南双翊
	  * 功能:不分页总查询方法
	  * @return
	  * @throws Exception
	  * @author FB	
	  * 2013-3-20
	  */
	 List<T> selectAll() throws Exception;
	 /**
	  * 
	  * 公司：云南双翊
	  * 功能:通过id查询对象
	  * @param id
	  * @return
	  * @throws Exception
	  * @author FB	
	  * 2013-3-20
	  */
	 T findById(Integer id) throws Exception;
	
}
