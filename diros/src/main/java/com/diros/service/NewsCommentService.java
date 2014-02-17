package com.diros.service;

import java.util.List;

import com.diros.model.NewsComment;
import com.diros.util.IService;

public interface NewsCommentService extends IService<NewsComment> {
	
	/**
	 * 
	 * 功能：根据newsId查找
	 * @param newsId
	 * @return
	 * @throws Exception
	 * author tan
	 * date 2013-7-31
	 */
	public List<NewsComment> selectByNewsId(int newsId) throws Exception;
	/**
	 * 
	 * 功能：根据rootId查找
	 * @param rootId
	 * @return
	 * @throws Exception
	 * author tan
	 * date 2013-7-31
	 */
	public List<NewsComment> selectByRootId(int rootId) throws Exception;
	
}
