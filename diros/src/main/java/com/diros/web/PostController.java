package com.diros.web;



import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.diros.model.Comments;
import com.diros.model.Forum;
import com.diros.model.Post;
import com.diros.service.CommentsService;
import com.diros.service.PostService;
import com.diros.util.TimeConvert;
import com.diros.util.TotalAction;

@Controller
@RequestMapping("/post")   
public class PostController extends TotalAction{
	
	@Resource
	private PostService postService;
	@Resource
	private CommentsService commentsService;
	
	private Post post;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)   
	public String getAllNews(ModelMap map,HttpServletRequest request,HttpServletResponse response
			){
		System.out.println("***********getAllPost********");
		List<Post> postList=null;
		try {
			postList= postService.selectAll();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("postList",postList);
		 return "/hiDiros";
	}
	@RequestMapping(value="/findById",method =RequestMethod.POST)
	public String getPost(@RequestParam(value="postId")int postId)
	{
		try {
			Post p=postService.findById(postId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	@RequestMapping(value="/newTopic", method = RequestMethod.POST)
	public String inputEditor(Post post/*@RequestParam(value="forum")Forum forum,@RequestParam(value="postContent")String postContent*/)
	{
		
		post.setCreateDt(TimeConvert.timeToString(new Date()));
//		post.setCreateUser(1);
//		post.setForumId(1);
		
		
		try {
			postService.add(post);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value="/Reply", method = RequestMethod.GET)
	public @ResponseBody Comments replyPost(@RequestParam(value="postId")int postId,@RequestParam(value="postContent")String postContent)
	{
		Comments comments=new Comments();
		
		try {
		String content=new String(postContent.getBytes("iso-8859-1"),"utf-8");
		
		comments.setCreateDt(TimeConvert.timeToString(new Date()));
		comments.setPostId(postId);
//		comments.setUserId(1);
		comments.setContent(content);
		
		commentsService.add(comments);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comments;
	}
	
	@RequestMapping(value="/favourite", method = RequestMethod.GET)
	public String findFavouritePost(@RequestParam(value="userId")int userId)
	{
		
		return null;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	
}
