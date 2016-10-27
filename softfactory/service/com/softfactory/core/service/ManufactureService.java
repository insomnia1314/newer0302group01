package com.softfactory.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.ManufactureMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Manufacture;

@Service("manufactureService")
public class ManufactureService {

	@Resource(name = "manufactureMapper")
	private ManufactureMapper manufactureMapper;

	public Pager<Manufacture> findPager(Integer pageno, Integer pagesize, String sort, String order, Integer id,
			String productName) {
		Pager<Manufacture> pager = new Pager<Manufacture>();
		pager.setRows(manufactureMapper.findPager(pageno, pagesize, sort, order, id, productName));
		pager.setTotal(manufactureMapper.findPagerTotal(id, productName));
		return pager;
	}
	
	public int add(Manufacture mf){
		return manufactureMapper.add(mf);
	}
}
