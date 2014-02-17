package com.diros.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;

import com.diros.model.FastThought;
import com.diros.service.FastThoughtService;
import com.diros.service.impl.FastThoughtServiceImpl;
import com.diros.web.FastThoughtyController;

public class TestFastThought {

	@Test
	public void testFastSelect()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("/beans.xml");
		FastThoughtService fast=context.getBean(FastThoughtServiceImpl.class);
		try {
			List<FastThought> list= fast.selectAll();

			for (FastThought f:list) {
				System.out.println(f.getUser());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
