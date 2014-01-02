package com.diros.web;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.diros.model.Forum;
import com.diros.service.ForumService;
import com.diros.util.TotalAction;

@Controller
@RequestMapping("/forum")   
public class ForumController extends TotalAction{
	
	@Resource
	private ForumService forumService;
	
	/**
	 * 
	 * 功能：加载论坛板块
	 * @return
	 * author tanbiao
	 * date 2013-7-24
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String , Object> selectAll(ModelMap map){	
		try {
			List<Forum> lists =forumService.selectAll();
			System.out.println(lists);
			map.put("list", lists);
			map.put(RESULT_CODE, "success");
			
		}catch (CannotGetJdbcConnectionException e) {
			e.printStackTrace();
			map.put(RESULT_CODE, "fail");
			map.put(RESULT_MSG, "数据库连接失败，请稍后重试");
		}
		catch (Exception e) {
			e.printStackTrace();
			map.put(RESULT_CODE, "fail");
			map.put(RESULT_MSG, "加载失败");
		}
		
		return map;
	}
	
	/**
	 * 
	 * 功能：更新论坛板块
	 * @param forum
	 * @return
	 * author tanbiao
	 * date 2013-7-24
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public Map<String , Object> update(@RequestBody Forum forum, ModelMap map){
		
		System.out.println(forum);
		System.out.println("更新");
		System.out.println("size:"+map.size());
		Set<String> keys = map.keySet();
		for (String string : keys) {
			System.out.println(map.get(string));
		}
		
		map.put(RESULT_CODE, "success");
		
		return map;
	}
	/**
	 * 
	 * 功能：添加论坛板块
	 * @param forum
	 * @return
	 * author tanbiao
	 * date 2013-7-24
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String , Object> add(@RequestBody Forum forum ,ModelMap map){
		
		System.out.println(forum);
		System.out.println("添加");
		map.put(RESULT_MSG, "success");
		
		return map;
	}
	
	/**
	 * 
	 * 功能：删除板块
	 * @return
	 * author tanbiao
	 * date 2013-7-24
	 */
	@RequestMapping(value="/del",method=RequestMethod.POST)
	@ResponseBody
	public Map<String , Object> delete(@RequestParam String id ,ModelMap map){
		
		System.out.println(id);
		
		System.out.println("删除");
		
		map.put(RESULT_MSG, "success");
		
		return map;
	}
	
	/**
	 * 
	 * 功能：板块管理界面
	 * @return
	 * author tanbiao
	 * date 2013-7-24
	 */
	@RequestMapping(value="/forum_plate",method=RequestMethod.GET)
	public String loadForun(){
		System.out.println("加载板块");
		return "/forum/forum_plate";
	}
	
	@RequestMapping(value="/checkName",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> checkName(@RequestBody Forum forum ,String checkType ,ModelMap map){
		
		System.out.println("checkName");
		System.out.println(forum);
		map.put(RESULT_CODE, "success");
		return map;
	}
	
}
