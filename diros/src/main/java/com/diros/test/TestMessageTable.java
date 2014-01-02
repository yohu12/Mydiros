package com.diros.test;

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


import com.diros.model.Message;
import com.diros.model.Post;
import com.diros.model.User;
import com.diros.service.MessageService;
import com.diros.service.PostService;
import com.diros.service.impl.MessageServiceImpl;
import com.diros.util.TimeConvert;

public class TestMessageTable {
	
	@Resource
	private MessageService messageService;
	public ApplicationContext ctx= new ClassPathXmlApplicationContext("beans.xml");
	@BeforeClass
	public static void beforeClass()
	{
		
	}
	
	@Test
	public void testInsertIntoMessage(){
		System.out.println("*********InsertIntoMessage**********");
		
		
		try {
			messageService=(MessageServiceImpl) ctx.getBean(MessageService.class);
			Message message=new Message();
			message.setContent("这是关于Mysql 乱码的测试");
			User user=new User();
			user.setUserId(1);
			
			message.setFromUser(user);
			message.setGroupId(1);
//			message.setMessageId(messageId);
			message.setMsgTitle("Test");
			message.setSendDt(TimeConvert.timeToString(new Date()));
			User user2=new User();
			user2.setUserId(2);
			message.setToUser(user2);
			
			messageService.add(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testGetMessageInfo()
	{
		messageService=(MessageServiceImpl) ctx.getBean(MessageService.class);
		Message message = null;
		try {
			message = messageService.getMessageInfo(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(message);
	}
	
}
