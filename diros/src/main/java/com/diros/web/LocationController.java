package com.diros.web;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diros.model.Location;
import com.diros.service.LocationService;
import com.diros.util.TotalAction;
import com.diros.model.Paging;;

@Controller
@RequestMapping("/loc")
public class LocationController extends TotalAction{
	
	@Resource
	private LocationService locationService;
	/**
	 * 
	 * 功能：跳转到添加同城后动页面
	 * @return
	 * author tan
	 * date 2013-8-21
	 */
	@RequestMapping("/new")
	public String loadAdd(){
		return "location/add";
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public String detail(@PathVariable("id") Integer id ,ModelMap map){
		
		try {
			Location location = this.locationService.findById(id);
			map.put("location", location);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			map.put("startTime", sdf.parse(location.getStartTime()));
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
			
		return "/location/detail";
	}
	
	@RequestMapping(value="list",method = RequestMethod.GET)
	public String list(Paging paging,ModelMap map , HttpServletRequest request){
		try {
			if(paging==null){//第一次进入时为null
				paging = new Paging();
			}
			System.out.println(paging.toString());
			if(paging.getCurrPage()!=1){
				paging.setStartRow((paging.getCurrPage()-1)*paging.getCounts());//得到开始行
			}else{
				paging.setStartRow(0);
			}
			List<Location> lists = this.locationService.selectPage(paging);
			
			System.out.println("分页结果"+lists);
			int AllCount = this.locationService.count();
			// 以下是固定写法
			Integer count=(AllCount)%paging.getCounts();
			if(count==0){
				paging.setMaxPage((AllCount)/paging.getCounts());
			}else{
				paging.setMaxPage((AllCount)/paging.getCounts()+1);
			}
			paging.setNextPage(paging.getCurrPage()+1);
			paging.setPrePage(paging.getCurrPage()-1);
			paging.setAllCount(AllCount);
			map.put("paging", paging);
			map.put("lists", lists);
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return "location/list";
	}
	
}
