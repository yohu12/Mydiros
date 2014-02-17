package com.diros.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.diros.model.NewsComment;
import com.diros.util.Imapper;

public interface NewsCommentMapper extends Imapper<NewsComment> {
	
	List<NewsComment> selectByNewsId(@Param("newsId") int newsId) throws Exception;
	
	List<NewsComment> selectByRootId(@Param("rootId") int rootId) throws Exception;
	
	
	
}
