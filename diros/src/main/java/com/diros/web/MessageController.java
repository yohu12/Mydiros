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
import com.diros.model.Message;
import com.diros.model.Post;
import com.diros.service.CommentsService;
import com.diros.service.MessageService;

import com.diros.service.PostService;
import com.diros.util.TimeConvert;
import com.diros.util.TotalAction;

@Controller
@RequestMapping("/message")   
public class MessageController extends TotalAction{
	
	@Resource
	private MessageService messageService;
	
	@RequestMapping(value = "/messageReceive", method = RequestMethod.GET)   
	public String getSendMessage(@RequestParam(value="userId")int userId,ModelMap map,HttpServletRequest request,HttpServletResponse response
			){
		System.out.println("***********getAllPost********");
		List<Message> messagesList = null;
		try {
			messagesList = messageService.findByReceiveUser(userId);
			
			for(Message m:messagesList)
			
			{
				System.out.println(m.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("messagesList",messagesList);
		 return "/msg/Message";
	}
	
	
	
}
