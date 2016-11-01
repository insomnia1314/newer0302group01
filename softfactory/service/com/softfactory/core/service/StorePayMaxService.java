package com.softfactory.core.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.StorePayMaxMapper;

@Service("storePayMaxService")
public class StorePayMaxService {
	@Resource(name = "storePayMaxMapper")
	private StorePayMaxMapper storePayMaxMapper;

	public String findByMax(){
		return storePayMaxMapper.findByMax();
	}
	
}
