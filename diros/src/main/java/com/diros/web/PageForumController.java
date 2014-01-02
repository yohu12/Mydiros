package com.diros.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.diros.model.Comments;
import com.diros.model.Post;
import com.diros.service.CommentsService;
import com.diros.service.PostService;
import com.diros.util.TotalAction;
@Controller
@RequestMapping("/pageForum") 
public class PageForumController extends TotalAction{
	
	@Resource
	private PostService postService;
	@Resource
	private CommentsService commentsService;
	
	@RequestMapping(value = "/showPost", method = RequestMethod.GET)   
	public String getPageInfo(@RequestParam("postId") int postId, ModelMap map, HttpServletRequest request,HttpServletResponse response){
		int comentCount=0;
		try {
			Post post=postService.findById(postId);
			List<Comments> commentsList=commentsService.getByPost(postId);
			if (commentsList!=null) {
				comentCount=commentsList.size();
			}
			
			request.setAttribute("commentsList", commentsList);
			request.setAttribute("post",post);
			request.setAttribute("comentCount",comentCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "showPost";
		
	}
}
