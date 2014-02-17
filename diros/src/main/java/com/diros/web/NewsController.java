package com.diros.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.diros.model.News;
import com.diros.model.Paging;
import com.diros.service.NewsService;

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
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	public String selectAll(Paging paging,ModelMap map , HttpServletRequest request){
		
		try {
			if(paging==null){//第一次进入时为null
				paging = new Paging();
			}
			System.out.println(paging.toString());
			if(paging.getCurrPage()!=1){
				paging.setStartRow((paging.getCurrPage()-1)*paging.getCounts());//得到开始行
			}else{
				paging.setStartRow(0);
			}
			List<News> lists= newsService.selectPage(paging);
			
			for (News news : lists) {
				News news2 = news;
				news2.setContent(StringUtils.abbreviate(news.getContent(), 40));
			}
			
			System.out.println("分页结果"+lists);
			
			int AllCount = this.newsService.count();
			
			Integer count=(AllCount)%paging.getCounts();
			if(count==0){
				paging.setMaxPage((AllCount)/paging.getCounts());
			}else{
				paging.setMaxPage((AllCount)/paging.getCounts()+1);
			}
			paging.setNextPage(paging.getCurrPage()+1);
			paging.setPrePage(paging.getCurrPage()-1);
			paging.setAllCount(AllCount);
			
			
			map.put("paging", paging);
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
		}
		return "news/content";
	}
	
	@RequestMapping("new")
	public String addNews(){
		try {
			System.out.println("add");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/news/add";
	}
	
	@RequestMapping("add")
	public String insert(News news ,ModelMap map){
				
		try {
			int id = newsService.add(news);
			System.out.println(id);
			System.out.println("add");
			map.put("news", news);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/news/content";
	}
	
	@RequestMapping("edit/{id}")
	public String edit(@PathVariable("id") Integer id,ModelMap map){				
		try {
			News news= newsService.findById(id);
			System.out.println(id);
			System.out.println("add");
			map.put("news", news);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/news/edit";
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(News news ,ModelMap map){
				
		try {
			System.out.println(news);
			news.setState(1);
			 newsService.update(news);
			System.out.println("update");
			map.put("news",news);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/news/content";
	}
	
	
	
	
}
