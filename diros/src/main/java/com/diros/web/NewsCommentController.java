package com.diros.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.diros.model.NewsComment;
import com.diros.service.NewsCommentService;
import com.diros.util.TotalAction;

@Controller
@RequestMapping("/newCom")
public class NewsCommentController extends TotalAction {
	
	@Resource
	private NewsCommentService newsCommentService;
	
	/**
	 * 
	 * 功能：查找相关新闻的评论信息，暂未实现分页
	 * @param newsId
	 * @return
	 * author tan
	 * date 2013-7-31
	 */
	@RequestMapping(value="/comment/{newsId}" ,method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findByNewsId(@PathVariable("newsId") String newsId ,ModelMap map){
		try {
			
			System.out.println("newsId = "+newsId);
			
			List<NewsComment> lists = newsCommentService.selectByNewsId(1);
			System.out.println(lists);
			map.put("lists", lists);
			map.put(RESULT_CODE, "success");
		} catch (Exception e) {
			e.printStackTrace();
			map.put(RESULT_MSG, "发生异常");
			map.put(RESULT_CODE, "fail");
		}
		return map;
	}
	
	/**
	 * 
	 * 功能：增加评论
	 * @return
	 * author tan
	 * date 2013-7-31
	 */
	@RequestMapping("/add")
	public String  insert(NewsComment newsComment){
		try {
			newsCommentService.add(newsComment);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
		}
		return "";
	}
	
	/**
	 * 
	 * 功能：
	 * @return
	 * author tan
	 * date 2013-7-31
	 */
	@RequestMapping(value="/comment/{rootId}" ,method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findByRootId(@PathVariable("rootId") String rootId ,ModelMap map){
		return map;
	}
}
