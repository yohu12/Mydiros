package com.diros.web;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.diros.model.FastThought;
import com.diros.service.FastThoughtService;
import com.diros.service.MessageService;
import com.diros.util.TotalAction;

@Controller
@RequestMapping("/fastThought")
public class FastThoughtyController extends TotalAction{
	@Resource
	private FastThoughtService fastThoughtService;
	@RequestMapping(value="/showList",method=RequestMethod.GET)
	public String showList(ModelMap map) {
		
		try {
			List<FastThought> list= fastThoughtService.selectAll();
			
			for (FastThought f:list) {
				System.out.println(f.getThoughtTitle());
			}
			map.put("fastThoughtList", list);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "60s/60sList";
	}
	
	@RequestMapping("/showDetail")
	public String showDetail(@RequestParam(value="Id")int id,ModelMap map){
		System.out.println("60s id"+id);
		
		try {
			FastThought fastThought=fastThoughtService.findById(id);
			map.put("fastThought", fastThought);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "60s/60s_detail";
	}
}
