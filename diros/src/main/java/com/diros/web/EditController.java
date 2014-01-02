package com.diros.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import com.diros.model.EditData;
import com.diros.model.News;
import com.diros.service.NewsService;
import com.diros.util.TotalAction;

@Controller
@RequestMapping("/edit")
public class EditController extends TotalAction {
	
	@Resource
	private NewsService newsService;
	
	@RequestMapping("/add")
	public String edit(EditData post ,ModelMap map){
		
		System.out.println("***"+post);
		
		System.out.println(post.getForum() ==1);
		
		if(post !=null && post.getForum()==1){
			News news = new News();			
			news.setContent(post.getContext());
			news.setTitle(post.getTitle());		
			
			System.out.println(news);
			try {
				int id = newsService.add(news);
				return "redirect:/news/list";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
				
		map.put("post", post);
		
		return "/textarea";
	}
	
}
