/*package com.diros.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.type.JdbcType;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diros.model.Comments;
import com.diros.model.Post;
import com.diros.model.User;
import com.diros.service.CommentsService;
import com.diros.service.PostService;
import com.diros.service.impl.CommentsServiceImpl;
import com.diros.util.TimeConvert;

public class TestCommentsTable {
	
	@Resource
	private CommentsServiceImpl commentsService;
	public ApplicationContext ctx= new ClassPathXmlApplicationContext("beans.xml");
	@BeforeClass
	public static void beforeClass()
	{
		
	}
	
	@Test
	public void testInsertIntoPost(){
		System.out.println("***********getAllNews********");
		
		
		try {
			commentsService=(CommentsServiceImpl) ctx.getBean(CommentsService.class);
			Comments comments=new Comments();

			comments.setContent("这是关于mysql 乱码的测试!");
			comments.setCreateDt(TimeConvert.timeToString(new Date()));
			comments.setfId(0);
			comments.setPostId(29);
			User u=new User();
			u.setUserId(1);
			comments.setUser(u);

			commentsService.add(comments);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getAllComments()
	{
		try {
			commentsService=(CommentsServiceImpl) ctx.getBean(CommentsServiceImpl.class);
			List<Comments> commentsPost=new ArrayList<Comments>();
			
			commentsPost=commentsService.getByPost(16);
			for (Comments comments:commentsPost) {
				System.out.println(comments.toString());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	@Test
//	public void updatePost()
//	{
//		postService=(PostService) ctx.getBean(PostService.class);
//		Post post=new Post();
//
//		post.setPostId(3);
//		post.setForumId(1);
//		post.setCreateDt("2012-1-1");
//		post.setCreateUser(1);
//		post.setLostMdyDt("2012-1-1");
//		post.setPostContent("Hello word");
//		post.setPostTitle("This is a test");
//		
//		
//		try {
//			postService.update(post);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test
//	public void getPostById()
//	{
//		postService=(PostService) ctx.getBean(PostService.class);
//		try {
//			Post post=postService.findById(6);
//			System.out.println(post);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void testReplyPost()
	{
		commentsService=(CommentsServiceImpl) ctx.getBean(CommentsServiceImpl.class);
		Comments comments=new Comments();

		comments.setContent("这篇文章写得不错111");
		comments.setCreateDt(TimeConvert.timeToString(new Date()));
		comments.setfId(0);
		comments.setPostId(8);

		User u=new User();
		u.setUserId(1);
		
		comments.setUser(u);

		try {
			commentsService.reply(comments);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testReplyComments()
	{
		commentsService=(CommentsServiceImpl) ctx.getBean(CommentsServiceImpl.class);
		
		List<Comments> commentsList = null;
		try {
			commentsList = commentsService.selectAll();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Comments comments=new Comments();

		comments.setContent("Test! Greate!!!");
		comments.setCreateDt(TimeConvert.timeToString(new Date()));
		comments.setfId(commentsList.get(0).getContentId());
		comments.setPostId(commentsList.get(0).getPostId());
		User u=new User();
		u.setUserId(1);
		comments.setUser(u);

		try {
			commentsService.reply(comments);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	@Test
//	public void testForumPage()
//	{
//		ForumPage f=new ForumPage(6);
//		int count=1;
//		System.out.println("Title:"+f.getPost().getPostTitle());
//		System.out.println("content:"+f.getPost().getPostContent());
//		for(Comments c:f.getCommentsList())
//		{
//			
//			System.out.println("第"+count+++"条回复："+ c.getContent());
//			System.out.println();
//		}
//	}
}
*/