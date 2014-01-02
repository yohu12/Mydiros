package com.diros.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diros.service.LocationService;

@Controller
@RequestMapping("/loc")
public class LocationController {
	
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
		return "location/add_location";
	}
}
