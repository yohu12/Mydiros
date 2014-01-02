package com.diros.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.type.JdbcType;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;


import com.diros.model.Forum;
import com.diros.model.Post;
import com.diros.model.User;
import com.diros.service.PostService;

public class TestPostTable {
	
	@Resource
	private PostService postService;
	public ApplicationContext ctx= new ClassPathXmlApplicationContext("beans.xml");
	@BeforeClass
	public static void beforeClass()
	{
		
	}
	
	@Test
	public void testInsertIntoPost(){
		System.out.println("*********InsertIntoPost**********");
		
		
		try {
			postService=(PostService) ctx.getBean(PostService.class);
			Post post=new Post();

			Forum forum=new Forum();
			forum.setId(1);
			post.setForum(forum);
			post.setCreateDt("2013-1-1");

			User u=new User();
			u.setUserId(1);
			post.setCreateUser(u);
			post.setLostMdyDt("2012-1-1");
			post.setPostContent("test 111");
			post.setPostTitle("这是关于Mysql的测试");
			postService.add(post);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getAllPost()
	{
		try {
			postService=(PostService) ctx.getBean(PostService.class);
			List<Post> listPost=new ArrayList<Post>();
			
			listPost=postService.selectAll();
			for(Post p:listPost)
			{
				System.out.println(p.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void updatePost()
	{
		postService=(PostService) ctx.getBean(PostService.class);
		Post post=new Post();

//		post.setPostId(3);
//		post.setForumId(1);
		post.setCreateDt("2012-1-1");
//		post.setCreateUser(2);
		post.setLostMdyDt("2012-1-1");
//		post.setPostContent();
//		post.setPostTitle("");
		
		
		try {
			postService.update(post);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getPostById()
	{
		postService=(PostService) ctx.getBean(PostService.class);
		try {
			Post post=postService.findById(18);
			System.out.println(post);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void findByFavouriteUser()
	{
		List<Integer> userList=new ArrayList<Integer>();
		userList.add(1);
		userList.add(2);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("userList", userList);
		map.put("days", 3);
		postService=(PostService) ctx.getBean(PostService.class);
		try {
			List<Post> postList=postService.findByFavouriteUser(map);
			for (Post p:postList) {
				System.out.println(p.toString());
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
