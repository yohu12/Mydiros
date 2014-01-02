package com.diros.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diros.model.News;
import com.diros.service.NewsService;
import com.diros.util.TotalAction;

/**
 * 
 * 类名：NewsController    
 * 功能：新闻控制器
 * @return：
 * @version：1.0 
 * author： tanbiao
 * @date：2013-7-31
 */
@Controller
@RequestMapping("news")
public class NewsController  {
	
	@Resource
	private NewsService newsService;
	
	@RequestMapping("list")
	public String selectAll(ModelMap map , HttpServletRequest request){
		
		try {
			List<News> lists = newsService.selectAll();
			map.put("lists", lists);
			System.out.println(map);			
		} catch (Exception e) {
			String string = e.getMessage();
			System.out.println(string);
		}		
		return "news/list";
	}
	/**
	 * 
	 * 功能：查找指定新闻的信息
	 * @return
	 * author tan
	 * date 2013-7-31
	 */
	@RequestMapping("/content/{newsId}")
	public String findByNewsId(@PathVariable("newsId") int id,ModelMap map){
		try {
			map.put("news", newsService.findById(id));
		} catch (Exception e) {
			e.printStackTrace();
		//	logger.debug(e.getMessage());
		}
		return "news/content";
	}
	
	@RequestMapping("add")
	public String insert(){
		try {
			//int id = newsService.add(news);
			//System.out.println(id);
			System.out.println("add");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/news/add";
	}
	
	
}
