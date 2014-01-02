package com.diros.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.diros.mapper.LocationMapper;
import com.diros.model.Location;
import com.diros.service.LocationService;
import com.diros.util.Imapper;
import com.diros.util.ServiceImpl;


/**
 * 
 * @author tan
 *
 */
@Scope("prototype")
@Service
public class LocationServiceImpl extends ServiceImpl<Location> implements LocationService{

	@Autowired
	public void setMapper(LocationMapper locationMapper) {
		this.mapper = locationMapper;
	}
	
	
	
}
